package menu.menuCommand;

public interface Menu {
//    void addDescription(MenuDescription description);
    void addMenuItem(MenuItem menuItem);
    void display();
    void runCommand(int choice);
    void runMenu();
}
