package menu.service.userCommand.signInCommand.chainOfResponsibility;

import menu.menuCommand.Command;
import menu.service.userCommand.HandlerUser;
import menu.service.userCommand.RequestUser;
import services.validator.ValidateUserExisted;
import services.validator.Validator;
import menu.service.userCommand.signInCommand.CommandSignInProcess;

public class HandlerSignInUsernameExisted implements HandlerUser {
    private HandlerUser next;

    public HandlerSignInUsernameExisted(HandlerUser next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestUser requestUser) {
        String username = requestUser.getUsername();
        Validator validateUsernameExisted = new ValidateUserExisted(username);
        return !validateUsernameExisted.isCheck();
    }

    @Override
    public void handle(RequestUser requestUser) {
        if(!doHandle(requestUser)){
            System.out.println("Username already existed!");
            Command reEnterUsername = new CommandSignInProcess();
            reEnterUsername.execute();
        }
        if(next != null) {
            next.handle(requestUser);
        }
    }
}
