package service;

import domain.Task;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TaskServiceTest {
    ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
    TaskService taskService = (TaskService) ac.getBean("TaskService");
    @Test
    public void test(){
        Task task =  new Task();
        task.setTitle("test");
        task.setCreateFor(1);
        task.setCreaterId(14);
        task.setType(2);
        System.out.println(taskService.add(task));
    }
}
