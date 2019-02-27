package com.cmsprj.service;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public interface RightService {

	List<Map<String, Object>> selectRightList(Map<String, Object> map) throws Exception;

	int insertMenuRight(HttpServletRequest request) throws Exception;
	int updateMemberRight(HttpServletRequest request) throws Exception;
}
