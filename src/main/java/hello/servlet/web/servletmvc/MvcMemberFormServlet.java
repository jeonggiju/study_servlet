package hello.servlet.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    // controller
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MvcMemberFormServlet.service");
        /**
         * WEB-INF 에 있으면 웹브라우저 경로로 직접 접근이 불가하다.
         * */
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath); // controller 에서 view 로 이동할 때 사용
        /**
         * dispatcher.forward(request, response)
         * 다른 서블릿이나 jsp 로 이동할 수 있는 기능 - 서버 내부에서 호출
         * 리다이렉트(클라이언트 웹브라우저에 다시 응답이 갔다가 웹브라우저가 다시 요청하는 것)이 아니다.
         * 서버 내부에서 호출되는 것이다. 메서드 한번 호출하듯이 호출이 일어나는 것
         */
        dispatcher.forward(request, response);
    }
}
