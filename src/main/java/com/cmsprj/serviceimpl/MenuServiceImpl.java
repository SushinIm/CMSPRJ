package com.cmsprj.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cmsprj.dao.MenuDAO;
import com.cmsprj.service.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService{

	private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
	
    @Resource(name="menuDAO")
    private MenuDAO menuDAO;
     
    @Override
    public List<Map<String, Object>> selectMenuList(HttpSession session) throws Exception {
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("right_no", session.getAttribute("right_no"));
        return menuDAO.selectMenuList(map);
    }

}