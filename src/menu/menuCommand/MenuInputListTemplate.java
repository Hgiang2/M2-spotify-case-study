package menu.menuCommand;

import constant.Constants;
import services.AllSongListManagement;

import java.util.ArrayList;
import java.util.List;

public class MenuInputListTemplate implements Menu {
    private List<MenuItem> menuItems;
    private String title;
    private String description;
    private AllSongListManagement listManagement;

    public MenuInputListTemplate(AllSongListManagement listManagement) {
        this.menuItems = new ArrayList<>();
        this.title = listManagement.getTitle();
        this.description = listManagement.getTitle();
        this.listManagement = listManagement;
    }

    @Override
    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    @Override
    public void display() {
        System.out.println();
        System.out.println(description);
        for (int i = 0; i < listManagement.getSongs().size(); i++) {
            System.out.println(i + ". " + listManagement.getSongs().get(i).toString());
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
        int choice = Constants.SCANNER.nextInt();
        this.runCommand(choice);
    }


    @Override
    public void runCommand(int choice) {
        while (choice < 0 && choice > menuItems.size() + listManagement.getSongs().size()) {
            System.out.print("Invalid choice, please enter again: ");
            choice = Constants.SCANNER.nextInt();
        }
        menuItems.get(choice).getCommand().execute();
    }
}
