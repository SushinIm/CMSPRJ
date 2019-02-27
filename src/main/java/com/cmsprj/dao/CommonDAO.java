package com.cmsprj.dao;


import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cmsprj.vos.MemberVo;

@Repository("commonDAO")
public class CommonDAO {

	@Inject
	SqlSession sqlSession;
	
	public boolean login(MemberVo vo) {
		String num = sqlSession.selectOne("common.login", vo).toString();
		return (num == null) ? false : true;
	}

}
