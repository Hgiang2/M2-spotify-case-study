package menu.features.userCommand.signInCommand.chainOfResponsibility;

import constant.Constants;
import menu.template.CommandInput;
import menu.template.NavigateWrongAttempts;
import menu.template.Navigator;
import menu.features.userCommand.HandlerUser;
import menu.features.userCommand.RequestUser;
import menu.features.userCommand.signInCommand.CommandInputUsername;
import services.validator.ValidateUsernameFormat;
import services.validator.Validator;
import menu.features.userCommand.signInCommand.CommandSignInProcess;

public class HandlerUsernameValidFormat implements HandlerUser {
    private static int invalidUsername = 0;
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
        while (!doHandle(requestUser)) {
            invalidUsername++;
            System.out.println("Username must be less than 26 characters & not contain any special characters!");
            CommandInput reEnterUsername = new CommandInputUsername("Re-enter another username: ");
            reEnterUsername.execute();
            requestUser.setUsername(reEnterUsername.getInput());
            if (invalidUsername == Constants.MAX_WRONG_ATTEMPT) {
                System.out.println("You've set invalid username more than " + invalidUsername + " times.");
                invalidUsername = 0;
                Navigator navigateWrongAttempts = new NavigateWrongAttempts(new CommandSignInProcess());
                navigateWrongAttempts.navigate();
            }
            this.doHandle(requestUser);
        }
        if(next != null) {
            next.handle(requestUser);
        }
    }
}
