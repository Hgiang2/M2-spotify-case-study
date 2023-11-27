package entity;

import services.observer.Observer;
import services.observer.Subject;

public class RequestArtistRegistered extends Subject implements Request {
    private boolean isApproved;
    private boolean isRejected;
    private String username;
    private String description;
    private String email;
    private String GmailDetail;
    private String reason;

    public RequestArtistRegistered(String username) {
        this.isApproved = false;
        this.isRejected = false;
        this.username = username;
        this.description = " has requested to register as an Artist.";
        this.GmailDetail = "Your request is waiting to be approved...";
    }

    @Override
    public void solve() {
        Observer observeAllUser = ValidUsersList.getInstance();
        addObserver(observeAllUser);
        User artist = new Artist(getUsername());
        artist.setPassword(generatePassword());
        ValidUsersList.getInstance().getValidUsers().add(artist);
        setGmailDetail("Hi " + getUsername() + "! Your Artist Register request has been approved by the administrator!\nPlease use your email address and the password below to log in:\nYour password: " + artist.getPassword());
        notifyObserver();
        removeAll();
    }

    @Override
    public String getGmailNoti() {
        return "From Spotify: Register as Artist[" + getUsername() + "] request!";
    }

    @Override
    public String getGmailMessage() {
        return getGmailNoti() + "\n" + getGmailDetail();
    }

    private String generatePassword() {
        String name = getUsername().replaceAll("\\s", "").toLowerCase();
        StringBuilder password = new StringBuilder(name.substring(0, 1).toUpperCase() + name.substring(1));

        for (int i = 0; i < 5; i++) {
            password.append(String.valueOf(Math.floor(Math.random() * 9)));
        }
        password.append("!");
        return password.toString();
    }

    @Override
    public boolean isApproved() {
        return isApproved;
    }

    @Override
    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    @Override
    public boolean isRejected() {
        return isRejected;
    }

    @Override
    public void setRejected(boolean rejected) {
        isRejected = rejected;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getGmailDetail() {
        return GmailDetail;
    }

    @Override
    public void setGmailDetail(String gmailDetail) {
        GmailDetail = gmailDetail;
    }

    @Override
    public String getReason() {
        return reason;
    }

    @Override
    public void setReason(String reason) {
        this.reason = reason;
    }
}
