package menu.template;

import java.util.ArrayList;
import java.util.List;

public class MenuInputTemplate implements Menu {
    private List<MenuItem> menuItems;
    private String title;
    private String description;

    public MenuInputTemplate(String title, String description) {
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
        System.out.println();
        System.out.println(description);
        for (MenuItem menuItem : menuItems) {
            System.out.print(menuItem.getName());
            menuItem.getCommand().execute();
            System.out.println();
        }
    }

    @Override
    public void runMenu() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.display();
    }


    @Override
    public void runCommand(int choice) {
    }
}
