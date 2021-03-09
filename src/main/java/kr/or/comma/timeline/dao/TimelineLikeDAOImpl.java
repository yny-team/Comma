package kr.or.comma.timeline.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.comma.timeline.vo.TimelineLikeVO;

@Repository
public class TimelineLikeDAOImpl implements TimelineLikeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private static final String NAME_SPACE = "kr.or.comma.mapper.timeline.TimelineLikeMapper";
	
	@Override
	public List<TimelineLikeVO> selectTimelineLikeListAll() {
		
		return sqlSession.selectList(NAME_SPACE + ".selectTimelineLikeListAll");
	}
	
	@Override
	public int insertTimelineLikeBytimeNoAndUserNo(TimelineLikeVO timelineLikeVO) {
		
		return sqlSession.insert(NAME_SPACE + ".insertTimelineLikeBytimeNoAndUserNo", timelineLikeVO);
	}
	
	@Override
	public int deleteTimelineLikeBytimeNoAndUserNo(TimelineLikeVO timelineLikeVO) {
		
		return sqlSession.delete(NAME_SPACE + ".deleteTimelineLikeBytimeNoAndUserNo", timelineLikeVO);
	}
	
	@Override
	public int selectTimelineLikeCountByTimeNo(int timeNo) {
	
		return sqlSession.selectOne(NAME_SPACE + ".selectTimelineLikeCountByTimeNo", timeNo);
	}
	
	@Override
	public int selectTimeLikeCountByTimeNoAndUserNo(int timeNo, int userNo) {
		
		Map<String, Integer> param = new HashMap<>();
		param.put("timeNo", timeNo);
		param.put("userNo", userNo);
		
		return sqlSession.selectOne(NAME_SPACE + ".selectTimeLikeCountByTimeNoAndUserNo", param);
	}
	
}
