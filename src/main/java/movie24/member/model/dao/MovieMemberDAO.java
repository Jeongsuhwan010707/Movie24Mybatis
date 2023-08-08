package movie24.member.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import movie24.member.model.vo.MovieMember;
import movie24.notice.model.vo.Notice;

public class MovieMemberDAO {

	public MovieMember searchId(SqlSession session, MovieMember member) {
		MovieMember mOne = session.selectOne("MemberMapper.searchId", member);
		return mOne;
	}

	public MovieMember selectCheckLogin(SqlSession session, MovieMember member) {
		MovieMember mOne = session.selectOne("MemberMapper.selectCheckLogin", member);
		return mOne;
	}
	
	public MovieMember selectOneById(SqlSession session, String memberId) {
		MovieMember mOne = session.selectOne("MemberMapper.selectOneById", memberId);
		return mOne;
	}
	
	public int insertMember(SqlSession session, MovieMember member) {
		int result = session.insert("MemberMapper.insertMember", member);
		return result;
	}

	public int updateMember(SqlSession session, MovieMember member) {
		int result = session.update("MemberMapper.updateMember", member);
		return result;
	}

	public int deleteMember(SqlSession session, String memberId) {
		int result = session.delete("MemberMapper.updateMember", memberId);
		return result;
	}
	
}
