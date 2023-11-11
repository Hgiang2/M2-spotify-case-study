package menu.service.userCommand.signInCommand.chainOfResponsibility;

import entity.User;
import entity.UserFactory;
import services.observer.Observer;
import services.observer.Subject;
import menu.service.userCommand.HandlerUser;
import menu.service.userCommand.RequestUser;
import menu.service.userCommand.ValidUsersList;

import java.util.List;

public class HandlerCreateNewUser extends Subject implements HandlerUser {
    private HandlerUser next;

    public HandlerCreateNewUser(HandlerUser next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestUser requestUser) {
        List<User> users = ValidUsersList.getInstance().getValidUsers();
        UserFactory userFactory = new UserFactory();
        User newUser = userFactory.createNewUser(requestUser.getUsername(), requestUser.getPassword());
        users.add(newUser);
        Observer observer = ValidUsersList.getInstance();
        addObserver(observer);
        notifyObserver();
        removeObserver(observer);
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
