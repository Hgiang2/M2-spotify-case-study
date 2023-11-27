package menu.features.userCommand.signInCommand.chainOfResponsibility;

import constant.Constants;
import menu.features.CommandInput;
import menu.template.NavigateWrongAttempts;
import menu.template.Navigator;
import menu.features.userCommand.HandlerUser;
import menu.features.userCommand.RequestUser;
import menu.features.userCommand.signInCommand.CommandSignInProcess;
import services.validator.ValidatePasswordFormat;
import services.validator.Validator;
import menu.features.userCommand.signInCommand.CommandInputPassword;

public class HandlerPasswordValidFormat implements HandlerUser {
    private static int invalidPasswordCount = 0;
    private HandlerUser next;

    public HandlerPasswordValidFormat(HandlerUser next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestUser requestUser) {
        String password = requestUser.getPassword();
        Validator validatePasswordFormat = new ValidatePasswordFormat(password);
        return validatePasswordFormat.isCheck();
    }

    @Override
    public void handle(RequestUser requestUser) {
        while (!doHandle(requestUser)) {
            invalidPasswordCount++;
            System.out.println("Password must be at least 8 characters & have at least 1 UPPERCASE, 1 lowercase and 1 special character.");
            CommandInput reEnterPassword = new CommandInputPassword("Please choose another password: ");
            reEnterPassword.execute();
            requestUser.setPassword(reEnterPassword.getInput());

            if (invalidPasswordCount == Constants.MAX_WRONG_ATTEMPT) {
                System.out.println("You've set invalid password more than " + invalidPasswordCount + " times.");
                invalidPasswordCount = 0;
                Navigator navigateWrongAttempts = new NavigateWrongAttempts(new CommandSignInProcess());
                navigateWrongAttempts.navigate();
            }
            this.doHandle(requestUser);
        }
        if (next != null) {
            next.handle(requestUser);
        }
    }

//    private boolean checkPasswordFormat(RequestUser requestUser) {
//        String password = requestUser.getPassword();
//        return Pattern.compile(regex).matcher(password).find() && password.length() >= 8;
//    }
}
