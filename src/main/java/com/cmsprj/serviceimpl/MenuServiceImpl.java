package com.cmsprj.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
    public List<Map<String, Object>> selectMenuList(Map<String, Object> map) throws Exception {
        return menuDAO.selectMenuList(map);
    }
 
}