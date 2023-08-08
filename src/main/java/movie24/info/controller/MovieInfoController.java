package movie24.info.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie24.info.model.service.MovieInfoService;
import movie24.info.model.vo.MovieInfo;

@WebServlet("/movie24/movieInfo.do")
public class MovieInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MovieInfoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieInfoService service = new MovieInfoService();
		List<MovieInfo> mList = service.selectList();
		request.getRequestDispatcher("/WEB-INF/views/info/Movie24_movie_Info.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
