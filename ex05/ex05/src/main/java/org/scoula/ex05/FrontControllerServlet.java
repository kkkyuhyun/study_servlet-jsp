package org.scoula.ex05;

import org.scoula.ex05.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static jdk.javadoc.internal.tool.Main.execute;

@WebServlet(name ="frontControllerServlet", value="/")
public class FrontControllerServlet extends HttpServlet {
    Map<String, Command> getMap; //GET 요청
    Map<String, Command> postMap; //POST 요청

    String prefix = "/views/";
    String suffix = ".jsp";

    HomeController homeController = new HomeController();
    TodoController todoController = new TodoController();

    private String getCommandName(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String contextPath=request.getContextPath();
        return requestURI.substring(contextPath.length());
    }
    private Command getCommand(HttpServletRequest request){
        String commandName = getCommandName(request);

        Command command;
        if(request.getMethod().equalsIgnoreCase("GET")){
            command = getMap.get(commandName);
        }else{
            command = postMap.get(commandName);
        }
        return command;
    }

    public void init(){ //cli 프레임워크 메뉴 역할을 한다.
        getMap = new HashMap<>();
        postMap = new HashMap<>();

        getMap.put("/", homeController::getIndex);
        //'/'일때 homeController::getIndex 실행하겠다(메서드 참조해서 연결하겠다)

        getMap.put("/todo/list", todoController::getList);
        getMap.put("/todo/view", todoController::getView);
        getMap.put("/todo/create", todoController::getCreate);
        getMap.put("/todo/update", todoController::getUpdate);

        postMap.put("/todo/create",todoController::postCreate);
        postMap.put("/todo/update", todoController::postUpdate);
        postMap.put("/todo/delete", todoController::postDelete);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = getCommand(request);
        if(command!=null){
            execute(command, request, response);
        }else{//404에러처리
            String view= prefix +"404" +suffix;
            RequestDispatcher dis = request.getRequestDispatcher(view);
            dis.forward(request, response);
            
        } //개별 Controller Forwarding redirect get 요청일 때는 forwarding <- 이 정보를 보여줄려면
        //get 요청은 forwarding 처리
        //WEB -INF
    }

    private void execute(Command command, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        String viewName = command.execute(request,response);
        if(viewName.startsWith("redirect:")){
            response.sendRedirect(viewName.substring("redirect:".length()));
        }else{
            String view = prefix+viewName+suffix;
            RequestDispatcher dis = request.getRequestDispatcher(view);
            dis.forward(request, response);
        }
    }



    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }//post 요청 리턴값 리다이렉트 url
    //"redirect: redirect url"형식
}
