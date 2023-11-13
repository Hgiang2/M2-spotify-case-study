package menu.service.mainMenuCommand.searchNewMusic;

import entity.AllSpotifySongList;
import entity.Song;
import menu.menuCommand.Command;
import menu.menuCommand.CommandInput;

import java.util.List;

public class CommandSearchNewMusicProcess implements Command {
//    List<Song> songResult;
//    List<Artist> artistResult;
//    List<String> searchResult;
//
//    public CommandSearchNewMusicProcess() {
//        this.songResult = new ArrayList<>();
//        this.artistResult = new ArrayList<>();
//        this.searchResult = new ArrayList<>();
//    }

    @Override
    public void execute() {
        CommandInput inputSearchItem = new CommandInputSearchItem("Search for a title or an artist: ");
        inputSearchItem.execute();
        String searchItem = inputSearchItem.getInput();

        SearchResult searchResult = new SearchResult(searchItem);
//        checkSearchItem(searchItem);
//        List<String> searchResult = artistResult.addAll();
//        DisplayList.getInstance().displayList(searchResult);


    }

    private void checkSearchItem(String searchItem) {
        List<Song> allSpotifySongs = AllSpotifySongList.getInstance().getSpotifySongs();
        for (Song song : allSpotifySongs) {
            if (checkSongName(song, searchItem)) songResult.add(song);
            if (checkArtistName(song, searchItem)) artistResult.add(song.getArtist());
        }
        if (songResult.isEmpty() && artistResult.isEmpty()) System.out.println("Not found!");
    }

    private boolean checkSongName(Song song, String searchItem) {
        return song.getName().toLowerCase().contains(searchItem.toLowerCase());
    }

    private boolean checkArtistName(Song song, String searchItem) {
        return song.getArtist().getName().toLowerCase().contains(searchItem.toLowerCase());
    }

    private void displaySearchResult() {

    }
}
