package com.learn.bbs.eduad.tst.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.learn.bbs.tst.service.TstService;
import com.learn.bbs.tst.vo.CreateTstRequestVO;
import com.learn.bbs.tst.vo.DeleteTstRequestVO;
import com.learn.bbs.tst.vo.SearchTstRequestVO;
import com.learn.bbs.tst.vo.TstCommonVO;
import com.learn.bbs.tst.vo.TstListVO;
import com.learn.bbs.tst.vo.TstVO;
import com.learn.bbs.tst.vo.UpdateTstRequestVO;
import com.learn.bbs.usr.vo.UsrVO;
import com.learn.common.vo.AjaxResponse;

@RestController
@RequestMapping("/eduad/tst")
public class EduadTstController {


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
    
    @PostMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/create")
    public AjaxResponse createNewTest(CreateTstRequestVO createTstRequestVO,
    		@SessionAttribute("__LOGIN_USER__") UsrVO usrVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId) {
    	
    	createTstRequestVO.setUsrId(usrVO.getUsrId());
    	createTstRequestVO.setArtcId(artcId);
    	createTstRequestVO.setCrsInfId(crsInfId);
    	createTstRequestVO.setSbjId(sbjId);
    	
    	boolean createResult = this.tstService.createNewTest(createTstRequestVO);
    	return new AjaxResponse(createResult);
    }
    
    @PostMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/update/{tstId}")
    public AjaxResponse updateOneTest(UpdateTstRequestVO updateTstRequestVO,
    		@SessionAttribute("__LOGIN_USER__") UsrVO usrVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId,
			@PathVariable String tstId) {
    	
    	updateTstRequestVO.setTstId(tstId);
    	updateTstRequestVO.setUsrId(usrVO.getUsrId());
    	updateTstRequestVO.setArtcId(artcId);
    	updateTstRequestVO.setCrsInfId(crsInfId);
    	updateTstRequestVO.setSbjId(sbjId);
    	
    	boolean updateResult = this.tstService.updateOneTest(updateTstRequestVO);
    	return new AjaxResponse(updateResult);
    }
    
    @PostMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/update/{tstId}/stat")
    public AjaxResponse updateTestStat(UpdateTstRequestVO updateTstRequestVO,
    		@SessionAttribute("__LOGIN_USER__") UsrVO usrVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId,
			@PathVariable String tstId) {
    	
    	updateTstRequestVO.setTstId(tstId);
    	updateTstRequestVO.setUsrId(usrVO.getUsrId());
    	updateTstRequestVO.setArtcId(artcId);
    	updateTstRequestVO.setCrsInfId(crsInfId);
    	updateTstRequestVO.setSbjId(sbjId);
    	
    	boolean updateResult = this.tstService.changeTestStat(updateTstRequestVO);
    	return new AjaxResponse(updateResult);
    }
    
    @GetMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/delete/{tstId}")
    public AjaxResponse updateTestStat(DeleteTstRequestVO deleteTstRequestVO,
    		@SessionAttribute("__LOGIN_USER__") UsrVO usrVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId,
			@PathVariable String tstId) {
    	
    	deleteTstRequestVO.setTstId(tstId);
    	deleteTstRequestVO.setUsrId(usrVO.getUsrId());
    	deleteTstRequestVO.setArtcId(artcId);
    	deleteTstRequestVO.setCrsInfId(crsInfId);
    	deleteTstRequestVO.setSbjId(sbjId);
    	
    	boolean deleteResult = this.tstService.deleteOneTest(deleteTstRequestVO);
    	return new AjaxResponse(deleteResult);
    }
	
}
