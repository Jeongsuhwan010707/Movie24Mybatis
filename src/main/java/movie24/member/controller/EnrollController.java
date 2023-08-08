package movie24.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie24.member.model.service.MovieMemberService;
import movie24.member.model.vo.MovieMember;


@WebServlet("/movie24/register.do")
public class EnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EnrollController() {
        super();
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
		String memberEmailYN = request.getParameter("member-emailYN") != null ? "Y" : "N";
		MovieMember member = new MovieMember(memberId, memberPw, memberName, memberNickname, memberAddress, memberPhone, memberEmail, memberEmailYN); 
		MovieMemberService service = new MovieMemberService();
		int result = service.insertMember(member);
		if(memberId == null || memberPw == null || memberName == null || memberNickname == null || memberAddress == null ||
				memberPhone == null || memberEmail == null) {
			alertAndBack(response, "입력하지 않은 정보가 있습니다");
		}
		if(memberNickname.equals("관리자")) {
			EnrollController.alertAndBack(response, "사용할 수 없는 닉네임입니다.");
		}
		if(result > 0) {
			alertAndGo(response,"회원가입을 성공하였습니다","/movie24/signDone.do");
		}
		else {
			alertAndBack(response, "회원가입을 실패하였습니다");
		}
	}
	
	public static void alertAndBack(HttpServletResponse response, String msg) {
	    try {
	        response.setContentType("text/html; charset=utf-8");
	        PrintWriter w = response.getWriter();
	        w.write("<script>alert('"+msg+"');history.go(-1);</script>");
	        w.flush();
	        w.close();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	public static void alertAndGo(HttpServletResponse response, String msg, String url) {
	    try {
	        response.setContentType("text/html; charset=utf-8");
	        PrintWriter w = response.getWriter();
	        w.write("<script>alert('"+msg+"');location.href='"+url+"';</script>");
	        w.flush();
	        w.close();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	public static void alert(HttpServletResponse response, String msg) {
	    try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter w = response.getWriter();
			w.write("<script>alert('"+msg+"');</script>");
			w.flush();
			w.close();
	    } catch(Exception e) {
			e.printStackTrace();
	    }
	}

}
