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
import movie24.member.controller.EnrollController;

@WebServlet("/movie/info.do")
public class MovieInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MovieInfoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieInfoService service = new MovieInfoService();
		int MovieNum = Integer.parseInt(request.getParameter("movieNum"));
		MovieInfo mInfo = service.selectOnebyNo(MovieNum);
		if(mInfo != null) {
			request.setAttribute("mInfo", mInfo);
			request.getRequestDispatcher("/WEB-INF/views/info/Movie24_movie_Info.jsp").forward(request, response);
		}else {
			EnrollController.alertAndBack(response, "불러오기에 실패했습니다.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
