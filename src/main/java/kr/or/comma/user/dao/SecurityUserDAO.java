package kr.or.comma.user.dao;

import kr.or.comma.user.vo.UserVO;

public interface SecurityUserDAO {

	UserVO getUserById(String userId);	
	void updateNewAccessDate(String userId);
	
}
