package service.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/GetUndoneUserListServlet")
public class GetUndoneUserListServlet extends HttpServlet {
    private TaskService taskService;

    public GetUndoneUserListServlet(TaskService taskService) {
        this.taskService = taskService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer tid = Integer.valueOf(request.getParameter("tid"));
        List<String> list = taskService.findUndoneUsers(tid);
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        objectMapper.writeValue(response.getOutputStream(),list);
    }

}
