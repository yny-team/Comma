package kr.or.comma.user.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.or.comma.user.dao.UserDAO;
import kr.or.comma.user.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public int registUser(UserVO userVO) {
		
		userVO.setUserEmail(userVO.getUserEmailFirst() + userVO.getUserEmailEtc());
		userVO.setUserPassword(passwordEncoder.encode(userVO.getPassword()));
		
		return userDAO.insertUser(userVO);
	}
	
	@Override
	public int getUserIdExistsCount(String userId) {

		return userDAO.selectUserIdExistsCount(userId);
	}
	
	@Override
	public int getUserEmailExistsCount(String userEmail) {

		return userDAO.selectUserEmailExistsCount(userEmail);
	}
}
