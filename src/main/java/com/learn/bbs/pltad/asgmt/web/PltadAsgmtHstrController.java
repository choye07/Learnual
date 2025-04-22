package com.learn.bbs.pltad.asgmt.web;

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
import com.learn.bbs.pltad.vo.PltadmVO;
import com.learn.bbs.usr.vo.UsrVO;
import com.learn.common.vo.AjaxResponse;

@RestController
@RequestMapping("/pltad/asgmt/hstr")
public class PltadAsgmtHstrController {

	@Autowired
	private AsgmtHstrService asgmtHstrService;
	
	@GetMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/{asgmtArtcId}/list")
    public AjaxResponse viewAsgmtHstrList(
    		SearchAsgmtHstrRequestVO searchAsgmtHstrRequestVO,
    		@SessionAttribute("__LOGIN_PLTADM__") PltadmVO pltadmVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId,
			@PathVariable String asgmtArtcId)  {
    	
		searchAsgmtHstrRequestVO.setAsgmtArtcId(asgmtArtcId);
		searchAsgmtHstrRequestVO.setUsrId(pltadmVO.getPltadmId());
		searchAsgmtHstrRequestVO.setArtcId(artcId);
		searchAsgmtHstrRequestVO.setCrsInfId(crsInfId);
		searchAsgmtHstrRequestVO.setSbjId(sbjId);
		searchAsgmtHstrRequestVO.setRequesterType("pltad");
    	
    	List<AsgmtHstrVO> asgmtHistList = this.asgmtHstrService.readAsgmtHstrList(searchAsgmtHstrRequestVO);
    	return new AjaxResponse(asgmtHistList);
    }
	
	@GetMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/{asgmtArtcId}/{asgmtHstrId}/view")
    public AjaxResponse viewAsgmtHstr(
    		AsgmtHstrCommonVO asgmtHstrCommonVO,
    		@SessionAttribute("__LOGIN_PLTADM__") PltadmVO pltadmVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId,
			@PathVariable String asgmtArtcId,
			@PathVariable String asgmtHstrId)  {
    	
		asgmtHstrCommonVO.setAsgmtArtcId(asgmtArtcId);
		asgmtHstrCommonVO.setUsrId(pltadmVO.getPltadmId());
		asgmtHstrCommonVO.setArtcId(artcId);
		asgmtHstrCommonVO.setCrsInfId(crsInfId);
		asgmtHstrCommonVO.setSbjId(sbjId);
		asgmtHstrCommonVO.setAsgmtHstrId(asgmtHstrId);
		asgmtHstrCommonVO.setRequesterType("pltad");
    	
    	AsgmtHstrVO asgmtHistList = this.asgmtHstrService.readOneAsgmtHstr(asgmtHstrCommonVO);
    	return new AjaxResponse(asgmtHistList);
    }
	
	@PostMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/{asgmtArtcId}/create")
    public AjaxResponse createAsgmtHstr(
    		CreateAsgmtHstrRequestVO createAsgmtHstrRequestVO,
    		@SessionAttribute("__LOGIN_PLTADM__") PltadmVO pltadmVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId,
			@PathVariable String asgmtArtcId)  {
    	
		createAsgmtHstrRequestVO.setAsgmtArtcId(asgmtArtcId);
		createAsgmtHstrRequestVO.setUsrId(pltadmVO.getPltadmId());
		createAsgmtHstrRequestVO.setArtcId(artcId);
		createAsgmtHstrRequestVO.setCrsInfId(crsInfId);
		createAsgmtHstrRequestVO.setSbjId(sbjId);
		createAsgmtHstrRequestVO.setRequesterType("pltad");
    	
    	boolean createResult = this.asgmtHstrService.createNewAsgmtHstr(createAsgmtHstrRequestVO);
    	return new AjaxResponse(createResult);
    }
	
	@GetMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/{asgmtArtcId}/{asgmtHstrId}/delete")
    public AjaxResponse deleteAsgmtHstr(
    		DeleteAsgmtHstrRequestVO deleteAsgmtHstrRequestVO,
    		@SessionAttribute("__LOGIN_PLTADM__") PltadmVO pltadmVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId,
			@PathVariable String asgmtArtcId,
			@PathVariable String asgmtHstrId)  {
    	
		deleteAsgmtHstrRequestVO.setAsgmtArtcId(asgmtArtcId);
		deleteAsgmtHstrRequestVO.setUsrId(pltadmVO.getPltadmId());
		deleteAsgmtHstrRequestVO.setArtcId(artcId);
		deleteAsgmtHstrRequestVO.setCrsInfId(crsInfId);
		deleteAsgmtHstrRequestVO.setSbjId(sbjId);
		deleteAsgmtHstrRequestVO.setAsgmtHstrId(asgmtHstrId);
		deleteAsgmtHstrRequestVO.setRequesterType("pltad");
    	
    	boolean deleteResult = this.asgmtHstrService.deleteOneAsgmtHstr(deleteAsgmtHstrRequestVO);
    	return new AjaxResponse(deleteResult);
    }
	
}
