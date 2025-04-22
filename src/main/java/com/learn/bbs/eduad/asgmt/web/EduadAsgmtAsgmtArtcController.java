package com.learn.bbs.eduad.asgmt.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.learn.bbs.asgmt.service.AsgmtArtcService;
import com.learn.bbs.asgmt.vo.AsgmtArtcVO;
import com.learn.bbs.asgmt.vo.CreateAsgmtArtcRequestVO;
import com.learn.bbs.asgmt.vo.DeleteAsgmtArtcRequestVO;
import com.learn.bbs.asgmt.vo.SearchAsgmtArtcRequestVO;
import com.learn.bbs.asgmt.vo.UpdateAsgmtArtcRequestVO;
import com.learn.bbs.pltad.instr.vo.InstrVO;
import com.learn.common.vo.AjaxResponse;

@RestController
@RequestMapping("/eduad/asgmt")
public class EduadAsgmtAsgmtArtcController {

	@Autowired
    private AsgmtArtcService asgmtArtcService;

    @GetMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/list")
    public AjaxResponse viewAsgmtArtcList(
    		SearchAsgmtArtcRequestVO searchAsgmtArtcRequestVO,
    		@SessionAttribute("__LOGIN_INSTR__") InstrVO instrVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId)  {
    	
    	searchAsgmtArtcRequestVO.setUsrId(instrVO.getInstrId());
    	searchAsgmtArtcRequestVO.setArtcId(artcId);
    	searchAsgmtArtcRequestVO.setCrsInfId(crsInfId);
    	searchAsgmtArtcRequestVO.setSbjId(sbjId);
    	searchAsgmtArtcRequestVO.setRequesterType("eduad");
    	
    	List<AsgmtArtcVO> asgmtArtcList = this.asgmtArtcService.readAllAsgmtArtc(searchAsgmtArtcRequestVO);
    	return new AjaxResponse(asgmtArtcList);
    }
    
    @GetMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/view/{asgmtArtcId}")
    public AjaxResponse viewAsgmtArtc(
    		SearchAsgmtArtcRequestVO searchAsgmtArtcRequestVO,
    		@SessionAttribute("__LOGIN_INSTR__") InstrVO instrVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId,
			@PathVariable String asgmtArtcId) {
    	
    	searchAsgmtArtcRequestVO.setUsrId(instrVO.getInstrId());
    	searchAsgmtArtcRequestVO.setArtcId(artcId);
    	searchAsgmtArtcRequestVO.setCrsInfId(crsInfId);
    	searchAsgmtArtcRequestVO.setSbjId(sbjId);
    	searchAsgmtArtcRequestVO.setAsgmtArtcId(asgmtArtcId);
    	searchAsgmtArtcRequestVO.setRequesterType("eduad");
    	
    	AsgmtArtcVO asgmtArtcVO = this.asgmtArtcService.readOneAsgmtArtc(searchAsgmtArtcRequestVO);
    	return new AjaxResponse(asgmtArtcVO);
    }
    
    @PostMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/create")
    public AjaxResponse createNewAsgmtArtc(CreateAsgmtArtcRequestVO createAsgmtArtcRequestVO,
    		@SessionAttribute("__LOGIN_INSTR__") InstrVO instrVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId) {
    	
    	createAsgmtArtcRequestVO.setUsrId(instrVO.getInstrId());
    	createAsgmtArtcRequestVO.setArtcId(artcId);
    	createAsgmtArtcRequestVO.setCrsInfId(crsInfId);
    	createAsgmtArtcRequestVO.setSbjId(sbjId);
    	createAsgmtArtcRequestVO.setRequesterType("eduad");
    	
    	boolean createResult = this.asgmtArtcService.createNewAsgmtArtc(createAsgmtArtcRequestVO);
    	return new AjaxResponse(createResult);
    }
    
    @PostMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/update/{asgmtArtcId}")
    public AjaxResponse updateOneTest(UpdateAsgmtArtcRequestVO updateAsgmtArtcRequestVO,
    		@SessionAttribute("__LOGIN_INSTR__") InstrVO instrVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId,
			@PathVariable String asgmtArtcId) {
    	
    	updateAsgmtArtcRequestVO.setAsgmtArtcId(asgmtArtcId);
    	updateAsgmtArtcRequestVO.setUsrId(instrVO.getInstrId());
    	updateAsgmtArtcRequestVO.setArtcId(artcId);
    	updateAsgmtArtcRequestVO.setCrsInfId(crsInfId);
    	updateAsgmtArtcRequestVO.setSbjId(sbjId);
    	updateAsgmtArtcRequestVO.setRequesterType("eduad");
    	
    	boolean updateResult = this.asgmtArtcService.updateOneAsmgtArtc(updateAsgmtArtcRequestVO);
    	return new AjaxResponse(updateResult);
    }
    
    @PostMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/update/{asgmtArtcId}")
    public AjaxResponse updateTestStat(UpdateAsgmtArtcRequestVO updateAsgmtArtcRequestVO,
    		@SessionAttribute("__LOGIN_INSTR__") InstrVO instrVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId,
			@PathVariable String asgmtArtcId) {
    	
    	updateAsgmtArtcRequestVO.setAsgmtArtcId(asgmtArtcId);
    	updateAsgmtArtcRequestVO.setUsrId(instrVO.getInstrId());
    	updateAsgmtArtcRequestVO.setArtcId(artcId);
    	updateAsgmtArtcRequestVO.setCrsInfId(crsInfId);
    	updateAsgmtArtcRequestVO.setSbjId(sbjId);
    	updateAsgmtArtcRequestVO.setRequesterType("eduad");
    	
    	boolean updateResult = this.asgmtArtcService.updateOneAsmgtArtc(updateAsgmtArtcRequestVO);
    	return new AjaxResponse(updateResult);
    }
    
    @GetMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/delete/{tstId}")
    public AjaxResponse updateTestStat(DeleteAsgmtArtcRequestVO deleteAsgmtArtcRequestVO,
    		@SessionAttribute("__LOGIN_INSTR__") InstrVO instrVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId,
			@PathVariable String asgmtArtcId) {
    	
    	deleteAsgmtArtcRequestVO.setAsgmtArtcId(asgmtArtcId);
    	deleteAsgmtArtcRequestVO.setUsrId(instrVO.getInstrId());
    	deleteAsgmtArtcRequestVO.setArtcId(artcId);
    	deleteAsgmtArtcRequestVO.setCrsInfId(crsInfId);
    	deleteAsgmtArtcRequestVO.setSbjId(sbjId);
    	deleteAsgmtArtcRequestVO.setRequesterType("eduad");
    	
    	boolean deleteResult = this.asgmtArtcService.deleteOneAsgmtArtc(deleteAsgmtArtcRequestVO);
    	return new AjaxResponse(deleteResult);
    }
    
}
