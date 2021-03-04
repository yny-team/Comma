package kr.or.comma.timeline.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.comma.timeline.vo.TimelineCommentVO;

@Repository
public class TimelineCommentDAOImpl implements TimelineCommentDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private static final String NAME_SPACE = "kr.or.comma.mapper.timeline.TimelineCommentMapper";
	
	@Override
	public int insertTimelineComment(TimelineCommentVO timelineCommentVO) {
		
		return sqlSession.insert(NAME_SPACE + ".insertTimelineComment", timelineCommentVO);
	}
	
	@Override
	public TimelineCommentVO selectTimelineCommentOneByTimeCommNo(int timeNo) {
	
		return sqlSession.selectOne(NAME_SPACE + ".selectTimelineCommentOneByTimeCommNo", timeNo);
	}
	
	@Override
	public int updateTimelineComment(TimelineCommentVO timelineCommentVO) {
		
		return sqlSession.update(NAME_SPACE + ".updateTimelineComment", timelineCommentVO);
	}
	
	@Override
	public int deleteTimelineComment(int timeCommNo) {

		return sqlSession.delete(NAME_SPACE + ".deleteTimelineComment", timeCommNo);
	}
	
	@Override
	public List<TimelineCommentVO> selectTimelineCommentListAll(int timeNo) {
		
		return sqlSession.selectList(NAME_SPACE + ".selectTimelineCommentListAll", timeNo);
	}
	
	
	
}
