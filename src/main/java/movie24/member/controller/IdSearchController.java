package movie24.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie24.member.model.service.MovieMemberService;
import movie24.member.model.vo.MovieMember;


/**
 * Servlet implementation class IdSearchController
 */
@WebServlet("/movie24/searchId.do")
public class IdSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IdSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login/Movie24_id.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberName = request.getParameter("member-name");
		String memberPhone = request.getParameter("member-phone");
		String memberEmail = request.getParameter("member-email");
		if(memberName == null || memberPhone == null || memberEmail == null) {
			EnrollController.alertAndBack(response, "모든 정보를 입력해주세요.");
		}
		MovieMember member = new MovieMember(memberName, memberPhone, memberEmail);
		MovieMemberService service = new MovieMemberService();
		MovieMember mOne = service.searchId(member);
		if(mOne != null) {
			EnrollController.alertAndGo(response, "회원님의 아이디는 "+mOne.getMemberId()+"입니다.", "/movie24/searchPw.do");
		}else {
			EnrollController.alertAndBack(response, "회원님의 정보가 존재하지 않습니다.");
		}
	}

}
