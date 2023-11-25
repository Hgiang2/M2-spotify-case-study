package entity;

import constant.Constants;

public class Artist extends User{
//    private List<Song> thisArtistSong = new ArrayList<>();
    String stageName;

    public Artist(String stageName) {
        super(Constants.BLANK, Constants.BLANK, "artist");
        this.stageName = stageName;
    }

    public Artist(String username, String password) {
        super(username, password, "artist");
    }

    @Override
    public String toString() {
        return getStageName();
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getStageName() {
        return stageName;
    }
}
