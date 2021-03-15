package kr.or.comma.user.dao;

import java.util.List;

import kr.or.comma.user.vo.UserVO;

public interface UserDAO {
	
	public int insertUser(UserVO userVO);

	public int selectUserIdExistsCount(String userId);

	public int selectUserEmailExistsCount(String userEmail);
}
