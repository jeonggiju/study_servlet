package hello.servlet.web.frontcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class MyView {
    private String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    /**
     * rendering : 뷰를 만드는 행위 자체를 말한다.
     * - JSP 를 랜더링하거나, 랜더링하도록 포워드해서 이동을 하는 등등.
    * */
    // v2 에서 사용
    public void render(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }

    // v3 에서 추가
    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        modelToRequestAttribute(model, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
         dispatcher.forward(request, response);
    }

    // v3 에서 추가
    private static void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        // JSP 는 request 의 attribute 에서 값을 꺼낸다.
        model.forEach((key, value) -> request.setAttribute(key, value));
    }


}
