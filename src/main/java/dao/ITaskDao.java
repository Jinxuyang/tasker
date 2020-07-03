package dao;

import domain.Task;
import domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ITaskDao {
    List<Task> findTask(Task task);
    Integer addTask(Task task);
    Integer addAutoTask(@Param("list") List<User> list,@Param("tid") Integer tid);
    List<String> findUndoneUsers(@Param("tid") Integer tid);
    Integer updateTaskStatus(@Param("tid") Integer tid,@Param("uid") Integer uid,@Param("status") boolean status);
}
