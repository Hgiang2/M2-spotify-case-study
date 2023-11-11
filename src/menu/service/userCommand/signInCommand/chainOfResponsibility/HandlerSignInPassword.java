package menu.service.userCommand.signInCommand.chainOfResponsibility;

import menu.menuCommand.CommandInput;
import menu.service.userCommand.HandlerUser;
import menu.service.userCommand.RequestUser;
import menu.service.userCommand.signInCommand.CommandInputPassword;

public class HandlerSignInPassword implements HandlerUser {
    private HandlerUser next;

    public HandlerSignInPassword(HandlerUser next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestUser requestUser) {
        CommandInput inputPassword = new CommandInputPassword("Enter a new password: ");
        inputPassword.execute();
        requestUser.setPassword(inputPassword.getInput());
        return true;
    }

    @Override
    public void handle(RequestUser requestUser) {
       if(!doHandle(requestUser)){
            return;
        }
        if(next != null) {
            next.handle(requestUser);
        }
    }
}
