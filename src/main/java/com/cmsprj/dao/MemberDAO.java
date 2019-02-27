package com.cmsprj.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.cmsprj.vos.MemberVo;

@Repository("memberDAO")
public class MemberDAO{

	@Inject
	SqlSession sqlSession;
	
    public List<Map<String, Object>> selectMemberList(Map<String, Object> map) throws Exception{
        return sqlSession.selectList("member.selectMemberList", map);
    }

	public MemberVo selectUserInfo(MemberVo vo) {
		return sqlSession.selectOne("member.selectUserInfo",vo);
	}

}
