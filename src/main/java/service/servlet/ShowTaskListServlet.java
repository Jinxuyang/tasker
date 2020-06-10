package service.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Task;
import service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowTaskListServlet")
public class ShowTaskListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TaskService taskService = new TaskService();
        List<Task> list = taskService.findByClass(Integer.valueOf(request.getParameter("createFor")));
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),list);
    }
}
