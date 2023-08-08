package movie24.notice.model.service;

import java.sql.*;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import movie24.notice.model.dao.NoticeDAO;
import movie24.notice.model.vo.Notice;
import movie24.notice.model.vo.PageData;

public class NoticeService {
	
	private NoticeDAO nDao;
	private SqlSessionTemplate sqlSessionTemplate;
	
	public NoticeService() {
		nDao = new NoticeDAO();
		sqlSessionTemplate = new SqlSessionTemplate();
	}
	
	public PageData selectNoticeList(int currentPage, PageData pdNum){
		SqlSession session = sqlSessionTemplate.getSqlSession();
		List<Notice> nList = nDao.selectNoticeList(session, pdNum);
		String pageNavi = nDao.generatePageNavi(session, currentPage);
		PageData pd = new PageData(nList, pageNavi);
		session.close();
		return pd;
	}
	
	
	
//	public List<Notice> selectNoticeList(){
//		SqlSession session = sqlSessionTemplate.getSqlSession();
//		List<Notice> nList = nDao.selectNoticeList(session);
//		session.close();
//		return nList;
//	}

	public Notice selectOneByNo(int noticeNo) {
		SqlSession session = sqlSessionTemplate.getSqlSession();
		Notice notice = nDao.selectOneByNo(session, noticeNo);
		session.close();
		return notice;
	}
	public int insertNotice(Notice notice) {
		SqlSession session = sqlSessionTemplate.getSqlSession();
		int result = nDao.insertNotice(session, notice);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}
	
	public int updateNotice(Notice notice) {
		SqlSession session = sqlSessionTemplate.getSqlSession();
		int result = nDao.updateNotice(session, notice);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}
	
	public int deleteNoticeByNo(int noticeNo) {
		SqlSession session = sqlSessionTemplate.getSqlSession();
		int result = nDao.deleteNoticeByNo(session, noticeNo);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public int selectTotal() {
		SqlSession session = sqlSessionTemplate.getSqlSession();
		int total = nDao.selectTotal(session);
		session.close();
		return total;
	}

	
	

}
