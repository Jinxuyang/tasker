package dao;

import domain.Task;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ITaskDaoTest {
    private InputStream in;
    private SqlSession session;
    ITaskDao dao;
    IUserDao dao1;
    @Before
    public void init(){
        try {
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            session = factory.openSession();
            dao = session.getMapper(ITaskDao.class);
            dao1 = session.getMapper(IUserDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void destory(){
        try {
            in.close();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findTask(){
        Task task = new Task();
        task.setTitle("易班");
        List<Task> list = dao.findTask(task);
        for (Task task1 : list) {
            System.out.println(task1);
        }
    }
    @Test
    public void addTask(){
        Task task = new Task();
        task.setTitle("test");
        task.setCreaterId(14);
        task.setCreateFor(1);
        task.setType(1);
        int tid = dao.addTask(task);
        System.out.println(task.getTid());
    }
    @Test
    public void addAutoTask(){
        User user = new User();
        user.setClAss(1);
        List<User> list = dao1.findUser(user);
        dao.addAutoTask(list,26);
    }
}
