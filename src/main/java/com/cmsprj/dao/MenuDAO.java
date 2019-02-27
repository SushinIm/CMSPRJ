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
}
