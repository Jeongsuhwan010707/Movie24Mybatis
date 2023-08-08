package movie24.notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import movie24.notice.model.vo.Notice;
import movie24.notice.model.vo.PageData;

public class NoticeDAO {

	public String generatePageNavi(SqlSession session, int currentPage) {
		int totalCount = session.selectOne("NoticeMapper.selectTotal");
		int recordCountPerPage = 15;
		int naviTotalCount = 0;
		if (totalCount % recordCountPerPage > 0) {
			naviTotalCount = totalCount / recordCountPerPage + 1;
		} else {
			naviTotalCount = totalCount / recordCountPerPage;
		}
		int naviCountPerPage = 5; ///////////
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		// endNavi값이 총 범위의 갯수보다 커지는 것을 막아주는 코드
		if (endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if (startNavi == 1) {
			needPrev = false;
		}
		if (endNavi == naviTotalCount) {
			needNext = false;
		}
		StringBuilder result = new StringBuilder();
		result.append("<div id='number'>");
		if (needPrev) {
			result.append("<a id='postNum' href='/movie24/post.do?currentPage=" + (startNavi - 1) + "'><<a>");
		}
		for (int i = startNavi; i <= endNavi; i++) {
			result.append("<a href='/movie24/post.do?currentPage=" + i + "'>" + i + " </a>");
		}
		if (needNext) {
			result.append("<a id='postNum' href='/movie24/post.do?currentPage=" + (endNavi + 1) + "'>><a>");
		}
		result.append("</div>");
		return result.toString();
	}

	public List<Notice> selectNoticeList(SqlSession session, PageData pdNum) {
		List<Notice> nList = session.selectList("NoticeMapper.selectNoticeList", pdNum);
		return nList;
	}

	public int selectTotal(SqlSession session) {
		int totalCount = session.selectOne("NoticeMapper.selectTotal");
		return totalCount;
	}

	public Notice selectOneByNo(SqlSession session, int noticeNo) {
		Notice notice = session.selectOne("NoticeMapper.selectOneByNo", noticeNo);
		return notice;
	}

	public int insertNotice(SqlSession session, Notice notice) {
		int result = session.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	public int updateNotice(SqlSession session, Notice notice) {
		int result = session.update("NoticeMapper.updateNotice", notice);
		return result;
	}

	public int deleteNoticeByNo(SqlSession session, int noticeNo) {
		int result = session.delete("NoticeMapper.deleteNotice", noticeNo);
		return result;
	}

	

}
