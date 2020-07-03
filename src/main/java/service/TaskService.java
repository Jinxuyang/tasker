package service;

import dao.ITaskDao;
import dao.IUserDao;
import domain.Task;
import domain.User;

import java.util.List;

public class TaskService {
    ITaskDao taskDao;
    IUserDao userDao;
    Task task;

    public TaskService(ITaskDao taskDao, IUserDao userDao, Task task) {
        this.taskDao = taskDao;
        this.userDao = userDao;
        this.task = task;
    }

    public boolean add(Task task){
        Integer i = taskDao.addTask(task);
        if (task.getType() ==1 ) {
            User user = new User();
            user.setClAss(task.getCreateFor());
            taskDao.addAutoTask(userDao.findUser(user),task.getTid());
        }
        return i > 0;
    }

    public List<Task> findByClass(Integer createFor){
        task.setCreateFor(createFor);
        return taskDao.findTask(task);
    }

    public List<Task> findByTid(Integer tid){
        task.setTid(tid);
        return taskDao.findTask(task);
    }

    public List<String> findUndoneUsers(Integer tid){
        return taskDao.findUndoneUsers(tid);
    }

    public boolean updateTaskStatus(Integer uid,Integer tid,boolean status){
        return taskDao.updateTaskStatus(uid,tid,status) > 0;
    }


}
