package com.cmsprj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cmsprj.service.CommonService;
import com.cmsprj.service.MenuService;
import com.cmsprj.vos.MemberVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

	@Resource(name = "commonService")
	private CommonService commonService;
	
	@Resource(name = "menuService")
	private MenuService menuService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/main.do")
	public String autoMovePage(@ModelAttribute MemberVo vo, HttpSession session) throws Exception{
        if(session.getAttribute("loginYN") == null) {
            session.setAttribute("loginYN", "N");
        }else {
            return "redirect:/mainP.do";
        }
        return "/home";
    }

	@RequestMapping(value = "/mainP.do")
	public ModelAndView openMainPage(@ModelAttribute MemberVo vo, HttpSession session) throws Exception{
        ModelAndView mv = new ModelAndView("/home");
        List<Map<String, Object>> map = menuService.selectMenuList(session);
        mv.addObject("list", map);
        return mv;
    }
	
	@RequestMapping(value = "/login.do")
	public ModelAndView afterLogin(@ModelAttribute MemberVo vo, HttpSession session) throws Exception{
        ModelAndView mv = new ModelAndView("/home");
        boolean result = commonService.login(vo, session);
        List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
        if(result) {
            session.setAttribute("loginYN", "Y");
            map = menuService.selectMenuList(session);
            mv.addObject("list", map);
        }else {
            session.setAttribute("loginYN", "N");
        }
        
        return mv;
    }

	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) throws Exception{
        session.invalidate();
        return "redirect:/main.do";
    }
}
