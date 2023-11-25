package entity;

import constant.Constants;

public class Artist extends User{
//    private List<Song> thisArtistSong = new ArrayList<>();
    String stageName;

    public Artist(String stageName) {
        super(Constants.BLANK, Constants.BLANK, Constants.ARTIST, false);
        this.stageName = stageName;
    }

    @Override
    public String toString() {
        return getStageName();
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getStageName() {
        return this.stageName;
    }
}
