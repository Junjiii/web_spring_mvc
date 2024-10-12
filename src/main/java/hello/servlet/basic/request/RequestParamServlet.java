package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "requestParamServlet",urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[ 전체 파라미터 조회 start ]");
        request.getParameterNames().asIterator()
                .forEachRemaining(param -> System.out.println(param + " = " + request.getParameter(param)));
        System.out.println("[ 전체 파라미터 조회 end ]");

        System.out.println();

        System.out.println("[ 단일 파라미터 조회 ]");
        String parameter = request.getParameter("username");
        System.out.println("parameter = " + parameter);

        System.out.println();

        System.out.println("[ 이름이 같은 파라미터 ]");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("name = " + name);
        }


        response.getWriter().write("ok");
    }
}
