package movie24.info.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;

import movie24.info.model.vo.MovieInfo;

public class MovieInfoDAO {

	public List<MovieInfo> selectList(SqlSession session) {
		List<MovieInfo> miList = session.selectList("InfoMapper.selectList");
		return miList;
	}

	public MovieInfo selectOnebyNo(SqlSession session, int movieNum) {
		MovieInfo mInfo = session.selectOne("InfoMapper.selectOnebyNo", movieNum);
		return mInfo;
	}

}
