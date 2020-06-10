package service.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.ResultInfo;
import domain.Task;
import org.junit.jupiter.api.Test;
import service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/CreateTaskServlet")
public class CreateTaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ResultInfo resultInfo = new ResultInfo();
        Integer uid = (Integer) request.getSession().getAttribute("uid");

        if(uid == null){
            resultInfo.setFlag(false);
            resultInfo.setMsg("禁止访问");
        } else {
            System.out.println("成功获取uid");
            Task task = new Task();
            task.setTitle(request.getParameter("title"));
            task.setContent(request.getParameter("content"));
            task.setCreateFor(Integer.valueOf(request.getParameter("createFor")));
            task.setCreaterId(uid);

            String time = request.getParameter("deadline");
            if(time.length() <= 0){
                task.setType(1);
                task.setDeadline(null);
            }else{
                try {
                   Date deadline = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(time);
                   task.setDeadline(deadline);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                task.setType(2);
            }

            TaskService taskService = new TaskService();
            System.out.println(task);
            boolean flag = taskService.add(task);
            if(flag){
                resultInfo.setFlag(true);
                resultInfo.setMsg("创建成功,转跳中...");
            }else {
                resultInfo.setFlag(false);
                resultInfo.setMsg("创建任务是出现问题");
            }

        }

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),resultInfo);
    }

    @Test
    public void test(){

    }
}
