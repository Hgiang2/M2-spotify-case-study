package menu.template;

import entity.Request;
import menu.features.registerArtist.CommandInputEmail;

public class NavigateArtistRegisterDone implements Navigator{
    private Request request;

    public NavigateArtistRegisterDone(Request request) {
        this.request = request;
    }

    private void displayDoneMenu() {
        System.out.println();
        System.out.println("Uploading your Artist credentials......");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println("Uploading completed!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        Menu menu = new MenuInputTemplate("Register Artist Done!", "Your register request has been sent and waited to be approved!");
        menu.addMenuItem(new MenuItem("Enter your email address to receive notifications: ", new CommandInputEmail(request)));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        displayDoneMenu();
    }
}
