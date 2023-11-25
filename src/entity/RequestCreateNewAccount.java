package entity;

public class RequestCreateNewAccount extends Request{
    public RequestCreateNewAccount(String username) {
        super(username, "has requested to create a new Spotify account.");
    }

    @Override
    public void solve() {

    }

    @Override
    public String getStatus() {
        return null;
    }
}
