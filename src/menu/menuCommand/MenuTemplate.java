package menu.menuCommand;

import constant.Constants;

import java.util.ArrayList;
import java.util.List;

public class MenuTemplate implements Menu {
    private List<MenuItem> menuItems;
    private String title;
    private String description;

    public MenuTemplate(String title, String description) {
        this.menuItems = new ArrayList<>();
        this.title = title;
        this.description = description;
    }

    @Override
    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    @Override
    public void display() {
        System.out.println(description);
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + ". " + menuItems.get(i).getName());
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
        while (choice < 0 && choice > menuItems.size()) {
            System.out.println("Invalid choice, please enter again: ");
            choice = Constants.SCANNER.nextInt();
        }
        menuItems.get(choice).getCommand().execute();
    }

    public String getTitle() {
        return title;
    }
}
