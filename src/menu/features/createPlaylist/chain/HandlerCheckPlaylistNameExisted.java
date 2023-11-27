package menu.features.createPlaylist.chain;

import entity.Playlist;
import menu.features.CommandInput;
import menu.features.createPlaylist.CommandInputPlaylistName;
import menu.features.createPlaylist.HandlePlaylist;
import services.AllPlaylistsListManagement;

public class HandlerCheckPlaylistNameExisted implements HandlePlaylist {
    private HandlePlaylist next;

    public HandlerCheckPlaylistNameExisted(HandlePlaylist next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(Playlist playlist) {
        for (Playlist playlists : AllPlaylistsListManagement.getInstance().getAllPlaylists()) {
            if (playlist.getName().equals(playlists.getName())) return false;
        }
        return true;
    }

    @Override
    public void handle(Playlist playlist) {
        while (!doHandle(playlist)) {
            System.out.println("This playlist name has already exist!");
            CommandInput nameReEnter = new CommandInputPlaylistName("Please enter another name: ");
            nameReEnter.execute();
            playlist.setName(nameReEnter.getInput());
        }
        if (next != null) {
            next.handle(playlist);
        }
    }
}
