package com.cmsprj.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.common.dao.AbstractDAO;

@Repository("menuDAO")
public class MenuDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> selectMenuList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("menu.selectMenuList", map);
    }

}
