package com.cmsprj.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    
	@Override
	public int insertMenuRight(HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String[] menues = request.getParameter("menuno").split("|");
		int rtVal = 1;
		
		for (String menuno : menues) {
			map.clear();
			map.put("RIGHT_NO", request.getParameter("rightno"));
			map.put("MENU_NO", menuno);
			try {
				rtVal *= rightDAO.insertMenuRight(map);
			} catch (Exception e) {
				logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>" + e.getMessage());
			}
		}
		return rtVal;
	}

	@Override
	public int updateMemberRight(HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("RIGHT_NO", request.getParameter("rightno"));
		map.put("USER_NO", request.getParameter("memberno"));
		int rtVal = rightDAO.updateMemberRight(map);
		return rtVal;
	}
 
}