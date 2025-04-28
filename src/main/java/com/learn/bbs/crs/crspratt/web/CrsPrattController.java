package com.learn.bbs.crs.crspratt.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learn.bbs.crs.apphstr.vo.AppHstrReadResponseVO;
import com.learn.bbs.crs.crspratt.service.CrsPrattService;
import com.learn.bbs.crs.crspratt.vo.CrsPrattReadResponseVO;
import com.learn.bbs.pltad.vo.PltadmVO;
import com.learn.exceptions.AccessDeniedException;

import jakarta.servlet.http.HttpSession;


/**
 * @author 최예진
 * 수강이력
 */
@Controller
public class CrsPrattController {

    @Autowired
    private CrsPrattService crsPrattService;
    
    @GetMapping("/pltad/{insttnId}/{crsInfId}/finish")
    public String showCurrentUserInCourse(@PathVariable String insttnId,
    									  @PathVariable String crsInfId, 
    									  Model model, 
    									  HttpSession session) {
    	PltadmVO pltadmVO = (PltadmVO) session.getAttribute("__LOGIN_PLTADM__");

        if (pltadmVO == null) {
            throw new AccessDeniedException();
        }
        
        String nowInsttnId = pltadmVO.getInsttnId();
        
        if (!insttnId.equals(nowInsttnId)) {
            return "redirect:/pltad/" + nowInsttnId + "/" + crsInfId + "/finish";
        }
        
        List<CrsPrattReadResponseVO> currentUsers = this.crsPrattService.selectUsersFromCrsPratt(crsInfId, pltadmVO.getInsttnId());
        
        String courseName = this.crsPrattService.selectCourseName(crsInfId, pltadmVO.getInsttnId());
        
        model.addAttribute("finishUsers", currentUsers);
        model.addAttribute("courseName", courseName);
        
    	return "/bbs/crs/coursefinish";
    }
}