package movie24.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie24.notice.model.service.NoticeService;
import movie24.notice.model.vo.Notice;


@WebServlet("/notice/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// a 링크로 이동하면 get메소드 발동됌
		NoticeService service = new NoticeService();
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		Notice notice = service.selectOneByNo(noticeNo);
		request.setAttribute("notice", notice);
		request.getRequestDispatcher("/WEB-INF/views/help/Movie24_post_modify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// dopost는 submit하면 발동됌
		NoticeService service = new NoticeService(); 
		request.setCharacterEncoding("UTF-8");
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo")); 
		String noticeSubject = request.getParameter("noticeSubject");
		String noticeContent = request.getParameter("noticeContent");
		Notice notice = new Notice(noticeNo ,noticeSubject, noticeContent);
		int result = service.updateNotice(notice);
		if(result > 0) {
			notice = service.selectOneByNo(noticeNo);
			request.setAttribute("notice", notice);
			request.getRequestDispatcher("/movie24/postInfo.do?noticeNo="+notice.getNoticeNo()).forward(request, response);
		}else {
			request.setAttribute("msg", "공지사항 수정이 완료되지 않았습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp").forward(request, response);
		}
	}

}
