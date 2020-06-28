package service;

import dao.impl.UserDao;
import domain.User;

public class UserService {
    UserDao userDao = new UserDao();
    public User login(User user){
        return userDao.findByUidAndPassword(user.getUid(),user.getPassword());
    }

    public String findUsernameByUid(Integer uid){
         User user = userDao.findByUid(uid);
         return user.getUsername();
    }
}
