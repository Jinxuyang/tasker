package dao.impl;

import domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;
import java.util.Map;

public class UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    public User findByUidAndPassword(Integer uid,String password){
        User user = new User();
        String sql = "SELECT * FROM tasker.users WHERE uid = ? AND password = ?";
        try {
            user = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),uid,password);
        } catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            System.out.println("jdbcTemplate出错");
        }
        return user;
    }

    public List<Map<String,Object>> findUndoneUsernameByTid(Integer tid){
        String sql = "SELECT username FROM users,t_users_tasks WHERE users.uid = t_users_tasks.uid AND t_users_tasks.status = false AND t_users_tasks.tid = ?";
        return jdbcTemplate.queryForList(sql,tid);
    }

    public User findByUid(Integer uid){
        String sql = "SELECT * FROM tasker.users WHERE uid = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),uid);
    }
}
