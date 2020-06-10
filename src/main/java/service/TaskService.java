package service;

import dao.TaskDao;
import dao.UserDao;
import domain.Task;

import java.util.List;
import java.util.Map;

public class TaskService {
    TaskDao taskDao = new TaskDao();
    UserDao userDao = new UserDao();

    public boolean add(Task task){
        return taskDao.add(task);
    }

    public List<Task> findByClass(Integer createFor){
        return taskDao.findByClass(createFor);
    }

    public Task findByTid(Integer tid){
        return taskDao.findByTid(tid);
    }

    public List<Map<String,Object>> findUndoneUserByTid(Integer tid){
        return userDao.findUndoneUsernameByTid(tid);
    }

    public boolean updateTaskStatus(Integer uid,Integer tid,boolean status){
        return taskDao.updateTaskStatus(uid,tid,status);
    }


}
