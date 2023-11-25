package menu.template;

import constant.Constants;
import menu.features.addToFavorites.addMultiple.CommandAddMultipleToFavorites;
import menu.features.addToPlaylists.selectSongs.CommandAddMultipleToPlaylists;
import menu.features.exitCommand.CommandBack;
import menu.features.streamCommand.CommandStreamListOrderly;
import menu.features.streamCommand.CommandStreamSong;
import services.AllSongListManagement;
import services.GenreSongListManagement;

public class NavigateSelectGenre implements Navigator{
    private String genre;
    private Navigator navigateBack;

    public NavigateSelectGenre(String genre, Navigator navigateBack) {
        this.genre = genre;
        this.navigateBack = navigateBack;
    }

    private void displayGenreList() {
//        Menu menuGenre = new MenuTemplate(genre, genre + "Playlist: ");
//        System.out.println();
//        DisplaySongList displaySongList = new DisplaySongList(menuGenre, new GenreSongListManagement(genre).getSongs(), this);
//        displaySongList.display();
//        System.out.println();
//        menuGenre.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(navigateBack)));
//        menuGenre.addMenuItem(new MenuItem(Constants.STREAM, new CommandStream(new GenreSongListManagement(genre).getSongs(), this)));
////        menuGenre.addMenuItem(new MenuItem("Add Multiple to Favorites", new CommandAddToFavorites(genre.getSongs())));
////        menuGenre.addMenuItem(new MenuItem("Add Multiple to Playlists", new CommandAddToPlaylists(genre.getSongs())));
////        menuGenre.addMenuItem(new MenuItem("Delete Multiple", new CommandDeleteMultiple(genre.getSongs())));
//        menuGenre.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, Constants.BACK_TO_MAIN));
        AllSongListManagement thisGenreSongs = new GenreSongListManagement(genre);
        Menu menuGenre = new MenuResultListTemplate(genre, genre, thisGenreSongs.getSongs().size());
        for (int i = 0; i < thisGenreSongs.getSongs().size(); i++) menuGenre.addMenuItem(new MenuItem(thisGenreSongs.getSongs().get(i).toString(), new CommandStreamSong(i, thisGenreSongs, this)));
        menuGenre.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(navigateBack)));
        menuGenre.addMenuItem(new MenuItem(Constants.STREAM_LIST, new CommandStreamListOrderly(thisGenreSongs, this)));
        menuGenre.addMenuItem(new MenuItem(Constants.ADD_MULTIPLE_TO_FAVORITES, new CommandAddMultipleToFavorites(thisGenreSongs, this)));
        menuGenre.addMenuItem(new MenuItem(Constants.ADD_MULTIPLE_TO_PLAYLISTS, new CommandAddMultipleToPlaylists(thisGenreSongs, this)));
        menuGenre.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, Constants.BACK_TO_MAIN));
        menuGenre.runMenu();
    }
    @Override
    public void navigate() {
        displayGenreList();
    }
}
