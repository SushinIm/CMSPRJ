package com.cmsprj.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

public interface MenuService {
	List<Map<String, Object>> selectMenuList(HttpSession session) throws Exception;

}
