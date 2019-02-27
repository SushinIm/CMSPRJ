package com.cmsprj.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cmsprj.dao.CommonDAO;
import com.cmsprj.dao.MemberDAO;
import com.cmsprj.dao.RightDAO;
import com.cmsprj.service.CommonService;
import com.cmsprj.vos.MemberVo;

@Service("commonService")
public class CommonServiceImpl implements CommonService{

	private static final Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);

    @Resource(name="commonDAO")
    private CommonDAO commonDAO;
    
    @Resource(name="memberDAO")
    private MemberDAO memberDAO;
    
	@Override
	public boolean login(MemberVo vo, HttpSession session) throws Exception {
		boolean result = commonDAO.login(vo);
		if(result) {
			MemberVo vo2 = memberDAO.selectUserInfo(vo);
			session.setAttribute("user_no", vo2.getUser_no());
			session.setAttribute("user_id", vo2.getUser_id());
			session.setAttribute("right_no", vo2.getRight_no());
		}
		return result;
	}
 
}