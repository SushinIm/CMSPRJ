package com.cmsprj.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmsprj.service.MenuService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Resource(name = "menuService")
	private MenuService menuService;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/main.do")
	public ModelAndView openMainPage(HttpSession session) throws Exception{
        ModelAndView mv = new ModelAndView("/menues/home");

        List<Map<String,Object>> list = menuService.selectMenuList(session);
        mv.addObject("list", list);
        
        return mv;
    }

}
