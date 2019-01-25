package com.cmsprj.service;

import java.util.List;
import java.util.Map;

public interface MenuService {

	List<Map<String, Object>> selectMenuList(Map<String, Object> map) throws Exception;

}
