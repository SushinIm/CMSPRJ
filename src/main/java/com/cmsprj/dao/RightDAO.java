package com.cmsprj.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("rightDAO")
public class RightDAO{

	@Inject
	SqlSession sqlSession;
	
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> selectRightList(Map<String, Object> map) throws Exception{
        return sqlSession.selectList("right.selectRightList", map);
    }

	public int insertMenuRight(Map<String, Object> map) {
        return sqlSession.insert("right.insertMenuRight", map);
	}
	
	public int updateMemberRight(Map<String, Object> map) throws Exception{
        return sqlSession.update("right.updateMemberRight", map);
    }

}
