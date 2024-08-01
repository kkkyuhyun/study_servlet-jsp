package org.scoula.ex05.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    String execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
//frontcontroller command execute() 실행
//비즈니스 로직이 끝났다 -> view로 갈지 redirect로 갈지 return view로 forwarding할지 redirect로 forwarding할지
//url.command interface 매핑 구성
//cli 프레임워크 네임 같은 개념 구성

