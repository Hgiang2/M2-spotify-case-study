package entity;

public interface MusicList {
    void displayList();
    void sortAZ();
    void sortZA();
    void sortByOldest();
    void sortByNewest();
    void select(int choice);
    void removeMultiple(String choices);
}
