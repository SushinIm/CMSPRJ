package com.cmsprj.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmsprj.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Resource(name = "memberService")
	private MemberService memberService;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/main.do")
	public ModelAndView openMainPage(Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/members/home");

        List<Map<String,Object>> list = memberService.selectMemberList(commandMap);
        mv.addObject("list", list);
        
        return mv;
    }

}
