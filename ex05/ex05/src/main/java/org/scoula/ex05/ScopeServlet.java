package org.scoula.ex05;

import org.scoula.ex05.domain.Member;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
    private ServletContext sc;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        sc = config.getServletContext(); //application 영역인 데이터 가져오기 -init() 서블릿이 처음 생길 때
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Application 영역에다가 저장한다.
        sc.setAttribute("scopeName", "applicationScope 값"); // Application Scope
        //Session 객체 가져온다.
        HttpSession session = request.getSession(); // Session Scope
        //Session 영역에 저장한다.
        session.setAttribute("scopeName", "sessionScope 값");
        //request 영역에 set 저장하기
        request.setAttribute("scopeName", "requestScope 값"); // Request Scope
        //객체 생성한 영역 마저도 Request 영역에다가 저장한다.
        Member member = new Member("홍길동", "hong");
        //Request 영역에 set 저장하기 - 객체 저장
        request.setAttribute("member", member);
        //Forward -> scope.jsp로 가면 된다.
        request.getRequestDispatcher("scope.jsp").forward(request, response);
    }
}
