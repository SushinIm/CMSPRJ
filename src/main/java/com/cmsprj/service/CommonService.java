package com.cmsprj.service;

import javax.servlet.http.HttpSession;

import com.cmsprj.vos.MemberVo;

public interface CommonService {

	boolean login(MemberVo vo, HttpSession session) throws Exception;
}
