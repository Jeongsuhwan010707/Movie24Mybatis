package movie24.event.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import movie24.event.model.vo.EventSRC;
import movie24.notice.model.vo.Notice;

public class EventDAO {

	public String getEventImage(SqlSession session, int eventSrcNum) {
		String src = session.selectOne("EventMapper.getEventImage", eventSrcNum);
		return src;
	}

}
