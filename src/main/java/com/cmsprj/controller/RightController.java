package com.cmsprj.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cmsprj.service.MemberService;
import com.cmsprj.service.MenuService;
import com.cmsprj.service.RightService;

@Controller
@RequestMapping(value = "/right")
public class RightController {

	private static final Logger logger = LoggerFactory.getLogger(RightController.class);

	@Resource(name = "menuService")
	private MenuService menuService;
	
	@Resource(name = "memberService")
	private MemberService memberService;
	
	@Resource(name = "rightService")
	private RightService rightService;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/main.do")
	public ModelAndView openMainPage(Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/rights/home");

        List<Map<String,Object>> list = rightService.selectRightList(commandMap);
        mv.addObject("list", list);
        
        return mv;
    }

	@RequestMapping(value = "/pageMenu.do")
	public ModelAndView pageMenu(HttpServletRequest request, HttpSession session) throws Exception{ 
		ModelAndView mv = new ModelAndView("/rights/grantMenu");
		String rightNO = request.getParameter("right_no");
		
		List<List<Map<String, Object>>> list = menuService.selectMenuList(session);
        
        mv.addObject("list", list);
        mv.addObject("rightNO", rightNO);
		
		return mv;
	}

	@RequestMapping(value = "/pageMember.do")
	public ModelAndView pageMember(HttpServletRequest request, Map<String,Object> commandMap) throws Exception{ 
		ModelAndView mv = new ModelAndView("/rights/grantMember");
		String rightNO = request.getParameter("right_no");
		
        List<Map<String,Object>> list = memberService.selectMemberList(commandMap);
        
        mv.addObject("list", list);
        mv.addObject("rightNO", rightNO);
		
		return mv;
	}

	@RequestMapping(value = "/grantMenu.do")
	public String grantMenu(HttpServletRequest request) throws Exception{
		
		String rv = String.valueOf(rightService.insertMenuRight(request));
		
		return rv;
	}

	@RequestMapping(value = "/grantMember.do")
	public String grantMember(HttpServletRequest request) throws Exception{ 
		
		String rv = String.valueOf(rightService.updateMemberRight(request));

		return rv;
	}
}
