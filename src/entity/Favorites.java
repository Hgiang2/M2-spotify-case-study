package entity;

public class Favorites extends Playlist{
    private static Playlist instance;
    public static Playlist getInstance() {
        if (instance == null) {
            instance = new Favorites();
        }
        return instance;
    }

    private Favorites() {
        super("Favorites");
    }


}
