package movie24.member.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie24.member.model.service.MovieMemberService;
import movie24.member.model.vo.MovieMember;


@WebServlet("/movie24/myPage.do")
public class MyInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieMemberService service = new MovieMemberService();
		String memberId = request.getParameter("member-id");
		MovieMember member = service.selectOneById(memberId);
		request.setAttribute("member", member);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/login/Movie24_myPage.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}






