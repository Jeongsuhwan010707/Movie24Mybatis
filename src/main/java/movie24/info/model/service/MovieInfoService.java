package movie24.info.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import movie24.info.model.dao.MovieInfoDAO;
import movie24.info.model.vo.MovieInfo;

public class MovieInfoService {
	
	private SqlSessionTemplate sqlSessiontemplate;
	private MovieInfoDAO miDao;
	
	public MovieInfoService() {
		sqlSessiontemplate = new SqlSessionTemplate();
		miDao = new MovieInfoDAO();
	}

	public List<MovieInfo> selectList() {
		SqlSession session = sqlSessiontemplate.getSqlSession();
		List<MovieInfo> miList = miDao.selectList(session);
		return miList;
	}
	
	
}
