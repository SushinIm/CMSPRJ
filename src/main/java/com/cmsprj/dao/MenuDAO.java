package com.cmsprj.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("menuDAO")
public class MenuDAO{

	@Inject
	SqlSession sqlSession;
	
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> selectMenuList(Map<String, Object> map) throws Exception{
        return sqlSession.selectList("menu.selectMenuList", map);
    }

	public String selectUpperMenuLv(Map<String, Object> paramMap) {
		return sqlSession.selectOne("menu.selectUpperMenuLv", paramMap);
	}

	public int insertNewMenu(Map<String, Object> paramMap) {
		return sqlSession.insert("menu.insertNewMenu", paramMap);
	}

	public int setMenuDefault(Map<String, Object> paramMap) {
		return sqlSession.insert("menu.setMenuDefault", paramMap);
	}

	public int insertNewMenu2(Map<String, Object> paramMap) {
		return sqlSession.insert("menu.insertNewMenu2", paramMap);
	}

	public int deleteMenues(Map<String, Object> paramMap) {
		return sqlSession.delete("menu.deleteMenues", paramMap);
	}

}
