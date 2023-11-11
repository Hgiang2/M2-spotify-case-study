package menu.service.userCommand.signInCommand.chainOfResponsibility;

import menu.menuCommand.CommandInput;
import menu.service.userCommand.HandlerUser;
import menu.service.userCommand.RequestUser;
import menu.service.userCommand.signInCommand.CommandReEnterPassword;

public class HandlerSignInConfirmPassword implements HandlerUser {
    private HandlerUser next;

    public HandlerSignInConfirmPassword(HandlerUser next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestUser requestUser) {
        CommandInput inputPasswordConfirm = new CommandReEnterPassword("Re-enter your password: ");
        inputPasswordConfirm.execute();
        String passwordConfirm = inputPasswordConfirm.getInput();
        if (passwordConfirm.equals(requestUser.getPassword())) {
            return true;
        }
        System.out.println("Password not matched!");
        return false;
    }

    @Override
    public void handle(RequestUser requestUser) {
        boolean isSamePassword = doHandle(requestUser);
        while (!isSamePassword) {
                isSamePassword = this.doHandle(requestUser);
        }
        if (next != null) {
            next.handle(requestUser);
        }
    }
}
