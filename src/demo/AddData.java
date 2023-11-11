package demo;

import services.observer.Subject;

public class AddData extends Subject {
    public static void main(String[] args) {
//        List<Song> spotifySongs = SpotifyDatabaseSongList.getInstance().getSpotifySongs();
//        Song songCruelSummer = new Song("Cruel Summer", "Taylor Swift", "Pop");
//        Song songLoveStory = new Song("Love Story", "Taylor Swift", "Pop, Country");
//        Song songMemories = new Song("Memories", "Maroon 5", "Rock, Soft Rock");
//        Song songIKnewYouWereTrouble = new Song("I Knew You Were Trouble", "Taylor Swift", "Pop, EDM, Rock");
//        Song songOneThing = new Song("One Thing", "One Direction", "Pop, Rock");
//        Song songRed = new Song("Red", "Taylor Swift", "Pop, Country, Rock");
//        Song songEnchanted = new Song("Enchanted", "Taylor Swift", "Ballad, Pop, Rock, Country");
//        Song songPayphone = new Song("Payphone", "Maroon 5", "Pop, R&B");
//        Song songOneMoreNight = new Song("OneMoreNight", "Maroon 5", "Pop, Rock");
//        Song songWhatMakesYouBeautiful = new Song("What Makes You Beautiful", "One Direction", "Pop");
//        Song song7Rings = new Song("7 Rings", "Ariana Grande", "Pop");
//        Song songOneLastTime = new Song("One Last Time", "Ariana Grande", "Pop, Country");
//        Song songEveryday = new Song("Everyday", "Ariana Grande", "Pop, EDM, Rock");
//        Song songSantaTellMe = new Song("Santa Tell Me", "Ariana Grande", "Pop, Country, Rock");
//        Song songThankUNext = new Song("Thank U, Next", "Ariana Grande", "Ballad, Pop, Rock, Country");
//        Song songMean = new Song("Mean", "Taylor Swift", "Rock, Soft Rock");
//        Song songFifteen = new Song("Fifteen", "Taylor Swift", "Pop, R&B");
//        Song songLookWhatYouMadeMeDo = new Song("Look What You Made Me Do", "Taylor Swift", "Pop, Rock");
//        Song songAsLongAsYouLoveMe = new Song("As Long As You Love Me", "Backstreet Boys", "Pop, Rock");
//        Song songIWantItThatWay = new Song("I Want It That Way", "Backstreet Boys", "Pop");
//        spotifySongs.add(songCruelSummer);
//        spotifySongs.add(songLoveStory);
//        spotifySongs.add(songMemories);
//        spotifySongs.add(songIKnewYouWereTrouble);
//        spotifySongs.add(songOneThing);
//        spotifySongs.add(songRed);
//        spotifySongs.add(songEnchanted);
//        spotifySongs.add(songPayphone);
//        spotifySongs.add(songOneMoreNight);
//        spotifySongs.add(songWhatMakesYouBeautiful);
//        spotifySongs.add(song7Rings);
//        spotifySongs.add(songOneLastTime);
//        spotifySongs.add(songEveryday);
//        spotifySongs.add(songSantaTellMe);
//        spotifySongs.add(songThankUNext);
//        spotifySongs.add(songMean);
//        spotifySongs.add(songFifteen);
//        spotifySongs.add(songLookWhatYouMadeMeDo);
//        spotifySongs.add(songAsLongAsYouLoveMe);
//        spotifySongs.add(songIWantItThatWay);
//        Constants.fileHandler.saveToFile(Constants.SPOTIFY_SONG_FILE_PATH, spotifySongs);
//        List<Song> allSongs = AllSongsList.getInstance().getAllSongs();
//        Song songCruelSummer = new Song("Cruel Summer", "Taylor Swift", "Pop");
//        Song songLoveStory = new Song("Love Story", "Taylor Swift", "Pop, Country");
//        Song songMemories = new Song("Memories", "Maroon 5", "Rock, Soft Rock");
//        Song songIKnewYouWereTrouble = new Song("I Knew You Were Trouble", "Taylor Swift", "Pop, EDM, Rock");
//        Song songOneThing = new Song("One Thing", "One Direction", "Pop, Rock");
//        Song songRed = new Song("Red", "Taylor Swift", "Pop, Country, Rock");
//        Song songEnchanted = new Song("Enchanted", "Taylor Swift", "Ballad, Pop, Rock, Country");
//        Song songPayphone = new Song("Payphone", "Maroon 5", "Pop, R&B");
//        Song songOneMoreNight = new Song("OneMoreNight", "Maroon 5", "Pop, Rock");
//        Song songWhatMakesYouBeautiful = new Song("What Makes You Beautiful", "One Direction", "Pop");
//        Song song7Rings = new Song("7 Rings", "Ariana Grande", "Pop");
//        Song songOneLastTime = new Song("One Last Time", "Ariana Grande", "Pop, Country");
//        Song songEveryday = new Song("Everyday", "Ariana Grande", "Pop, EDM, Rock");
//        Song songSantaTellMe = new Song("Santa Tell Me", "Ariana Grande", "Pop, Country, Rock");
//        Song songThankUNext = new Song("Thank U, Next", "Ariana Grande", "Ballad, Pop, Rock, Country");
//        Song songMean = new Song("Mean", "Taylor Swift", "Rock, Soft Rock");
//        Song songFifteen = new Song("Fifteen", "Taylor Swift", "Pop, R&B");
//        Song songLookWhatYouMadeMeDo = new Song("Look What You Made Me Do", "Taylor Swift", "Pop, Rock");
//        Song songAsLongAsYouLoveMe = new Song("As Long As You Love Me", "Backstreet Boys", "Pop, Rock");
//        Song songIWantItThatWay = new Song("I Want It That Way", "Backstreet Boys", "Pop");
//
//        Constants.fileHandler.saveToFile(Constants.ALL_SONG_FILE_PATH, allSongs);
//////        Type songType = new TypeToken<List<Song>>() {}.getType();
//////        List<Song> allSongsRead = (ArrayList<Song>) fileHandler.readFromFile(Constants.ALL_SONG_FILE_PATH, songType);
//////        for (Song song : allSongsRead) {
//////            System.out.println(song.toString());
//////        }
//        List<User> validUsers = ValidUsersList.getInstance().getValidUsers();
//        User user1 = new User("Giang", "Giang12345@");
//        User user2 = new User("Dao", "Dao12345@");
//        User user3 = new User("Huy", "Huy12345@");
//        validUsers.add(user1);
//        validUsers.add(user2);
//        validUsers.add(user3);
////        Constants.fileHandler.saveToFile(Constants.VALID_USER_FILE_PATH,validUsers);
//        Type userType = new TypeToken<List<User>>() {}.getType();
//        ValidUsersList.getInstance().update();

//        DisplayList.displayList(allSongs);
//
//        System.out.println();
//        System.out.println("SortAZ");
//        songManagement.sortAZ();
//        DisplayList.displayList(allSongs);
//
//        System.out.println();
//        System.out.println("SortZA");
//        songManagement.sortZA();
//        DisplayList.displayList(allSongs);
//
//        System.out.println();
//        System.out.println("Sort by Oldest");
//        songManagement.sortByOldest();
//        DisplayList.displayList(allSongs);
//
//        System.out.println();
//        System.out.println("Sort by Newest");
//        songManagement.sortByNewest();
//        DisplayList.displayList(allSongs);
    }
}
