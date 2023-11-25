package entity;

import java.util.List;

public class Song {
    private String name;
    private Artist artist;
    private List<String> genre;
    private long time;
//    private String date;
//    private boolean isStream;
    private String musicPath;

//    public Song(String name, String artist, String musicPath) {
//        this.name = name;
//        this.artist = new Artist(artist);
//        this.time = System.currentTimeMillis();
//        this.date = Constants.FORMAT_DATE.formatDate();
//        this.isStream = false;
//        services.AllSongsList.getInstance().getAllSongs().add(this);
//    }

    public Song(String name, String artist, String genre, String musicPath) {
        this.name = name;
        this.artist = new Artist(artist);
        // add genre input regex
        this.genre = List.of(genre.split(", "));
        this.time = System.currentTimeMillis();
        this.musicPath = musicPath;
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<String> getGenre() {
        return this.genre;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getMusicPath() {
        return musicPath;
    }

    @Override
    public String toString() {
        return name + " - " + artist + " " + genre;
    }
}
