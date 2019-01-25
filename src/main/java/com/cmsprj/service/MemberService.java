package com.cmsprj.service;

import java.util.List;
import java.util.Map;

public interface MemberService {

	List<Map<String, Object>> selectMemberList(Map<String, Object> map) throws Exception;

}
