package com.cmsprj.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cmsprj.dao.MenuDAO;
import com.cmsprj.service.MenuService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

@Service("menuService")
public class MenuServiceImpl implements MenuService{

	private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
	
    @Resource(name="menuDAO")
    private MenuDAO menuDAO;
     
    @Override
    public List<List<Map<String, Object>>> selectMenuList(HttpSession session) throws Exception {
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("right_no", session.getAttribute("right_no"));
    	List<List<Map<String, Object>>> result = new ArrayList<>();
    	List<Map<String, Object>> list = menuDAO.selectMenuList(map);
    	for(int i=0; i<2; i++) {
    		List<Map<String, Object>> temp = new ArrayList<>();
    		for(int j=0; j<list.size(); j++) {
    			if(Integer.valueOf(list.get(j).get("MENU_LV").toString()).equals(i)) {
    				temp.add(list.get(j));
    			}
    		}
    		result.add(temp);
    	}

    	return result;
    }

	@Override
	public String selectUpperMenuLv(Map<String, Object> paramMap) throws Exception {
		return menuDAO.selectUpperMenuLv(paramMap);
	}

	@Override
	public int insertNewMenu(Map<String, Object> paramMap) throws Exception {
		return menuDAO.insertNewMenu(paramMap);
	}

	@Override
	public int setMenuDefault(Map<String, Object> paramMap) {
		return menuDAO.setMenuDefault(paramMap);
	}

	@Override
	public int insertNewMenu2(Map<String, Object> paramMap) {
		return menuDAO.insertNewMenu2(paramMap);
	}

	@Override
	public int deleteMenues(Map<String, Object> paramMap) {
		return menuDAO.deleteMenues(paramMap);
	}

}