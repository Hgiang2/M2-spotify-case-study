package menu.service.userCommand.signInCommand.chainOfResponsibility;

import entity.Song;
import menu.service.userCommand.HandlerUser;
import menu.service.userCommand.RequestUser;
import services.observer.Subject;

import java.util.List;

public class HandlerCreateNewUser extends Subject implements HandlerUser {
    private HandlerUser next;

    public HandlerCreateNewUser(HandlerUser next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestUser requestUser) {
        List<Song> =
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
