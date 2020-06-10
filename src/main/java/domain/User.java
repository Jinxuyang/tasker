package domain;


public class User {
    private Integer uid;
    private String username;
    private String password;
    private String gender;
    private String qq;
    private String email;
    private Integer clAss;

    public User() {
    }

    public User(Integer uid, String username, String password, String gender, String qq, String email, Integer clAss) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.qq = qq;
        this.email = email;
        this.clAss = clAss;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getClAss() {
        return clAss;
    }

    public void setClAss(Integer clAss) {
        this.clAss = clAss;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                ", clAss=" + clAss +
                '}';
    }
}
