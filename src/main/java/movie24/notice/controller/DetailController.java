package movie24.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie24.notice.model.service.NoticeService;
import movie24.notice.model.vo.Notice;

@WebServlet("/movie24/postInfo.do")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		NoticeService service = new NoticeService();
		int noticeBack = noticeNo+1;
		int noticeNext = noticeNo-1;
		Notice notice = service.selectOneByNo(noticeNo);
		Notice noticeB = service.selectOneByNo(noticeBack);
		Notice noticeN = service.selectOneByNo(noticeNext);
		int totalNum = service.selectTotal();
		
		if(notice != null) {
			request.setAttribute("notice", notice);
			if(noticeB != null) {				
				request.setAttribute("noticeB", noticeB);
			}
			if(noticeN != null) {				
				request.setAttribute("noticeN", noticeN);
			}
			request.setAttribute("totalNum", totalNum);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/help/Movie24_post_info.jsp");
			view.forward(request, response);
		}else {
			request.setAttribute("msg", "데이터가 존재하지 않습니다.");
			request.getRequestDispatcher("/WEB-INF/views/successOrFail/serviceFailed.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
