package movie24.event.model.service;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import movie24.event.model.dao.EventDAO;
import movie24.event.model.vo.EventSRC;

public class EventService {

	private EventDAO eDao;
	private SqlSessionTemplate sqlSessionTemplate;
	
	public EventService() {
		eDao = new EventDAO();
		sqlSessionTemplate = new SqlSessionTemplate();
	}
	
	public String getEventImage(int eventSrcNum) {
		SqlSession session = sqlSessionTemplate.getSqlSession();
		String src = eDao.getEventImage(session, eventSrcNum);
		return src;
	}

}
