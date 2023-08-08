package movie24.member.model.service;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import movie24.member.model.dao.MovieMemberDAO;
import movie24.member.model.vo.MovieMember;
import movie24.notice.model.vo.Notice;
import movie24.notice.model.vo.PageData;

public class MovieMemberService {
	
	private SqlSessionTemplate sqlSessiontemplate;
	private MovieMemberDAO mmDao;
	
	public MovieMemberService() {
		sqlSessiontemplate = new SqlSessionTemplate();
		mmDao = new MovieMemberDAO();
	}
	
	public MovieMember selectCheckLogin(MovieMember member) {
		SqlSession session = sqlSessiontemplate.getSqlSession();
		MovieMember mOne = mmDao.selectCheckLogin(session, member);
		session.close();
		return mOne;
	}

	public MovieMember searchId(MovieMember member) {
		SqlSession session = sqlSessiontemplate.getSqlSession();
		MovieMember mOne = mmDao.searchId(session, member);
		session.close();
		return mOne;
	}
	
	public MovieMember selectOneById(String memberId) {
		SqlSession session = sqlSessiontemplate.getSqlSession();
		MovieMember member = mmDao.selectOneById(session, memberId);
		session.close();
		return member;
	}
	
	public int insertMember(MovieMember member) {
		SqlSession session = sqlSessiontemplate.getSqlSession();
		int result = mmDao.insertMember(session, member);
		if(result > 0) {
			session.commit();
		}else{
			session.rollback();
		}
		session.close();
		return result;
	}
	
	public int updateMember(MovieMember member) {
		SqlSession session = sqlSessiontemplate.getSqlSession();
		int result = mmDao.updateMember(session, member);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public int deleteMember(String memberId) {
		SqlSession session = sqlSessiontemplate.getSqlSession();
		int result = mmDao.deleteMember(session, memberId);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	
}
