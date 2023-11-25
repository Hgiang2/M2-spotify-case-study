package entity;

public class RequestArtistRegistered extends Request{
    public RequestArtistRegistered(String stageName) {
        super(stageName, "has requested to register as an Artist");
    }

    @Override
    public void solve() {

    }

    @Override
    public String getStatus() {
       return "Spotify: Check your Artist Register as " + getUsername() + "request";
    }
}
