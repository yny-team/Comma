package kr.or.comma.timeline.dao;

import java.util.List;

import kr.or.comma.common.vo.ImageOrFileVO;

public interface TimelineFileDAO {
	public void insertTimelineFile(ImageOrFileVO timelineFileVO);

	public List<ImageOrFileVO> selectTimelineFileListAll();

	public List<ImageOrFileVO> selectTimelineFileOneByTimeNo(int timeNo);
}
