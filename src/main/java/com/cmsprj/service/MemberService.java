package com.cmsprj.service;

import java.util.List;
import java.util.Map;

import com.cmsprj.vos.MemberVo;

public interface MemberService {

	List<Map<String, Object>> selectMemberList(Map<String, Object> map) throws Exception;

	int deleteUsers(Map<String, Object> paramMap);

	int insertNewMember(MemberVo mvo);

}
