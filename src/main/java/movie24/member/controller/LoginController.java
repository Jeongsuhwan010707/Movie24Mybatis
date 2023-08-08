package movie24.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import movie24.member.model.service.MovieMemberService;
import movie24.member.model.vo.MovieMember;

@WebServlet("/movie24/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login/Movie24_login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		MovieMember member = new MovieMember(memberId, memberPw);
		
		MovieMemberService service = new MovieMemberService();
		MovieMember mOne = service.selectCheckLogin(member);
		if(mOne != null) {
			HttpSession session = request.getSession();
			session.setAttribute("memberId", mOne.getMemberId());
			session.setAttribute("memberNickname", mOne.getMemberNickname());
			EnrollController.alertAndGo(response, memberId+"님 환영합니다.", "/");
		}else {
			EnrollController.alertAndBack(response, "아이디/비밀번호를 다시 한 번 확인해주세요.");
		}
		
	}

}

















