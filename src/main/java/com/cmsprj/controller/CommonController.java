package com.cmsprj.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cmsprj.service.CommonService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	/*
	@Resource(name = "commonService")
	private CommonService commonService;
	*/
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/main.do")
	public ModelAndView openMainPage(Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/home");

        return mv;
    }
	
}
