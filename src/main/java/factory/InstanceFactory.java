package factory;

import dao.ITaskDao;
import dao.IUserDao;
import domain.ResultInfo;
import domain.Task;
import domain.User;
import org.apache.ibatis.session.SqlSession;

public class InstanceFactory {
    private SqlSession session;

    public InstanceFactory(SqlSession session) {
        this.session = session;
    }

    public Task getTask(){
        return new Task();
    }
    public User getUser(){
        return new User();
    }
    public ResultInfo getResultInfo(){
        return new ResultInfo();
    }
    public IUserDao getIUserDao() { return session.getMapper(IUserDao.class); }
    public ITaskDao getITaskDao(){
        return session.getMapper(ITaskDao.class);
    }
}
