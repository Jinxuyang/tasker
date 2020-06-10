package domain;

public class ResultInfo {
    private boolean flag;
    private String msg;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResultSet{" +
                "flag=" + flag +
                ", msg='" + msg + '\'' +
                '}';
    }
}
