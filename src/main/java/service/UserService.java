package service;

import dao.IUserDao;
import domain.User;

import java.util.List;

public class UserService {
    IUserDao userDao;
    User user;

    public UserService(IUserDao userDao, User user) {
        this.userDao = userDao;
        this.user = user;
    }

    public List<User> login(User user){

        return userDao.findUser(user);
    }
    public String findUsernameByUid(Integer uid){
        user.setUid(uid);
        List<User> list = userDao.findUser(user);
        return list.get(0).getUsername();
    }
}
