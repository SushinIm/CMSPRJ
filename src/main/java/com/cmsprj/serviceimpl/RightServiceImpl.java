package com.cmsprj.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cmsprj.dao.RightDAO;
import com.cmsprj.service.RightService;

@Service("rightService")
public class RightServiceImpl implements RightService{

	private static final Logger logger = LoggerFactory.getLogger(RightServiceImpl.class);
	
    @Resource(name="rightDAO")
    private RightDAO rightDAO;
     
    @Override
    public List<Map<String, Object>> selectRightList(Map<String, Object> map) throws Exception {
        return rightDAO.selectRightList(map);
    }
 
}