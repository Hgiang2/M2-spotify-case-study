package entity;

import constant.Constants;

import java.util.List;

public class Song {
    private String name;
    private Artist artist;
    private Genre genre;
    private long time;
    private String date;
    private boolean isStream;

    public Song(String name, String artist) {
        this.name = name;
        this.artist = new Artist(artist);
        this.genre = new Genre("No genre");
        this.time = System.currentTimeMillis();
        this.date = Constants.FORMAT_DATE.formatDate();
        this.isStream = false;
        AllSongsList.getInstance().getAllSongs().add(this);
    }

    public Song(String name, String artist, String genre) {
        this.name = name;
        this.artist = new Artist(artist);
        this.genre = new Genre(genre);
        this.time = System.currentTimeMillis();
        this.date = Constants.FORMAT_DATE.formatDate();
        this.isStream = false;
        AllSongsList.getInstance().getAllSongs().add(this);
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

    public boolean isStream() {
        return isStream;
    }

    public void setStream(boolean stream) {
        isStream = stream;
    }

    public void setArtist(String artist) {
        this.artist = new Artist(artist);
    }

    public List<String> getGenre() {
        return this.genre.getGenres();
    }

    public void setGenre(String genre) {
        this.genre.setGenres(genre);
    }

    public long getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return name + " - " + artist + " " + genre;
    }
}
