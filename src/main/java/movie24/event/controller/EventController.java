package movie24.event.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie24.event.model.service.EventService;
import movie24.member.controller.EnrollController;

@WebServlet("/movie24/event.do")
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EventController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eventSrcNum = Integer.parseInt(request.getParameter("eventSrcNum"));
		EventService service = new EventService();
		String src = service.getEventImage(eventSrcNum);
		if(src != null) {
			request.setAttribute("src", src);
			request.getRequestDispatcher("/WEB-INF/views/event/Movie24_event_info.jsp").forward(request, response);
		}else {
			EnrollController.alertAndBack(response, "뭔가 실수가 있었던 것 같습니다.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
