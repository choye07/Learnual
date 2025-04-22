package com.learn.bbs.pltad.cnsl.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.learn.bbs.cnsl.service.CnslService;
import com.learn.bbs.cnsl.vo.CnslCommonVO;
import com.learn.bbs.cnsl.vo.CnslVO;
import com.learn.bbs.cnsl.vo.CreateCnslRequestVO;
import com.learn.bbs.cnsl.vo.SearchCnslRequestVO;
import com.learn.bbs.cnsl.vo.UpdateCnslRequestVO;
import com.learn.bbs.pltad.vo.PltadmVO;
import com.learn.bbs.usr.vo.UsrVO;
import com.learn.common.vo.AjaxResponse;


/**
 * @author 최예진
 * 상담
 */
@RestController
@RequestMapping("/pltad/cnsl")
public class PltadCnslController {

    @Autowired
    private CnslService cnslService;

    @PostMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/list")
    public AjaxResponse viewCnslList(
			SearchCnslRequestVO searchCnslRequestVO,
			@SessionAttribute("__LOGIN_PLTADM__") PltadmVO pltadmVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId) {
    	searchCnslRequestVO.setUsrId(pltadmVO.getPltadmId());
    	searchCnslRequestVO.setArtcId(artcId);
    	searchCnslRequestVO.setCrsInfId(crsInfId);
    	searchCnslRequestVO.setSbjId(sbjId);
    	searchCnslRequestVO.setRequesterType("pltad");
    	
    	List<CnslVO> cnslList = this.cnslService.readAllCnslList(searchCnslRequestVO);
    	return new AjaxResponse(cnslList);
    }
    
    @GetMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/view/{cnslId}")
    public AjaxResponse viewOneCnsl(
			CnslCommonVO cnslCommonVO,
			@SessionAttribute("__LOGIN_PLTADM__") PltadmVO pltadmVO,
			@PathVariable String cnslId,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId) {
    	
    	cnslCommonVO.setUsrId(pltadmVO.getPltadmId());
    	cnslCommonVO.setArtcId(artcId);
    	cnslCommonVO.setCrsInfId(crsInfId);
    	cnslCommonVO.setSbjId(sbjId);
    	cnslCommonVO.setCnslId(cnslId);
    	cnslCommonVO.setRequesterType("pltad");
    	
    	CnslVO cnsl = this.cnslService.readOneCnsl(cnslCommonVO);
    	return new AjaxResponse(cnsl);
    }
    
    @PostMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/create")
    public AjaxResponse createNewCnsl(
			CreateCnslRequestVO createCnslRequestVO,
			@SessionAttribute("__LOGIN_PLTADM__") PltadmVO pltadmVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId) {
    	
    	createCnslRequestVO.setUsrId(pltadmVO.getPltadmId());
    	createCnslRequestVO.setArtcId(artcId);
    	createCnslRequestVO.setCrsInfId(crsInfId);
    	createCnslRequestVO.setSbjId(sbjId);
    	createCnslRequestVO.setRequesterType("pltad");
    	
    	boolean createResult = this.cnslService.createNewCnsl(createCnslRequestVO);
    	return new AjaxResponse(createResult);
    }
    
    @PostMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/update/{cnslId}")
    public AjaxResponse updateOneCnsl(
			UpdateCnslRequestVO updateCnslRequestVO,
			@SessionAttribute("__LOGIN_PLTADM__") PltadmVO pltadmVO,
			@PathVariable String cnslId,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId) {
    	
    	updateCnslRequestVO.setUsrId(pltadmVO.getPltadmId());
    	updateCnslRequestVO.setArtcId(artcId);
    	updateCnslRequestVO.setCrsInfId(crsInfId);
    	updateCnslRequestVO.setSbjId(sbjId);
    	updateCnslRequestVO.setCnslId(cnslId);
    	updateCnslRequestVO.setRequesterType("pltad");
    	
    	boolean updateResult = this.cnslService.updateOneCnsl(updateCnslRequestVO);
    	return new AjaxResponse(updateResult);
    }
    
}