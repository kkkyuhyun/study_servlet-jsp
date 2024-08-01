package org.scoula.ex05;

import org.scoula.ex05.domain.Member;
import org.scoula.ex05.dto.LoginDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/*
@WebServlet("/login") // URL 패턴 지정
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userid = request.getParameter("userid");
        String passwd = request.getParameter("passwd");



        request.setAttribute("userid", userid);
        request.setAttribute("passwd", passwd);

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
*/
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1파라미터추출
        String userid = request.getParameter("userid");//userid에 저장
        String passwd = request.getParameter("passwd");

        LoginDTO loginDTO = new LoginDTO(userid, passwd);
        //2 비즈니스 로직 실행 request scope에 저장
        request.setAttribute("userid", userid);//scope 저장
        request.setAttribute("passwd", passwd);
        // 구성된 DTO를 login이라는 키로 저장
        request.setAttribute("login", loginDTO);
        //3결과 request
        //4 forward or redirect -- 에러나는 경우 : 경로를 잘못적었을 때 404 이런 경로 없다!

        HttpSession session = request.getSession();
        Member member = new Member("홍길동", "hong");
        session.setAttribute("member", member);

        request.getRequestDispatcher("login.jsp").forward(request, response);
        //포워딩 getRequestDispatcher login.jsp로 보낸다. forward 방식으로
    }
}
