package com.learn.bbs.crs.crsinf.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.bbs.crs.crsinf.service.CrsInfService;
import com.learn.bbs.crs.crsinf.vo.CrsInfAbandonReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfAbandonUpdateRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfAvailableReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfCourseListReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfEndUpdateRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfModifyRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfPltadFinishedReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfPltadReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfRegistRequestVO;
import com.learn.bbs.crs.crspratt.vo.CrsPrattRegistRequestVO;
import com.learn.bbs.crs.sbj.vo.SbjVO;
import com.learn.bbs.pltad.cnfr.vo.CnfrHstrConfirmReadVO;
import com.learn.bbs.pltad.instr.vo.InstrVO;
import com.learn.bbs.pltad.vo.PltadmVO;
import com.learn.bbs.usr.vo.UsrVO;
import com.learn.exceptions.AccessDeniedException;
import com.learn.exceptions.CnfrHstrInsertException;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

/**
 * @author 최예진 강좌 정보
 */
@Controller
public class CrsInfController {
//	private static final Logger LOGGER = Logger.getClass(CrsInfController.class);

	@Autowired
	private CrsInfService crsInfService;

	@GetMapping("pltad/{insttnId}")
	public String showAllCourses(Model model, HttpSession session, @PathVariable String insttnId) {
		PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");

		// 만약 로그인이 안되어 있거나 플랫폼관리자의 계정으로 로그인 하지 않은 경우
		if (pltadmVO == null) {
			throw new AccessDeniedException();
		}
		
	    if (!insttnId.equals(pltadmVO.getInsttnId())) {
	        return "redirect:/pltad/" + pltadmVO.getInsttnId();
	    }

		List<CrsInfPltadReadResponseVO> activeCourses = this.crsInfService
				.selectAllCourseForPltad(pltadmVO.getInsttnId());
		List<CrsInfPltadFinishedReadResponseVO> inactiveCourses = this.crsInfService
				.selectAllFinishedCourseForPltad(pltadmVO.getInsttnId());
		List<CrsInfAbandonReadResponseVO> abandonCourses = this.crsInfService.selectAbandonCourse(pltadmVO.getInsttnId());

		model.addAttribute("activeCourses", activeCourses);
		model.addAttribute("inactiveCourses", inactiveCourses);
		model.addAttribute("abandonCourses", abandonCourses);

		return "/bbs/crs/coursemanage";
	}

	@GetMapping("/{insttnId}")
	public String showAvailableCourses(Model model, HttpSession session, @PathVariable String insttnId) {
		UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");
		PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
		InstrVO instrVO = (InstrVO) session.getAttribute("__LOGIN_INSTR__");

	    // 현재 로그인한 사용자가 회원, 플랫폼 관리자, 강사 중 누구인지에 따라 insttnId 가져오는 기준 변경
	    String nowInsttnId = null;
	    if (usrVO != null) {
	        nowInsttnId = usrVO.getInsttnId();
	    } else if (pltadmVO != null) {
	        nowInsttnId = pltadmVO.getInsttnId();
	    } else if (instrVO != null) {
	        nowInsttnId = instrVO.getInsttnId();
	        model.addAttribute("instrCourses", this.crsInfService.selectFourCoursesForInstr(instrVO.getInstrId(), nowInsttnId));
	    }

		// 만약 세션의 insttnId과 endpoint의 insttnId가 다르면 현재 유저가 로그인한 insttnId로 변경하여 redirect
		if(!insttnId.equals(nowInsttnId)) {
			return "redirect:/" + nowInsttnId;
		}
		
		CrsInfCourseListReadResponseVO result = this.crsInfService.selectAvailableFourCoursesWithStatus(
				usrVO != null ? usrVO.getUsrMl() : null, insttnId
				);

		model.addAttribute("availableCourses", result.getCourseList());
		model.addAttribute("isRegistered", result.getIsRegistered());

		model.addAttribute("isStudent", usrVO != null);
		model.addAttribute("isAdmin", pltadmVO != null);
		model.addAttribute("isInstr", instrVO != null);

		return "insttn/maininsttn";
	}

	// 신청 가능한 강좌들을 보여준다
	@GetMapping("usr/{insttnId}")
	public String showAvailableCoursesForUser(Model model, HttpSession session, @PathVariable String insttnId) {
		UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");

		List<CrsInfAvailableReadResponseVO> availableCourses = this.crsInfService
				.selectRegisterableCourses(usrVO.getInsttnId());

		if(!insttnId.equals(usrVO.getInsttnId())) {
			return "redirect:/usr/" + usrVO.getInsttnId();
		}
		
		model.addAttribute("isUsr", true);
		
		model.addAttribute("availableCourses", availableCourses);

		return "/bbs/crs/courseregist";
	}
	
	@GetMapping("/usr/{insttnId}/{crsInfId}/course")
	public String showMyRegisteredCourse(@PathVariable String insttnId,
										 @PathVariable String crsInfId,
										 Model model,
										 HttpSession session) {
		UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");

		if(!insttnId.equals(usrVO.getInsttnId())) {
			return "redirect:/usr/" + usrVO.getInsttnId() + "/" + crsInfId + "/course";
		}
		
		model.addAttribute("insttnId", insttnId);
		model.addAttribute("courseDetail", this.crsInfService.selectCourseDetail(crsInfId, usrVO.getInsttnId()));
		
		return "bbs/crs/maincourse";
	}

	@GetMapping("usr/{insttnId}/{crsInfId}/detail")
	public String showAllAvailableForUser(@PathVariable String insttnId,
										  @PathVariable String crsInfId,
										  Model model, HttpSession session) {
		PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");
		UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");

		// 현재 로그인한 사용자가 회원인지 플랫폼관리자인지에 따라 insttnId 가져오는 기준이 바뀐다.
	    String nowInsttnId = usrVO != null ? usrVO.getInsttnId() : (pltadmVO != null ? pltadmVO.getInsttnId() : null);
		
		if (!insttnId.equals(nowInsttnId)) {
	        return "redirect:/" + nowInsttnId + "/" + crsInfId + "/detail";
	    }
		
		if (pltadmVO != null) {
			// 플랫폼 관리자일 경우; 신청 버튼 보여줄 필요 없다
			model.addAttribute("isPltadm", true);
		} else if (usrVO != null) {
			// 일반 사용자일 경우; 어떤 버튼을 보여줘야 하는가 알려줘야함
			model.addAttribute("isPltadm", false);
			model.addAttribute("isLoginUser", true);
			
			// 유저 이메일, 유저가 속한 기관 추가
			String usrMl = usrVO.getUsrMl();
			String usrInsttnId = usrVO.getInsttnId();

			boolean showCancelButton = crsInfService.isAppliedOrCancelled(crsInfId, usrMl, usrInsttnId);
			model.addAttribute("showCancelButton", showCancelButton);
		} else {
			// 로그인 안 된 경우
			model.addAttribute("isPltadm", false);
			model.addAttribute("isLoginUser", false);
		}
		
		model.addAttribute("insttnId", nowInsttnId);
		model.addAttribute("courseDetail", this.crsInfService.selectCourseDetail(crsInfId, nowInsttnId));
		model.addAttribute("instrName", this.crsInfService.selectOneInstrName(crsInfId));

		return "/bbs/crs/coursedetail";
	}

	@GetMapping("/pltad/{insttnId}/{crsInfId}/detail")
	public String showAllAvailableForPltAd(@PathVariable String insttnId,
										   @PathVariable String crsInfId, 
										   Model model, 
										   HttpSession session) {
		PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");

		// 만약 로그인이 안되어 있거나 플랫폼관리자의 계정으로 로그인 하지 않은 경우
		if (pltadmVO == null) {
			throw new AccessDeniedException();
		}
		
		// URL insttnId와 세션 insttnId가 다르면 강제로 리다이렉트
		if (!insttnId.equals(pltadmVO.getInsttnId())) {
		    return "redirect:/pltad/" + pltadmVO.getInsttnId() + "/" + crsInfId + "/detail";
		}

		model.addAttribute("insttnId", pltadmVO.getInsttnId());
		model.addAttribute("isPltadm", true);
		model.addAttribute("courseDetail", this.crsInfService.selectCourseDetail(crsInfId, pltadmVO.getInsttnId()));
		model.addAttribute("instrName", this.crsInfService.selectOneInstrName(crsInfId));

		return "/bbs/crs/coursedetail";
	}

	@GetMapping("pltad/{insttnId}/create")
	public String showSubjectList(@PathVariable String insttnId,
								  Model model, 
								  HttpSession session) {
		PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");

		if (pltadmVO == null) {
			throw new AccessDeniedException();
		}

		String nowInsttnId = pltadmVO.getInsttnId();
		
	    if (!insttnId.equals(nowInsttnId)) {
	        return "redirect:/pltad/" + nowInsttnId + "/create"; 
	    }
		
		List<SbjVO> subjectList = crsInfService.getSubjectList();
		List<InstrVO> instrList = crsInfService.getInstrList();

		model.addAttribute("insttnId", nowInsttnId);
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("instrList", instrList);
		model.addAttribute("insttnId", nowInsttnId);

		return "bbs/crs/coursecreate";
	}

	@PostMapping("pltad/{insttnId}/create")
	public String registerCourse(@PathVariable String insttnId,
								 @Valid CrsInfRegistRequestVO crsInfRegistRequestVO, BindingResult bindingResult,
								 Model model, HttpSession session) {
		PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");

		// 만약 로그인이 안되어 있거나 플랫폼관리자의 계정으로 로그인 하지 않은 경우
		if (pltadmVO == null) {
			throw new AccessDeniedException();
		}

		List<SbjVO> subjectList = crsInfService.getSubjectList();
		List<InstrVO> instrList = crsInfService.getInstrList();

		if (bindingResult.hasErrors()) {
			model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
			model.addAttribute("selectedInstr", crsInfRegistRequestVO.getInstrId());
			model.addAttribute("subjectList", subjectList);
			model.addAttribute("instrList", instrList);
			model.addAttribute("userRegistInfo", crsInfRegistRequestVO);

			return "/bbs/crs/coursecreate";
		}

		if (this.crsInfService.countCourseName(crsInfRegistRequestVO.getCrsInfNm(), pltadmVO.getInsttnId())) {
			model.addAttribute("duplicateTitleError", "이미 등록된 강좌 이름입니다. 다른 이름을 입력해주세요.");
			model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
			model.addAttribute("selectedInstr", crsInfRegistRequestVO.getInstrId());
			model.addAttribute("subjectList", subjectList);
			model.addAttribute("instrList", instrList);
			model.addAttribute("userRegistInfo", crsInfRegistRequestVO);

			return "/bbs/crs/coursecreate";
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

		LocalDateTime crsInfStDt = LocalDateTime.parse(crsInfRegistRequestVO.getCrsInfStDt(), formatter);
		LocalDateTime crsInfEndDt = LocalDateTime.parse(crsInfRegistRequestVO.getCrsInfEndDt(), formatter);
		LocalDateTime crsInfAppDt = LocalDateTime.parse(crsInfRegistRequestVO.getCrsInfAppDt(), formatter);
		LocalDateTime crsInfDdlnDt = LocalDateTime.parse(crsInfRegistRequestVO.getCrsInfDdlnDt(), formatter);

		LocalDateTime today = LocalDateTime.now();

		if (crsInfStDt.isBefore(today)) {
			model.addAttribute("crsInfStDtThanToday", "강좌 시작일은 오늘 이후여야 합니다.");
			model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
			model.addAttribute("selectedInstr", crsInfRegistRequestVO.getInstrId());
			model.addAttribute("subjectList", subjectList);
			model.addAttribute("instrList", instrList);
			model.addAttribute("userRegistInfo", crsInfRegistRequestVO);

			return "/bbs/crs/coursecreate";
		}

		if (crsInfEndDt.isBefore(today)) {
			model.addAttribute("crsInfEndDtThanToday", "강좌 종료일은 오늘 이후여야 합니다.");
			model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
			model.addAttribute("selectedInstr", crsInfRegistRequestVO.getInstrId());
			model.addAttribute("subjectList", subjectList);
			model.addAttribute("instrList", instrList);
			model.addAttribute("userRegistInfo", crsInfRegistRequestVO);

			return "/bbs/crs/coursecreate";
		}

		if (crsInfAppDt.isBefore(today)) {
			model.addAttribute("crsInfAppDtThanToday", "강좌 신청일은 오늘 이후여야 합니다.");
			model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
			model.addAttribute("selectedInstr", crsInfRegistRequestVO.getInstrId());
			model.addAttribute("subjectList", subjectList);
			model.addAttribute("instrList", instrList);
			model.addAttribute("userRegistInfo", crsInfRegistRequestVO);

			return "/bbs/crs/coursecreate";
		}

		if (crsInfDdlnDt.isBefore(today)) {
			model.addAttribute("crsInfDdlnDtThanToday", "강좌 마감일은 오늘 이후여야 합니다.");
			model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
			model.addAttribute("selectedInstr", crsInfRegistRequestVO.getInstrId());
			model.addAttribute("subjectList", subjectList);
			model.addAttribute("instrList", instrList);
			model.addAttribute("userRegistInfo", crsInfRegistRequestVO);

			return "/bbs/crs/coursecreate";
		}

		if (crsInfEndDt.isBefore(crsInfStDt)) {
			if (crsInfDdlnDt.isBefore(crsInfAppDt)) { // 강좌 시작/신청 시작일이 둘다 느림
				model.addAttribute("crsLateErrorMessage", "강좌 종료일은 강좌 시작일 이후여야 합니다.");
				model.addAttribute("appLateErrorMessage", "신청 마감일은 신청 시작일 이후여야 합니다.");
				model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
				model.addAttribute("selectedInstr", crsInfRegistRequestVO.getInstrId());
				model.addAttribute("subjectList", subjectList);
				model.addAttribute("instrList", instrList);
				model.addAttribute("userRegistInfo", crsInfRegistRequestVO);

				return "/bbs/crs/coursecreate";
			}
			// 강좌 시작일만 느림
			model.addAttribute("crsLateErrorMessage", "강좌 종료일은 강좌 시작일 이후여야 합니다.");
			model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
			model.addAttribute("selectedInstr", crsInfRegistRequestVO.getInstrId());
			model.addAttribute("subjectList", subjectList);
			model.addAttribute("instrList", instrList);
			model.addAttribute("userRegistInfo", crsInfRegistRequestVO);

			return "/bbs/crs/coursecreate";
		} else {
			if (crsInfDdlnDt.isBefore(crsInfAppDt)) { // 강좌 신청일만 느림
				model.addAttribute("appLateErrorMessage", "신청 마감일은 신청 시작일 이후여야 합니다.");
				model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
				model.addAttribute("selectedInstr", crsInfRegistRequestVO.getInstrId());
				model.addAttribute("subjectList", subjectList);
				model.addAttribute("instrList", instrList);
				model.addAttribute("userRegistInfo", crsInfRegistRequestVO);

				return "/bbs/crs/coursecreate";
			}
		}

		if (crsInfDdlnDt.isAfter(crsInfStDt)) {
			model.addAttribute("appDtAfterThanStDt", "강좌 시작일은 신청 마감일 이후여야 합니다.");
			model.addAttribute("selectedSubjects", crsInfRegistRequestVO.getSubjects());
			model.addAttribute("selectedInstr", crsInfRegistRequestVO.getInstrId());
			model.addAttribute("subjectList", subjectList);
			model.addAttribute("instrList", instrList);
			model.addAttribute("userRegistInfo", crsInfRegistRequestVO);

			return "/bbs/crs/coursecreate";
		}

		DateTimeFormatter resetFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		crsInfRegistRequestVO.setCrsInfStDt(crsInfStDt.format(resetFormatter));
		crsInfRegistRequestVO.setCrsInfEndDt(crsInfEndDt.format(resetFormatter));
		crsInfRegistRequestVO.setCrsInfAppDt(crsInfAppDt.format(resetFormatter));
		crsInfRegistRequestVO.setCrsInfDdlnDt(crsInfDdlnDt.format(resetFormatter));

		// 기관 아이디 추가
		crsInfRegistRequestVO.setInsttnId(pltadmVO.getInsttnId());

		this.crsInfService.insertOneCourse(crsInfRegistRequestVO);

		return "redirect:/pltad/" + pltadmVO.getInsttnId();
	}

	@GetMapping("/pltad/{insttnId}/{crsInfId}/modify")
	public String goModifyCourse(@PathVariable String insttnId,
								 @PathVariable String crsInfId, 
								 Model model, HttpSession session) {
		PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");

		// 만약 로그인이 안되어 있거나 플랫폼관리자의 계정으로 로그인 하지 않은 경우
		if (pltadmVO == null) {
			throw new AccessDeniedException();
		}

	    String nowInsttnId = pltadmVO.getInsttnId();

	    if (!insttnId.equals(nowInsttnId)) {
	        return "redirect:/pltad/" + nowInsttnId + "/" + crsInfId + "/modify";
	    }
		
		CrsInfModifyRequestVO courseInfo = this.crsInfService.selectAllInfoFromOneCourse(crsInfId,
				pltadmVO.getInsttnId());

		List<SbjVO> subjectList = this.crsInfService.getSubjectList();
		List<InstrVO> instrList = this.crsInfService.getInstrList();

		model.addAttribute("insttnId", nowInsttnId);
		model.addAttribute("userRegistInfo", courseInfo);
		model.addAttribute("selectedSubjects", courseInfo.getSubjects());
		model.addAttribute("selectedInstr", courseInfo.getInstrId());
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("instrList", instrList);

		return "/bbs/crs/coursemodify";
	}

	@PostMapping("/pltad/{insttnId}/{crsInfId}/modify")
	public String doModifyCourse(@Valid CrsInfModifyRequestVO crsInfModifyRequestVO, BindingResult bindingResult,
			Model model, HttpSession session) {
		PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");

		// 만약 로그인이 안되어 있거나 플랫폼관리자의 계정으로 로그인 하지 않은 경우
		if (pltadmVO == null) {
			throw new AccessDeniedException();
		}

		List<SbjVO> subjectList = this.crsInfService.getSubjectList();
		List<InstrVO> instrList = this.crsInfService.getInstrList();

		if (bindingResult.hasErrors()) {
			model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
			model.addAttribute("selectedInstr", crsInfModifyRequestVO.getInstrId());
			model.addAttribute("subjectList", subjectList);
			model.addAttribute("instrList", instrList);
			model.addAttribute("userRegistInfo", crsInfModifyRequestVO);

			return "/bbs/crs/coursemodify";
		}

		String newName = crsInfModifyRequestVO.getCrsInfNm();
		String currentName = crsInfService.selectCourseName(crsInfModifyRequestVO.getCrsInfId(),
				pltadmVO.getInsttnId());

		// 동일한 강좌 이름이 존재하나, 그것이 현재의 강좌 이름이 아닐 경우 중복
		if (crsInfService.countCourseName(newName, pltadmVO.getInsttnId()) && !newName.equals(currentName)) {
			model.addAttribute("duplicateTitleError", "이미 등록된 강좌 이름입니다. 다른 이름을 입력해주세요.");
			model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
			model.addAttribute("selectedInstr", crsInfModifyRequestVO.getInstrId());
			model.addAttribute("subjectList", subjectList);
			model.addAttribute("instrList", instrList);
			model.addAttribute("userRegistInfo", crsInfModifyRequestVO);

			return "/bbs/crs/coursemodify";
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

		LocalDateTime crsInfStDt = LocalDateTime.parse(crsInfModifyRequestVO.getCrsInfStDt(), formatter);
		LocalDateTime crsInfEndDt = LocalDateTime.parse(crsInfModifyRequestVO.getCrsInfEndDt(), formatter);
		LocalDateTime crsInfAppDt = LocalDateTime.parse(crsInfModifyRequestVO.getCrsInfAppDt(), formatter);
		LocalDateTime crsInfDdlnDt = LocalDateTime.parse(crsInfModifyRequestVO.getCrsInfDdlnDt(), formatter);

		LocalDateTime today = LocalDateTime.now();

		if (crsInfStDt.isBefore(today)) {
			model.addAttribute("crsInfStDtThanToday", "강좌 시작일은 오늘 이후여야 합니다.");
			model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
			model.addAttribute("selectedInstr", crsInfModifyRequestVO.getInstrId());
			model.addAttribute("subjectList", subjectList);
			model.addAttribute("instrList", instrList);
			model.addAttribute("userRegistInfo", crsInfModifyRequestVO);

			return "/bbs/crs/coursemodify";
		}

		if (crsInfEndDt.isBefore(today)) {
			model.addAttribute("crsInfEndDtThanToday", "강좌 종료일은 오늘 이후여야 합니다.");
			model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
			model.addAttribute("selectedInstr", crsInfModifyRequestVO.getInstrId());
			model.addAttribute("subjectList", subjectList);
			model.addAttribute("instrList", instrList);
			model.addAttribute("userRegistInfo", crsInfModifyRequestVO);

			return "/bbs/crs/coursemodify";
		}

		if (crsInfAppDt.isBefore(today)) {
			model.addAttribute("crsInfAppDtThanToday", "강좌 신청일은 오늘 이후여야 합니다.");
			model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
			model.addAttribute("selectedInstr", crsInfModifyRequestVO.getInstrId());
			model.addAttribute("subjectList", subjectList);
			model.addAttribute("instrList", instrList);
			model.addAttribute("userRegistInfo", crsInfModifyRequestVO);

			return "/bbs/crs/coursemodify";
		}

		if (crsInfDdlnDt.isBefore(today)) {
			model.addAttribute("crsInfDdlnDtThanToday", "강좌 마감일은 오늘 이후여야 합니다.");
			model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
			model.addAttribute("selectedInstr", crsInfModifyRequestVO.getInstrId());
			model.addAttribute("subjectList", subjectList);
			model.addAttribute("instrList", instrList);
			model.addAttribute("userRegistInfo", crsInfModifyRequestVO);

			return "/bbs/crs/coursemodify";
		}

		if (crsInfEndDt.isBefore(crsInfStDt)) {
			if (crsInfDdlnDt.isBefore(crsInfAppDt)) { // 강좌 시작/신청 시작일이 둘다 느림
				model.addAttribute("crsLateErrorMessage", "강좌 종료일은 강좌 시작일 이후여야 합니다.");
				model.addAttribute("appLateErrorMessage", "신청 마감일은 신청 시작일 이후여야 합니다.");
				model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
				model.addAttribute("selectedInstr", crsInfModifyRequestVO.getInstrId());
				model.addAttribute("subjectList", subjectList);
				model.addAttribute("instrList", instrList);
				model.addAttribute("userRegistInfo", crsInfModifyRequestVO);

				return "/bbs/crs/coursemodify";
			}
			// 강좌 시작일만 느림
			model.addAttribute("crsLateErrorMessage", "강좌 종료일은 강좌 시작일 이후여야 합니다.");
			model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
			model.addAttribute("selectedInstr", crsInfModifyRequestVO.getInstrId());
			model.addAttribute("subjectList", subjectList);
			model.addAttribute("instrList", instrList);
			model.addAttribute("userRegistInfo", crsInfModifyRequestVO);

			return "/bbs/crs/coursemodify";
		} else {
			if (crsInfDdlnDt.isBefore(crsInfAppDt)) { // 강좌 신청일만 느림
				model.addAttribute("appLateErrorMessage", "신청 마감일은 신청 시작일 이후여야 합니다.");
				model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
				model.addAttribute("selectedInstr", crsInfModifyRequestVO.getInstrId());
				model.addAttribute("subjectList", subjectList);
				model.addAttribute("instrList", instrList);
				model.addAttribute("userRegistInfo", crsInfModifyRequestVO);

				return "/bbs/crs/coursemodify";
			}
		}

		if (crsInfDdlnDt.isAfter(crsInfStDt)) {
			model.addAttribute("appDtAfterThanStDt", "강좌 시작일은 신청 마감일 이후여야 합니다.");
			model.addAttribute("selectedSubjects", crsInfModifyRequestVO.getSubjects());
			model.addAttribute("selectedInstr", crsInfModifyRequestVO.getInstrId());
			model.addAttribute("subjectList", subjectList);
			model.addAttribute("instrList", instrList);
			model.addAttribute("userRegistInfo", crsInfModifyRequestVO);

			return "/bbs/crs/coursemodify";
		}

		DateTimeFormatter resetFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		crsInfModifyRequestVO.setCrsInfStDt(crsInfStDt.format(resetFormatter));
		crsInfModifyRequestVO.setCrsInfEndDt(crsInfEndDt.format(resetFormatter));
		crsInfModifyRequestVO.setCrsInfAppDt(crsInfAppDt.format(resetFormatter));
		crsInfModifyRequestVO.setCrsInfDdlnDt(crsInfDdlnDt.format(resetFormatter));

		// 기관 아이디 추가
		crsInfModifyRequestVO.setInsttnId(pltadmVO.getInsttnId());

		this.crsInfService.updateOneCourse(crsInfModifyRequestVO);

		return "redirect:/pltad/" + pltadmVO.getInsttnId();
	}

	// 삭제
	@PostMapping("/pltad/{insttnId}/{crsInfId}/delete")
	public String doDeleteCourse(@PathVariable String crsInfId, HttpSession session) {
		PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");

		// 만약 로그인이 안되어 있거나 플랫폼관리자의 계정으로 로그인 하지 않은 경우
		if (pltadmVO == null) {
			throw new AccessDeniedException();
		}

		this.crsInfService.deleteOneCourse(crsInfId, pltadmVO.getInsttnId());

		return "redirect:/pltad/" + pltadmVO.getInsttnId();
	}

	// 마감
	@PostMapping("/pltad/{insttnId}/{crsInfId}/end")
	public String doEndCourse(@PathVariable String crsInfId, HttpSession session) {
		PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");

		// 만약 로그인이 안되어 있거나 플랫폼관리자의 계정으로 로그인 하지 않은 경우
		if (pltadmVO == null) {
			throw new AccessDeniedException();
		}

		CrsInfEndUpdateRequestVO crsInfEndUpdateRequestVO = new CrsInfEndUpdateRequestVO();

		crsInfEndUpdateRequestVO.setCrsInfId(crsInfId);
		
		// 기관아이디 추가
		crsInfEndUpdateRequestVO.setInsttnId(pltadmVO.getInsttnId());
		
		this.crsInfService.endOneCourse(crsInfEndUpdateRequestVO);

		try {
			this.crsInfService.insertRegisteredUsers(pltadmVO.getInsttnId());
		} catch (CnfrHstrInsertException e) {

		}

		return "redirect:/pltad/" + pltadmVO.getInsttnId();
	}

	@GetMapping("/pltad/{insttnId}/{crsInfId}/confirm")
	public String showConfirmedUsers(@PathVariable String insttnId,
									 @PathVariable String crsInfId, 
									 Model model, HttpSession session) {
		PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");

		// 만약 로그인이 안되어 있거나 플랫폼관리자의 계정으로 로그인 하지 않은 경우
		if (pltadmVO == null) {
			throw new AccessDeniedException();
		}
		
	    String nowInsttnId = pltadmVO.getInsttnId();

	    // URL insttnId와 세션 insttnId가 다르면 강제로 리다이렉트
	    if (!insttnId.equals(nowInsttnId)) {
	        return "redirect:/pltad/" + nowInsttnId + "/" + crsInfId + "/confirm";
	    }

		List<CnfrHstrConfirmReadVO> users = this.crsInfService.getConfirmedUsers(crsInfId, pltadmVO.getInsttnId());
		String crsInfNm = this.crsInfService.selectCourseName(crsInfId, pltadmVO.getInsttnId());
		
		model.addAttribute("insttnId", nowInsttnId);
		model.addAttribute("courseName", crsInfNm);
		model.addAttribute("confirmedUsers", users);
		model.addAttribute("CrsPrattRegistRequestVO", new CrsPrattRegistRequestVO());

		return "bbs/crs/courseconfirm";
	}

	// 확정
	@PostMapping("/pltad/{insttnId}/{crsInfId}/confirm")
	public String doSavingConfirmedUsersToPratt(@PathVariable String crsInfId,
			@ModelAttribute CrsPrattRegistRequestVO crsPrattRegistRequestVO, HttpSession session) {
		PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");

		// 만약 로그인이 안되어 있거나 플랫폼관리자의 계정으로 로그인 하지 않은 경우
		if (pltadmVO == null) {
			throw new AccessDeniedException();
		}

		// 기관 아이디 추가
		crsPrattRegistRequestVO.setInsttnId(pltadmVO.getInsttnId());
		
		// 서비스에서 선택된 사용자만 처리하도록 호출
		this.crsInfService.saveConfirmedUsersToPratt(crsPrattRegistRequestVO);

		return "redirect:/pltad/" + pltadmVO.getInsttnId();
	}

	// 폐강
	@PostMapping("pltad/{insttnId}/{crsInfId}/abandon")
	public String doAbandonCourse(@PathVariable String crsInfId, HttpSession session) {
		PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");

		// 만약 로그인이 안되어 있거나 플랫폼관리자의 계정으로 로그인 하지 않은 경우
		if (pltadmVO == null) {
			throw new AccessDeniedException();
		}

		CrsInfAbandonUpdateRequestVO crsInfAbandonUpdateRequestVO = new CrsInfAbandonUpdateRequestVO();

		crsInfAbandonUpdateRequestVO.setCrsInfId(crsInfId);
		
		// 기관아이디 추가
		crsInfAbandonUpdateRequestVO.setInsttnId(pltadmVO.getInsttnId());

		this.crsInfService.abandonOneCourse(crsInfAbandonUpdateRequestVO);

		return "redirect:/pltad/" + pltadmVO.getInsttnId();
	}
}
