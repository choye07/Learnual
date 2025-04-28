package com.learn.bbs.crs.cncl.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.bbs.crs.cncl.service.CnclHstrService;
import com.learn.bbs.usr.vo.UsrVO;
import com.learn.exceptions.AccessDeniedException;

import jakarta.servlet.http.HttpSession;


/**
 * @author 최예진
 * 취소 내역
 */
@Controller
public class CnclHstrController {

    @Autowired
    private CnclHstrService cnclHstrService;

    @PostMapping("/usr/{insttnId}/{crsInfId}/detail/cancel")
    public String doCancelCourse(@PathVariable String insttnId,
    							 @PathVariable String crsInfId, 
    							 Model model,
    							 HttpSession session) {
    	UsrVO usrVO = (UsrVO) session.getAttribute("__LOGIN_USER__");
    	
    	if(usrVO == null) {
    		throw new AccessDeniedException();
    	}
    	
    	String nowInsttnId = usrVO.getInsttnId();
    	
        if (!insttnId.equals(nowInsttnId)) {
            return "redirect:/usr/" + nowInsttnId + "/" + crsInfId + "/detail/cancel";
        }

        this.cnclHstrService.insertCancelledAppHstr(crsInfId, usrVO.getUsrMl(), usrVO.getInsttnId());

        return "redirect:/usr/" + nowInsttnId + "/" + crsInfId + "/detail";
    }
}