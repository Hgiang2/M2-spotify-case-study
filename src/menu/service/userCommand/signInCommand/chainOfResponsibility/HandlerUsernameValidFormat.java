package menu.service.userCommand.signInCommand.chainOfResponsibility;

import menu.menuCommand.Command;
import menu.service.userCommand.HandlerUser;
import menu.service.userCommand.RequestUser;
import services.validator.ValidateUsernameFormat;
import services.validator.Validator;
import menu.service.userCommand.signInCommand.CommandSignInProcess;

public class HandlerUsernameValidFormat implements HandlerUser {
    private HandlerUser next;

    public HandlerUsernameValidFormat(HandlerUser next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestUser requestUser) {
        String username = requestUser.getUsername();
        Validator validateUsernameFormat = new ValidateUsernameFormat(username);
        return validateUsernameFormat.isCheck();
    }

    @Override
    public void handle(RequestUser requestUser) {
        if(!doHandle(requestUser)){
            System.out.println("Username must be less than 26 characters & not contain any special characters!");
            Command reEnterUsername = new CommandSignInProcess();
            reEnterUsername.execute();
        }
        if(next != null) {
            next.handle(requestUser);
        }
    }
}
