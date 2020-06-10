package domain;

import java.util.Date;

public class Task {
    private Integer tid;
    private String title;
    private String content;
    private Date createTime;
    private Date deadline;
    private Integer createFor;
    private Integer createrId;
    private Integer type;

    public Task() {
    }

    public Task(Integer tid, String title, String content, Date createTime, Date deadline, Integer createFor, Integer createrId, Integer type) {
        this.tid = tid;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.deadline = deadline;
        this.createFor = createFor;
        this.createrId = createrId;
        this.type = type;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Integer getCreateFor() {
        return createFor;
    }

    public void setCreateFor(Integer createFor) {
        this.createFor = createFor;
    }

    public Integer getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Integer createrId) {
        this.createrId = createrId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Task{" +
                "tid=" + tid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", deadline=" + deadline +
                ", createFor=" + createFor +
                ", createrId=" + createrId +
                ", type=" + type +
                '}';
    }
}
