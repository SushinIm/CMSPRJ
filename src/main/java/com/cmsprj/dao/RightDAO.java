package com.cmsprj.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.common.dao.AbstractDAO;

@Repository("rightDAO")
public class RightDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> selectRightList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("right.selectRightList", map);
    }

}
