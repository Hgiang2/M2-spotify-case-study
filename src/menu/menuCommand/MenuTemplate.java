package menu.menuCommand;

import constant.Constants;

import java.util.ArrayList;
import java.util.List;

public class MenuTemplate implements Menu {
    private List<MenuItem> menuItems = new ArrayList<>();
    private String title;
    private String description;
//    private List<?> list = new ArrayList<>();

    public MenuTemplate(String title, String description) {
        this.title = title;
        this.description = description;
    }

////    public MenuTemplate(String title, String description, List<?> list) {
////        this.title = title;
////        this.description = description;
////        this.list = list;
//
//    }

//    private void addList(List<?> list) {
//        try {
//            if (list instanceof List<Song>)
//                for (int i = 0; i < list.size(); i++) {
//                    this.menuItems.add(new MenuItem(list.get(i).toString(), new CommandStreamSong(list.get(i))))
//                }
//        } catch (NullPointerException e) {
//            System.out.println("List is empty!");
//        }
//    }

    @Override
    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    @Override
    public void display() {
        System.out.println();
        System.out.println(description);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(i + ". " + menuItems.get(i).getName());
//        }

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
            System.out.print("Invalid choice, please enter again: ");
            choice = Constants.SCANNER.nextInt();
        }
        menuItems.get(choice).getCommand().execute();
    }

    public String getTitle() {
        return title;
    }

//    public void setList(List<?> list) {
//        this.list = list;
//    }
}
