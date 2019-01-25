package com.cmsprj.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.common.dao.AbstractDAO;

@Repository("memberDAO")
public class MemberDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> selectMemberList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("member.selectMemberList", map);
    }

}
