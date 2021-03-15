package kr.or.comma.user.dao;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.comma.user.vo.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private static final String NAME_SPACE = "kr.or.comma.mapper.user.UserMapper";
	
	@Override
	public int insertUser(UserVO userVO) {

		return sqlSession.insert(NAME_SPACE + ".insertUser", userVO);
	}
	
	@Override
	public int selectUserIdExistsCount(String userId) {

		return sqlSession.selectOne(NAME_SPACE + ".selectUserIdExistsCount", userId);
	}
	
	@Override
	public int selectUserEmailExistsCount(String userEmail) {

		return sqlSession.selectOne(NAME_SPACE + ".selectUserEmailExistsCount", userEmail);
	}
}
