package menu.features.userCommand.signInCommand.chainOfResponsibility;

import entity.NormalUser;
import menu.features.userCommand.HandlerUser;
import menu.features.userCommand.RequestUser;
import entity.ValidUsersList;
import services.observer.Observer;
import services.observer.Subject;

public class HandlerCreateNewUser extends Subject implements HandlerUser {
    private HandlerUser next;

    public HandlerCreateNewUser(HandlerUser next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestUser requestUser) {
        Observer observeValidUsers = ValidUsersList.getInstance();
        addObserver(observeValidUsers);
        ValidUsersList.getInstance().getValidUsers().add(new NormalUser(requestUser.getUsername(), requestUser.getPassword()));
        notifyObserver();
        removeAll();
        System.out.println();
        System.out.println("Processing");
        System.out.println();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Create new account successfully!");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public void handle(RequestUser requestUser) {
        if (!doHandle(requestUser)) {
            return;
        }
        if (next != null) {
            next.handle(requestUser);
        }
    }
}
