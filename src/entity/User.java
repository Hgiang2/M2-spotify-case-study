package entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Request> requestList = new ArrayList<>();
//    private String email;
    private String username;
    private String password;
    private String role;
    private Plan plan;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String role, boolean isSubscribe) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.plan = new Plan(isSubscribe);
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Plan getPlan() {
        return plan;
    }

    public List<Request> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Request> requestList) {
        this.requestList = requestList;
    }

    public void setPlan(boolean isSubscribe) {
        this.plan = new Plan(isSubscribe);
    }
}
