package dao;

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

public class IUserDaoTest {

    private InputStream in;
    private SqlSession session;
    IUserDao dao;

    @Before
    public void init(){
        try {
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            session = factory.openSession();
            dao = session.getMapper(IUserDao.class);
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
    public void findUser(){
        User user1 = new User();
        user1.setGender("男");
        List<User> list = dao.findUser(user1);
        for (User user : list) {
            System.out.println(user);
        }
    }

}
