package kr.or.comma.timeline.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.comma.common.vo.ImageOrFileVO;

@Repository
public class TimelineFileDAOImpl implements TimelineFileDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private static final String NAME_SPACE = "kr.or.comma.mapper.timeline.TimelineFileMapper";
	
	@Override
	public void insertTimelineFile(ImageOrFileVO timelineFileVO) {
		
		sqlSession.insert(NAME_SPACE + ".insertTimelineFile", timelineFileVO);
		
	}
	
	@Override
	public List<ImageOrFileVO> selectTimelineFileListAll() {
		
		return sqlSession.selectList(NAME_SPACE + ".selectTimelineFileListAll");
	}
	
	@Override
	public List<ImageOrFileVO> selectTimelineFileOneByTimeNo(int timeNo) {
		
		return sqlSession.selectList(NAME_SPACE + ".selectTimelineFileOneByTimeNo", timeNo);
	}
	
}
