package menu.service.userCommand.logInCommand.chainOfResponsibility;

import menu.menuCommand.Command;
import menu.service.userCommand.HandlerUser;
import menu.service.userCommand.RequestUser;
import services.validator.Validator;
import services.validator.ValidateUserExisted;
import menu.service.userCommand.logInCommand.CommandLogInProcess;

public class HandlerLogInUsernameExisted implements HandlerUser {
    private HandlerUser next;

    public HandlerLogInUsernameExisted(HandlerUser next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestUser requestUser) {
        String username = requestUser.getUsername();
        Validator validateUsername = new ValidateUserExisted(username);
        return validateUsername.isCheck();
    }

    @Override
    public void handle(RequestUser requestUser) {
        if(!doHandle(requestUser)){
            System.out.println("Username not found!");
            Command reEnterUsername = new CommandLogInProcess();
            reEnterUsername.execute();
        }
        if(next != null) {
            next.handle(requestUser);
        }
    }
}
