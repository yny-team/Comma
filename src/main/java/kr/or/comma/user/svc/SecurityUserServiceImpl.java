package kr.or.comma.user.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.comma.user.dao.SecurityUserDAO;
import kr.or.comma.user.vo.UserVO;

@Service
public class SecurityUserServiceImpl implements SecurityUserService {
	
	
	@Autowired
	private SecurityUserDAO securityUserDAO;
	
	@Override
	public UserVO getUserById(String userId) {
	
		return securityUserDAO.getUserById(userId);
	}
	
	@Override
	public void updateNewAccessDate(String userId) {
		
		securityUserDAO.updateNewAccessDate(userId);
	}
}
