package kr.or.comma.user.dao;

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
	public void insertJoIn(UserVO userVO) {
		
		sqlSession.insert(NAME_SPACE + ".insertUser", userVO);
		
	}
	
	@Override
	public List<UserVO> selectAllUser() {
		
		return sqlSession.selectList(NAME_SPACE + ".selectAllUser");
		
	}
}
