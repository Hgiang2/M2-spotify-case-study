package services;

public interface LocalSongListManagement extends AllSongListManagement {
    void removeMultiple(String choice);
    void sortAZ();
    void sortZA();
    void sortByOldest();
    void sortByNewest();
}
