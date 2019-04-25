package com.cmsprj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

        List<List<Map<String, Object>>> list = menuService.selectMenuList(session);
        mv.addObject("list", list);
        
        return mv;
    }
	
	@RequestMapping(value = "/addMenu.do")
	public String addMenu(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = new HashMap<String, Object>();
        int flag = 0;
        int menuLv = 0;

        paramMap.put("PARENTS", request.getParameter("parents"));
        paramMap.put("MENU_NM", request.getParameter("menu_nm"));
        
        
        try {
            if(!paramMap.get("PARENTS").equals(" ")) {
            	menuLv = Integer.valueOf(menuService.selectUpperMenuLv(paramMap)) + 1;
                paramMap.put("MENU_LV", menuLv);
            	flag += menuService.insertNewMenu(paramMap);
            }else {
                paramMap.put("MENU_LV", menuLv);
            	flag += menuService.insertNewMenu2(paramMap);
            }
        	try {
				flag += menuService.setMenuDefault(paramMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "redirect:/menu/main.do";
    }

	@RequestMapping(value = "/delMenu.do")
	public String delMenu(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = new HashMap<String, Object>();
        String[] menues = request.getParameter("menues").split("-");
        int count = 0;
        for(int i=1; i<menues.length; i++) {
        	paramMap.put("MENU_NO", Integer.valueOf(menues[i]));
        	try {
        		count += menuService.deleteMenues(paramMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        System.out.println(count + "개의 행을 삭제했습니다.");
        
        return "redirect:/menu/main.do";
    }
}
