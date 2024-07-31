package org.scoula.dynamicweb.cookie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cartSaveCookie")
public class CartSaveCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 입력 파라미터 얻기
        String product = request.getParameter("product");

        // 기존 쿠키 얻기
        Cookie[] cookies = request.getCookies();
        Cookie c = null;
        if (cookies == null || cookies.length == 0) {
            c = new Cookie("product", product);
        } else {
            c = new Cookie("product" + (cookies.length + 1), product);
        }

        // 쿠키 유효 시간 설정 (1시간)
        c.setMaxAge(60 * 60);

        // 쿠키 설정
        response.addCookie(c);

        out.println("<html><body>");
        out.println("<h1>Product added to cart: " + product + "</h1>");
        out.println("Product 추가!<br>");
        out.println("<a href='cookie_product_jsp'>상품 선택 페이지</a><br>");
        out.println("<a href='cart_view_cookie'>장바구니 보기</a>");
        out.println("</body></html>");
    }
}
