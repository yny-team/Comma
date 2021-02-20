package kr.or.comma.user.svc;

import kr.or.comma.user.vo.UserVO;

public interface SecurityUserService {

	UserVO getUserById(String userId);
	void updateNewAccessDate(String userId);
}
