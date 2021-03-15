package kr.or.comma.user.svc;

import kr.or.comma.user.vo.UserVO;

public interface UserService {

	public int registUser(UserVO userVO);

	public int getUserIdExistsCount(String userId);

	public int getUserEmailExistsCount(String userEmail);

}
