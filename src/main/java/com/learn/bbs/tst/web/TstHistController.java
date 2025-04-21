package com.learn.bbs.tst.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.learn.bbs.tst.service.TstHistService;
import com.learn.bbs.tst.vo.CreateTstHstrRequestVO;
import com.learn.bbs.tst.vo.TstHistVO;
import com.learn.bbs.tst.vo.UpdateTstHstrRequestVO;
import com.learn.bbs.usr.vo.UsrVO;
import com.learn.common.vo.AjaxResponse;

@RestController
@RequestMapping("/usr/tst/hist")
public class TstHistController {

	@Autowired
	private TstHistService tstHistService;

	@GetMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/list/{tstId}")
	public AjaxResponse testList(@SessionAttribute("__LOGIN_USER__") UsrVO usrVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId,
			@PathVariable String tstId) {
		
		List<TstHistVO> tstList = tstHistService.readTstHistList(tstId);
		return new AjaxResponse(tstList);
	}
	
	@GetMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/start/{tstId}")
	public AjaxResponse startTest(
			@SessionAttribute("__LOGIN_USER__") UsrVO usrVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId,
			@PathVariable String tstId) {

		CreateTstHstrRequestVO createTstHstrRequestVO = new CreateTstHstrRequestVO();
		createTstHstrRequestVO.setTstId(tstId);
		createTstHstrRequestVO.setUsrId(usrVO.getUsrId());
		createTstHstrRequestVO.setArtcId(artcId);
		createTstHstrRequestVO.setCrsInfId(crsInfId);
		createTstHstrRequestVO.setSbjId(sbjId);
		
		boolean createResult = this.tstHistService.createNewTstHist(createTstHstrRequestVO);
		
		return new AjaxResponse(createResult);
	}
	
	@GetMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/end/{tstHstrId}")
	public AjaxResponse endTest(
			@SessionAttribute("__LOGIN_USER__") UsrVO usrVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId,
			@PathVariable String tstHstrId) {

		UpdateTstHstrRequestVO updateTstHstrRequestVO = new UpdateTstHstrRequestVO();
		updateTstHstrRequestVO.setTstHstrId(tstHstrId);
		updateTstHstrRequestVO.setUsrId(usrVO.getUsrId());
		updateTstHstrRequestVO.setArtcId(artcId);
		updateTstHstrRequestVO.setCrsInfId(crsInfId);
		updateTstHstrRequestVO.setSbjId(sbjId);
		
		boolean updateResult = this.tstHistService.updateTstRspnsHist(updateTstHstrRequestVO);
		
		return new AjaxResponse(updateResult);
	}
}
