package kr.or.comma.user.dao;

import java.util.List;

import kr.or.comma.user.vo.UserVO;

public interface UserDAO {
	
	public void insertJoIn(UserVO userVO);
	public List<UserVO> selectAllUser();
}
