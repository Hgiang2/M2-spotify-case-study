package entity;

import java.util.ArrayList;
import java.util.List;

public class Email {
    private String email;
    private List<Request> requests;

    private static Email instance;

    private Email() {
        requests = new ArrayList<>();
    }

    public static Email getInstance() {
        if (instance == null) {
            instance = new Email();
        }
        return instance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public void addEmailRequest(Request request) {
        requests.add(request);
    }
}
