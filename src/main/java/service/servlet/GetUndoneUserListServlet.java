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
import java.util.Map;

@WebServlet("/GetUndoneUserListServlet")
public class GetUndoneUserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer tid = Integer.valueOf(request.getParameter("tid"));
        TaskService taskService = new TaskService();
        List<Map<String,Object>> list = taskService.findUndoneUserByTid(tid);
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        objectMapper.writeValue(response.getOutputStream(),list);
    }

}
