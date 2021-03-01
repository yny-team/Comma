package kr.or.comma.timeline.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.comma.timeline.vo.TimelineVO;

@Repository
public class TimelineDAOImpl implements TimelineDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private static final String NAME_SPACE = "kr.or.comma.mapper.timeline.TimelineMapper";
	
	@Override
	public int insertTimeline(TimelineVO timelineVO) {
		
		return sqlSession.insert(NAME_SPACE + ".insertTimeline", timelineVO);
	}
	
	@Override
	public List<TimelineVO> selectTimelineListAll() {
		
		return sqlSession.selectList(NAME_SPACE +  ".selectTimelineListAll");
	}
	
	@Override
	public TimelineVO selectTimelineOneByTimeNo(int timeNo) {
		
		return sqlSession.selectOne(NAME_SPACE + ".selectTimelineOneByTimeNo", timeNo);
	}
}
