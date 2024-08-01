package org.scoula.ex05;

import org.scoula.ex05.domain.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/jstl_ex")
public class JstlServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        List<Member> members = new ArrayList<>();
        for(int i=0;i<10;i++){
            Member member = new Member("홍길동_"+i,"hong_"+i);
            members.add(member);
        }
        request.setAttribute("members", members);//어떤 키명으로 저장했는지 중요(members, role)
        request.setAttribute("role","ADMIN");

        request.setAttribute("today", new Date());

        request.getRequestDispatcher("jstl_ex.jsp")
                .forward(request, response);

    }
}
