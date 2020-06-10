package service;

import dao.UserDao;
import domain.User;
import org.junit.jupiter.api.Test;

public class UserService {
    UserDao userDao = new UserDao();
    public User login(User user){
        return userDao.findByUidAndPassword(user.getUid(),user.getPassword());
    }

    public String findUsernameByUid(Integer uid){
         User user = userDao.findByUid(uid);
         return user.getUsername();
    }
    @Test
    public void loginTest(){
        //System.out.println(login(1,"JINXUyang123"));
    }
}
