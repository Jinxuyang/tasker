package dao;

import domain.Task;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;
import java.util.Map;

public class TaskDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    public boolean add(Task task){
        String sql = "INSERT INTO tasker.tasks (title,content,deadline,createFor,createrId,type) VALUES (?,?,?,?,?,?)";
        int cnt = jdbcTemplate.update(sql,task.getTitle(),task.getContent(),task.getDeadline(),task.getCreateFor(),task.getCreaterId(),task.getType());
        if(cnt > 0){

            String sql1 = "SELECT max(tid) AS tid FROM tasker.tasks";
            Map<String,Object> map = jdbcTemplate.queryForMap(sql1);
            int tid = (int) map.get("tid");
            if(tid > 0){
                String sql2 = "SELECT uid FROM tasker.users WHERE class = ?";
                List<Map<String,Object>> list = jdbcTemplate.queryForList(sql2,task.getCreateFor());
                int cnt2 = 0;
                System.out.println(list);
                for (Map<String, Object> stringObjectMap : list) {
                    String sql3 = "INSERT INTO tasker.t_users_tasks (uid,tid,status,type) VALUE (?,?,?,?)";
                    cnt2 = jdbcTemplate.update(sql3,stringObjectMap.get("uid"),tid,false,task.getType());
                }
                return cnt2 > 0;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    @Test
    public void test(){
        Task task = new Task();
        add(task);
    }
    public List<Task> findByClass(Integer createFor){
        String sql = "SELECT * FROM tasker.tasks WHERE createFor = ?";
        List<Task> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Task>(Task.class),createFor);
        return list;
    }

    public Task findByTid(Integer tid){
        String sql = "SELECT * FROM tasker.tasks WHERE tid = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Task>(Task.class),tid);
    }

    public boolean updateTaskStatus(Integer uid,Integer tid,boolean status){
        String sql = "UPDATE tasker.t_users_tasks SET status = ? WHERE uid = ? AND tid = ?";
        int cnt = jdbcTemplate.update(sql,status,uid,tid);
        return cnt > 0;
    }

}
