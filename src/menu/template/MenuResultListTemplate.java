package menu.template;

import services.validator.ValidateChoiceFormat;
import services.validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuResultListTemplate implements Menu {
    private final Scanner SCANNER = new Scanner(System.in);
    private List<MenuItem> menuItems = new ArrayList<>();
    private String title;
    private String description;
    private int listSize;
    public MenuResultListTemplate(String title, String description, int listSize) {
        this.title = title;
        this.description = description;
        this.listSize = listSize;
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
}
