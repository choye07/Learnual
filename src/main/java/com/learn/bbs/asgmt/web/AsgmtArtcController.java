package com.learn.bbs.asgmt.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.learn.bbs.asgmt.service.AsgmtArtcService;
import com.learn.bbs.asgmt.vo.AsgmtArtcVO;
import com.learn.bbs.asgmt.vo.SearchAsgmtArtcRequestVO;
import com.learn.bbs.usr.vo.UsrVO;
import com.learn.common.vo.AjaxResponse;


/**
 * @author 최예진
 * 과제 게시판
 */
@RestController
@RequestMapping("/usr/asgmt")
public class AsgmtArtcController {

    @Autowired
    private AsgmtArtcService asgmtArtcService;

    @GetMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/list")
    public AjaxResponse viewAsgmtArtcList(
    		SearchAsgmtArtcRequestVO searchAsgmtArtcRequestVO,
			@SessionAttribute("__LOGIN_USER__") UsrVO usrVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId)  {
    	
    	searchAsgmtArtcRequestVO.setUsrId(usrVO.getUsrId());
    	searchAsgmtArtcRequestVO.setArtcId(artcId);
    	searchAsgmtArtcRequestVO.setCrsInfId(crsInfId);
    	searchAsgmtArtcRequestVO.setSbjId(sbjId);
    	searchAsgmtArtcRequestVO.setRequesterType("usr");
    	
    	List<AsgmtArtcVO> asgmtArtcList = this.asgmtArtcService.readAllAsgmtArtc(searchAsgmtArtcRequestVO);
    	return new AjaxResponse(asgmtArtcList);
    }
    
    @GetMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/view/{asgmtArtcId}")
    public AjaxResponse viewTest(
    		SearchAsgmtArtcRequestVO searchAsgmtArtcRequestVO,
			@SessionAttribute("__LOGIN_USER__") UsrVO usrVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId,
			@PathVariable String asgmtArtcId) {
    	
    	searchAsgmtArtcRequestVO.setUsrId(usrVO.getUsrId());
    	searchAsgmtArtcRequestVO.setArtcId(artcId);
    	searchAsgmtArtcRequestVO.setCrsInfId(crsInfId);
    	searchAsgmtArtcRequestVO.setSbjId(sbjId);
    	searchAsgmtArtcRequestVO.setAsgmtArtcId(asgmtArtcId);
    	searchAsgmtArtcRequestVO.setRequesterType("usr");
    	
    	AsgmtArtcVO asgmtArtcVO = this.asgmtArtcService.readOneAsgmtArtc(searchAsgmtArtcRequestVO);
    	return new AjaxResponse(asgmtArtcVO);
    }
    
}