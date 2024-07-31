package org.scoula.dynamicweb.session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/cart_view")
public class CartViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("장바구니 리스트<br>");

        // 세션 객체 얻기
        HttpSession session = request.getSession(false);

        // 세션 타임아웃 설정 (20초)
        if (session != null) {
            session.setMaxInactiveInterval(20);
            ArrayList<String> list = (ArrayList<String>) session.getAttribute("product");
            if (list != null && !list.isEmpty()) {
                out.print("상품: " + list.toString() + "<br>");
            } else {
                out.print("장바구니가 비어 있습니다.<br>");
            }
        } else {
            out.print("세션 없음<br>");
        }

        out.print("<a href='session_product.jsp'>상품 선택 페이지</a><br>");
        out.print("<a href='cart_delete'>장바구니 비우기</a><br>");
        out.print("</body></html>");
    }
}


