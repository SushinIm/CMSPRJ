package com.cmsprj.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cmsprj.controller.CommonController;
import com.cmsprj.dao.MemberDAO;
import com.cmsprj.service.MemberService;
import com.cmsprj.vos.MemberVo;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
    @Resource(name="memberDAO")
    private MemberDAO memberDAO;
     
    @Override
    public List<Map<String, Object>> selectMemberList(Map<String, Object> map) throws Exception {
        return memberDAO.selectMemberList(map);
    }

	@Override
	public int deleteUsers(Map<String, Object> paramMap) {
        return memberDAO.deleteUsers(paramMap);
	}

	@Override
	public int insertNewMember(MemberVo mvo) {
        return memberDAO.insertNewMember(mvo);
	}
 
}