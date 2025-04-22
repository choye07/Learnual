package com.learn.bbs.pltad.tst.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.learn.bbs.pltad.vo.PltadmVO;
import com.learn.bbs.tst.service.TstHistService;
import com.learn.bbs.tst.vo.TstHistVO;
import com.learn.bbs.usr.vo.UsrVO;
import com.learn.common.vo.AjaxResponse;

@RestController
@RequestMapping("/pltad/tst/hist")
public class PltadTstHistController {

	@Autowired
	private TstHistService tstHistService;

	@GetMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/list/{tstId}")
	public AjaxResponse testList(
			@SessionAttribute("__LOGIN_PLTADM__") PltadmVO pltadmVO,
			@PathVariable String insttnId,
			@PathVariable String crsInfId,
			@PathVariable String sbjId,
			@PathVariable String artcId,
			@PathVariable String tstId) {
		
		List<TstHistVO> tstList = tstHistService.readTstHistList(tstId);
		return new AjaxResponse(tstList);
	}
	
}
