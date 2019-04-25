package com.cmsprj.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

public interface MenuService {
	List<List<Map<String, Object>>> selectMenuList(HttpSession session) throws Exception;

	String selectUpperMenuLv(Map<String, Object> paramMap) throws Exception;

	int insertNewMenu(Map<String, Object> paramMap) throws Exception;

	int setMenuDefault(Map<String, Object> paramMap);

	int insertNewMenu2(Map<String, Object> paramMap);

	int deleteMenues(Map<String, Object> paramMap);

}
