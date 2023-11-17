package menu.menuCommand;

public class NavigateGenreSelected implements Navigator{
    private String genre;
    private Navigator navigateBack;

    public NavigateGenreSelected(String genre, Navigator navigateBack) {
        this.genre = genre;
        this.navigateBack = navigateBack;
    }

    private void DisplayGenreList() {
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
    }
    @Override
    public void navigate() {
        DisplayGenreList();
    }
}
