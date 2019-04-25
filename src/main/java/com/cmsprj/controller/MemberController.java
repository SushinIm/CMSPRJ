package com.cmsprj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmsprj.service.MemberService;
import com.cmsprj.vos.MemberVo;

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
	
	@RequestMapping(value = "/pagingReg.do")
	public ModelAndView openRegPage(Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/members/regist");

        return mv;
    }

	@RequestMapping(value = "/delUser.do")
	public String delUser(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = new HashMap<String, Object>();
        String[] users = request.getParameter("users").split("-");
        int count = 0;
        for(int i=1; i<users.length; i++) {
        	paramMap.put("USER_NO", Integer.valueOf(users[i]));
        	try {
        		count += memberService.deleteUsers(paramMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        System.out.println(count + "개의 행을 삭제했습니다.");
        
        return "redirect:/menu/member.do";
    }
	
	@RequestMapping(value = "/regist.do")
	public String regist(HttpServletRequest request) throws Exception{
        MemberVo mvo = new MemberVo();
        int count = 0;
        mvo.setUser_id(request.getParameter("userId"));
        mvo.setPassword(request.getParameter("userPw"));
        mvo.setUser_nm(request.getParameter("userNM"));

        count += memberService.insertNewMember(mvo);

        System.out.println(count + " 명의 회원 가입 성공");

        return "redirect:/main.do";
    }
}
