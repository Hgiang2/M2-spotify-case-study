package services.validator;

import entity.Artist;
import entity.Song;
import services.AllSpotifyArtistList;

public class ValidateCheckArtistNameExisted implements Validator {
    private String stageName;

    public ValidateCheckArtistNameExisted(String stageName) {
        this.stageName = stageName;
    }

    @Override
    public boolean isCheck() {
        for (Artist artist : AllSpotifyArtistList.getInstance().getList()) {
            if (artist.getStageName().equals(stageName)) {
                return true;
            }
        }
        return false;
    }
}
