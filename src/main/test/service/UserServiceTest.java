package service;

import domain.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
    UserService userService = (UserService) ac.getBean("UserService");
    @Test
    public void test(){
        User user = new User();
        user.setUid(14);
        user.setPassword("JINXUyang123");
        System.out.println(userService.login(user));
    }
}
