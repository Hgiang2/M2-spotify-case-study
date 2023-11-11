package entity;

import java.util.List;

public class Genre {
    private List<String> genres;

    public Genre(String string) {
        this.genres = List.of(string.split(", "));;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(String string) {
        this.genres = List.of(string.split(", "));
    }

//    @Override
//    public String toString() {
//        return "Genre{" +
//                "genres=" + genres +
//                '}';
//    }
}
