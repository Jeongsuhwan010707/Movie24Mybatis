package movie24.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie24.notice.model.service.NoticeService;
import movie24.notice.model.vo.Notice;
import movie24.notice.model.vo.PageData;

@WebServlet("/movie24/post.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService service = new NoticeService();
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int start = 1+ (currentPage-1)*14; //1 15 29
		int end = (currentPage*14); // 14 28 42
		PageData pdNum = new PageData(start, end);
		PageData pd = service.selectNoticeList(currentPage, pdNum);
		Notice notice0 = service.selectOneByNo(0);
		List<Notice> nList = pd.getnList();
		request.setAttribute("nList", nList);
		request.setAttribute("notice0", notice0);
		request.setAttribute("pageNavi", pd.getPageNavi());
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/help/Movie24_post.jsp");
		view.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
