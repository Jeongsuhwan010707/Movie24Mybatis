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


@WebServlet("/movie24/updateInfo.do")
//@WebServlet("/movie24/myUpdate.do")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieMemberService service = new MovieMemberService();
		String memberId = request.getParameter("member-id");
		MovieMember member = service.selectOneById(memberId);
		request.setAttribute("member", member);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/login/Movie24_update.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		String memberName = request.getParameter("member-name");
		String memberNickname = request.getParameter("member-nickName");
		String memberAddress = request.getParameter("member-address");
		String memberPhone = request.getParameter("member-phone");
		String memberEmail = request.getParameter("member-email");
		String memberEmailYN = request.getParameter("member-emailYN") == null ? "N" : "Y";
		MovieMemberService service = new MovieMemberService();
		MovieMember member = new MovieMember(memberId, memberPw, memberName, memberNickname, memberAddress, memberPhone, memberEmail, memberEmailYN);
		int result = service.updateMember(member);
		if(result > 0) {
			EnrollController.alertAndGo(response, "정보수정을 완료했습니다.", "/");
		}else {
			EnrollController.alertAndBack(response, "정보수정에 실패했습니다.");
		}
	}

}


























