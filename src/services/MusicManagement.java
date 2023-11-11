package services;

import entity.Song;

public interface MusicManagement {
    void stream();
    void getStatus();
    void displayAll();
    void addSong(Song song);
    void removeMultiple(String numbers);
    void sortAZ();
    void sortZA();
    void sortByOldest();
    void sortByNewest();
}
