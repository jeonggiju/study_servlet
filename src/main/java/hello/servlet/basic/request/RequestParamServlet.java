package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;


/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 * 2. HTML form
 * 데이터가 전달될 때 application/x-www-form-urlencoded 형식은 쿼리 파라미터의 형식과 같다.
 * 따라서 쿼리 파라미터 조회 메서드를 그대로 사용하면 된다.
 * */
@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");
        request.getParameterNames().asIterator().forEachRemaining(parameterName -> {
            System.out.println(parameterName + " = " + request.getParameter(parameterName));
        });
        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회] - start");
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("[단일 파라미터 조회] - end");
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회] - start");
        // 이름이 여러 개인 경우 getParameterValues 를 사용한다.
        String[] usernames = request.getParameterValues("username");
        for(String name : usernames) {
            System.out.println("username = " + name);
        }
        System.out.println("[이름이 같은 복수 파라미터 조회] - end");
        System.out.println();

        response.getWriter().write("ok");
    }
}
