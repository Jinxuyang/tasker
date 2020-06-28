package dao;

import domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findUser(User user);
    User setUserInfo(User user);
}
