package kr.or.comma.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.comma.user.vo.UserVO;

@Repository
public class SecurityUserDAOImpl implements SecurityUserDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAME_SPACE = "kr.or.comma.mapper.user.SecurityUserMapper";
	
	public UserVO getUserById(String userId) {
		
		return sqlSession.selectOne(NAME_SPACE + ".selectUserById", userId);
		
	}
	
	@Override
	public void updateNewAccessDate(String userId) {
		
		sqlSession.update(NAME_SPACE + ".updateAccessDate", userId);
		
	}

}
