package menu.features.userCommand.signInCommand.chainOfResponsibility;

import constant.Constants;
import menu.template.Command;
import menu.template.NavigateWrongAttempts;
import menu.template.Navigator;
import menu.features.userCommand.HandlerUser;
import menu.features.userCommand.RequestUser;
import services.validator.ValidateUserExisted;
import services.validator.Validator;
import menu.features.userCommand.signInCommand.CommandSignInProcess;

public class HandlerSignInUsernameExisted implements HandlerUser {
    private static int existedUsernameCount = 0;
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
        while (!doHandle(requestUser)) {
            existedUsernameCount++;
            System.out.println("Username existed");
            Command reEnterUsername = new CommandSignInProcess();
            reEnterUsername.execute();
            if (existedUsernameCount == Constants.MAX_WRONG_ATTEMPT) {
                System.out.println("You've trouble setting up username too many times.");
                existedUsernameCount = 0;
                Navigator navigateWrongAttempts = new NavigateWrongAttempts(new CommandSignInProcess());
                navigateWrongAttempts.navigate();
            }
//            this.doHandle(requestUser);
        }
        if(next != null) {
            next.handle(requestUser);
        }
    }
}
