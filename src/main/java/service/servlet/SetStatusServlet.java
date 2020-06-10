package service.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.ResultInfo;
import service.TaskService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/SetStatusServlet")
public class SetStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer uid = Integer.valueOf(request.getParameter("uid"));
        Integer tid = Integer.valueOf(request.getParameter("tid"));
        String username = request.getParameter("username");

        UserService userService = new UserService();
        TaskService taskService = new TaskService();
        ResultInfo resultInfo = new ResultInfo();

        if(Objects.equals(username, userService.findUsernameByUid(uid))){
            if(taskService.updateTaskStatus(uid,tid,true)){
                resultInfo.setFlag(true);
                resultInfo.setMsg("签到成功");
            } else {
                resultInfo.setFlag(false);
                resultInfo.setMsg("操作数据库时出错");
            }
        } else {
            resultInfo.setFlag(false);
            resultInfo.setMsg("学号与姓名不匹配");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        objectMapper.writeValue(response.getOutputStream(),resultInfo);
    }
}
