package menu.template;

import services.validator.ValidateChoiceFormat;
import services.validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuTabTemplate implements Menu{
    private final Scanner SCANNER = new Scanner(System.in);
    private List<MenuItem> menuItems = new ArrayList<>();
    private String title;
    private String description;

//    private List<?> list = new ArrayList<>();

    public MenuTabTemplate(String title, String description) {
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
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.print("[" + (i + 1) + "] " + menuItems.get(i).getName() + "\t");
        }
    }

    @Override
    public void runMenu() {
        this.display();
        String choice = getChoice();
        this.runCommand(Integer.parseInt(choice) - 1);
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
        }
        menuItems.get(choice).getCommand().execute();
    }

    public String getTitle() {
        return title;
    }
}
