package service.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.ResultInfo;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet触发");

        User user = new User();
        try {
            BeanUtils.populate(user,request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService userService = new UserService();
        user = userService.login(user);
        ResultInfo resultInfo = new ResultInfo();


        if(user.getUid() == null || user.getPassword() == null){
            resultInfo.setFlag(false);
            resultInfo.setMsg("账号或密码错误");
        } else {
            resultInfo.setFlag(true);
            resultInfo.setMsg("登陆成功");
            HttpSession session = request.getSession();
            session.setAttribute("uid",user.getUid());
        }

        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("application/json;charset = utf-8");
        objectMapper.writeValue(response.getOutputStream(),resultInfo);
    }

}
