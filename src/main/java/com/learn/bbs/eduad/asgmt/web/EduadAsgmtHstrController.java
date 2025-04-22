package com.learn.bbs.eduad.asgmt.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.learn.bbs.asgmt.service.AsgmtHstrService;
import com.learn.bbs.asgmt.vo.AsgmtHstrCommonVO;
import com.learn.bbs.asgmt.vo.AsgmtHstrVO;
import com.learn.bbs.asgmt.vo.CreateAsgmtHstrRequestVO;
import com.learn.bbs.asgmt.vo.DeleteAsgmtHstrRequestVO;
import com.learn.bbs.asgmt.vo.SearchAsgmtHstrRequestVO;
import com.learn.bbs.pltad.instr.vo.InstrVO;
import com.learn.common.vo.AjaxResponse;

@RestController
@RequestMapping("/eduad/asgmt/hstr")
public class EduadAsgmtHstrController {

	@Autowired
	private AsgmtHstrService asgmtHstrService;
	
	@GetMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/{asgmtArtcId}/list")
    public AjaxResponse viewAsgmtHstrList(
    		SearchAsgmtHstrRequestVO searchAsgmtHstrRequestVO,
    		@SessionAttribute("__LOGIN_INSTR__") InstrVO instrVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId,
			@PathVariable String asgmtArtcId)  {
    	
		searchAsgmtHstrRequestVO.setAsgmtArtcId(asgmtArtcId);
		searchAsgmtHstrRequestVO.setUsrId(instrVO.getInstrId());
		searchAsgmtHstrRequestVO.setArtcId(artcId);
		searchAsgmtHstrRequestVO.setCrsInfId(crsInfId);
		searchAsgmtHstrRequestVO.setSbjId(sbjId);
		searchAsgmtHstrRequestVO.setRequesterType("eduad");
    	
    	List<AsgmtHstrVO> asgmtHistList = this.asgmtHstrService.readAsgmtHstrList(searchAsgmtHstrRequestVO);
    	return new AjaxResponse(asgmtHistList);
    }
	
	@GetMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/{asgmtArtcId}/{asgmtHstrId}/view")
    public AjaxResponse viewAsgmtHstr(
    		AsgmtHstrCommonVO asgmtHstrCommonVO,
    		@SessionAttribute("__LOGIN_INSTR__") InstrVO instrVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId,
			@PathVariable String asgmtArtcId,
			@PathVariable String asgmtHstrId)  {
    	
		asgmtHstrCommonVO.setAsgmtArtcId(asgmtArtcId);
		asgmtHstrCommonVO.setUsrId(instrVO.getInstrId());
		asgmtHstrCommonVO.setArtcId(artcId);
		asgmtHstrCommonVO.setCrsInfId(crsInfId);
		asgmtHstrCommonVO.setSbjId(sbjId);
		asgmtHstrCommonVO.setAsgmtHstrId(asgmtHstrId);
		asgmtHstrCommonVO.setRequesterType("eduad");
    	
    	AsgmtHstrVO asgmtHistList = this.asgmtHstrService.readOneAsgmtHstr(asgmtHstrCommonVO);
    	return new AjaxResponse(asgmtHistList);
    }
	
	@PostMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/{asgmtArtcId}/create")
    public AjaxResponse createAsgmtHstr(
    		CreateAsgmtHstrRequestVO createAsgmtHstrRequestVO,
    		@SessionAttribute("__LOGIN_INSTR__") InstrVO instrVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId,
			@PathVariable String asgmtArtcId)  {
    	
		createAsgmtHstrRequestVO.setAsgmtArtcId(asgmtArtcId);
		createAsgmtHstrRequestVO.setUsrId(instrVO.getInstrId());
		createAsgmtHstrRequestVO.setArtcId(artcId);
		createAsgmtHstrRequestVO.setCrsInfId(crsInfId);
		createAsgmtHstrRequestVO.setSbjId(sbjId);
		createAsgmtHstrRequestVO.setRequesterType("eduad");
    	
    	boolean createResult = this.asgmtHstrService.createNewAsgmtHstr(createAsgmtHstrRequestVO);
    	return new AjaxResponse(createResult);
    }
	
	@GetMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/{asgmtArtcId}/{asgmtHstrId}/delete")
    public AjaxResponse deleteAsgmtHstr(
    		DeleteAsgmtHstrRequestVO deleteAsgmtHstrRequestVO,
    		@SessionAttribute("__LOGIN_INSTR__") InstrVO instrVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId,
			@PathVariable String asgmtArtcId,
			@PathVariable String asgmtHstrId)  {
    	
		deleteAsgmtHstrRequestVO.setAsgmtArtcId(asgmtArtcId);
		deleteAsgmtHstrRequestVO.setUsrId(instrVO.getInstrId());
		deleteAsgmtHstrRequestVO.setArtcId(artcId);
		deleteAsgmtHstrRequestVO.setCrsInfId(crsInfId);
		deleteAsgmtHstrRequestVO.setSbjId(sbjId);
		deleteAsgmtHstrRequestVO.setAsgmtHstrId(asgmtHstrId);
		deleteAsgmtHstrRequestVO.setRequesterType("eduad");
    	
    	boolean deleteResult = this.asgmtHstrService.deleteOneAsgmtHstr(deleteAsgmtHstrRequestVO);
    	return new AjaxResponse(deleteResult);
    }
	
}
