package menu.template;

import services.validator.ValidateChoiceFormat;
import services.validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuTemplate implements Menu {
    private final Scanner SCANNER = new Scanner(System.in);
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
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.display();
        String choice = getChoice();
        this.runCommand(Integer.parseInt(choice));
    }

    private String getChoice() {
        String choice;
        boolean isCorrectFormat = true;
        do {
            if (!isCorrectFormat) System.out.println("Invalid format! Please enter another choice: ");
            choice = SCANNER.nextLine();
            Validator validateChoice = new ValidateChoiceFormat(choice);
            isCorrectFormat = validateChoice.isCheck();
        } while (!isCorrectFormat);
        return choice;
    }

    private String validateChoice(String choice) {
        Validator validateChoice = new ValidateChoiceFormat(choice);
        while (!validateChoice.isCheck()) {
            System.out.println("Invalid choice! Please enter another: ");
            choice = SCANNER.nextLine();
            validateChoice.isCheck();
        }
        return choice;
    }

    @Override
    public void runCommand(int choice) {
        while (choice < 0 || choice >= menuItems.size()) {
            System.out.print("Invalid choice, please enter again: ");
            Scanner SCANNER = new Scanner(System.in);
            choice = SCANNER.nextInt();
//            SCANNER.close();
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
