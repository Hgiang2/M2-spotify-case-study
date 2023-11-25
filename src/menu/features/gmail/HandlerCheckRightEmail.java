package menu.features.gmail;

import entity.Email;
import menu.features.registerArtist.HandlerString;
import menu.template.Command;

public class HandlerCheckRightEmail implements HandlerString {
    private HandlerString next;

    public HandlerCheckRightEmail(HandlerString next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(String stageName) {
        return Email.getInstance().getEmail().equals(stageName);
    }

    @Override
    public void handle(String stageName) {
        if (!doHandle(stageName)) {
            System.out.println("No such email existed!");
            Command reInput = new CommandInputEmailGmail();
            reInput.execute();
        }
        if (next != null) {
            next.handle(stageName);
        }
    }
}
