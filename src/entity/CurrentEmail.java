package entity;

import java.util.List;

public class CurrentEmail {
    private List<Email> emails;
    private Email currentEmail;
    private CurrentEmail() {
        super();
        emails = EmailList.getInstance().getValidEmail();
    }
    private static CurrentEmail instance;
    public static CurrentEmail getInstance() {
        if(instance == null) {
            instance = new CurrentEmail();
        }
        return instance;
    }

    public Email getCurrentEmail() {
        return currentEmail;
    }

    public void setCurrentEmail(String emailName) {
        for(Email email : emails) {
            if(email.getEmail().equals(emailName)) {
                currentEmail = email;
                return;
            }
        }
    }
}
