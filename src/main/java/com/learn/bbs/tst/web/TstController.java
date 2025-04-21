package com.learn.bbs.tst.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.learn.bbs.tst.service.TstService;
import com.learn.bbs.tst.vo.SearchTstRequestVO;
import com.learn.bbs.tst.vo.TstCommonVO;
import com.learn.bbs.tst.vo.TstListVO;
import com.learn.bbs.tst.vo.TstVO;
import com.learn.bbs.usr.vo.UsrVO;
import com.learn.common.vo.AjaxResponse;


/**
 * @author 최예진
 * 시험
 */
@RestController
@RequestMapping("/usr/tst")
public class TstController {

    @Autowired
    private TstService tstService;

    @GetMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/list")
    public AjaxResponse viewTestList(
    			SearchTstRequestVO searchTstRequestVO,
    			@SessionAttribute("__LOGIN_USER__") UsrVO usrVO,
    			@PathVariable String insttnId,
    			@PathVariable String crsInfId,
    			@PathVariable String sbjId,
    			@PathVariable String artcId) {
    	
    	searchTstRequestVO.setUsrId(usrVO.getUsrId());
    	searchTstRequestVO.setArtcId(artcId);
    	searchTstRequestVO.setCrsInfId(crsInfId);
    	searchTstRequestVO.setSbjId(sbjId);
    	
    	TstListVO tstListVO = this.tstService.readAllTest(searchTstRequestVO);
    	return new AjaxResponse(tstListVO);
//    	return "/bbs/tst/tstboardvieweduad";
    }
    
    @GetMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/view/{tstId}")
    public AjaxResponse viewTest(
    		TstCommonVO tstCommonVO,
    			@SessionAttribute("__LOGIN_USER__") UsrVO usrVO,
    			@PathVariable String insttnId,
    			@PathVariable String crsInfId,
    			@PathVariable String sbjId,
    			@PathVariable String artcId,
    			@PathVariable String tstId) {
    	
    	tstCommonVO.setTstId(tstId);
    	tstCommonVO.setUsrId(usrVO.getUsrId());
    	tstCommonVO.setArtcId(artcId);
    	tstCommonVO.setCrsInfId(crsInfId);
    	tstCommonVO.setSbjId(sbjId);
    	
    	TstVO tstVO = this.tstService.readOneTest(tstCommonVO);
    	return new AjaxResponse(tstVO);
    }
    
}