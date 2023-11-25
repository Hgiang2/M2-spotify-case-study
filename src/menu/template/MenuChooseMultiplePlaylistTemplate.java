package menu.template;

import entity.Playlist;
import services.AllPlaylistsListManagement;

import java.util.ArrayList;
import java.util.List;

public class MenuChooseMultiplePlaylistTemplate implements Menu{
    private List<MenuItem> menuItems;
    private String title;
    private String description;
    private List<Playlist> playlists;

    public MenuChooseMultiplePlaylistTemplate(String description) {
        this.menuItems = new ArrayList<>();
        this.title = "Choose Multiple Playlists";
        this.description = description;
        this.playlists = AllPlaylistsListManagement.getInstance().getAllPlaylists();
    }

    @Override
    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    @Override
    public void display() {
        System.out.println();
        System.out.println(description);
        for (int i = 1; i < playlists.size(); i++) {
            System.out.println(i + ". " + playlists.get(i).toString());
        }
        System.out.println();
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.print(menuItems.get(i).getName());
            menuItems.get(i).getCommand().execute();
            System.out.println();
        }
    }


    @Override
    public void runMenu() {
        this.display();
//        int choice = Constants.SCANNER.nextInt();
//        this.runCommand(choice);
    }


    @Override
    public void runCommand(int choice) {
    }
}
