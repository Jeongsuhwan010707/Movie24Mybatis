package movie24.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import movie24.member.model.service.MovieMemberService;
import movie24.member.model.vo.MovieMember;


@WebServlet("/movie24/checkId.do")
public class CheckIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckIdController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieMemberService service = new MovieMemberService();
		String memberId = request.getParameter("member-id");
		int result = 0;
		MovieMember movieMember = service.selectOneById(memberId);
		if(memberId == null) {
			EnrollController.alertAndBack(response, "아이디를 입력해주세요.");
		}else {			
			if(movieMember == null) {		
				EnrollController.alertAndBack(response, "사용가능한 아이디 입니다.");
			}else {
				request.setAttribute("memberId", memberId);
				request.setAttribute("msg", "중복된 아이디는 사용하실 수 없습니다.");
				request.setAttribute("url", "/movie24/agree.do");
				request.getRequestDispatcher("/WEB-INF/views/successOrFail/serviceSuccess.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
