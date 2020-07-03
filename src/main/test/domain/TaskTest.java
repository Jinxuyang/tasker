package domain;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TaskTest {
    ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
    Task task = (Task) ac.getBean("Task");
    @Test
    public void test(){
        System.out.println(task);
    }
}
