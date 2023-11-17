package menu.menuCommand;

import constant.Constants;

import java.util.ArrayList;
import java.util.List;

public class MenuResultListTemplate implements Menu {
    private List<MenuItem> menuItems = new ArrayList<>();
    private String title;
    private String description;
    private int listSize;
//    private Navigator navigateBack;

    public MenuResultListTemplate(String title, String description, int listSize) {
        this.title = title;
        this.description = description;
        this.listSize = listSize;
//        this.navigateBack = navigateBack;
    }

    @Override
    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    @Override
    public void display() {
        System.out.println();
        System.out.println(description);

        for (int i = 0; i < listSize; i++) {
            System.out.println(i + ". " + menuItems.get(i).getName());
        }
        System.out.println("----------------");
        for (int i = listSize; i < menuItems.size(); i++) {
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
            System.out.print("Invalid choice, please enter again: ");
            choice = Constants.SCANNER.nextInt();
        }
        menuItems.get(choice).getCommand().execute();
    }
}
