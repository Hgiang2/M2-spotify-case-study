package entity;

import services.observer.Subject;

public abstract class Request extends Subject {
    private boolean isApproved;
    private String username;
    private String description;

    public Request(String username, String description) {
        this.isApproved = false;
        this.username = username;
        this.description = description;
    }

    public void approve() {
        isApproved = true;
        this.solve();
    }

    public abstract void solve();

    public void reject() {
        isApproved = false;

    }

    public boolean isApproved() {
        return isApproved;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public abstract String getStatus();

    @Override
    public String toString() {
        return username + description;
    }
}
