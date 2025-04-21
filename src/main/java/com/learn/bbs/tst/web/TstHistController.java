package com.learn.bbs.tst.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.bbs.tst.service.TstHistService;
import com.learn.common.vo.AjaxResponse;

@RestController
@RequestMapping("/usr/tst/hist")
public class TstHistController {

	@Autowired
	private TstHistService tstHistService;

	@GetMapping("/{insttnId}/{crsInfId}/{sbjId}/{artcId}/list")
	public AjaxResponse getTestHistory() {

		return null;
	}
}
