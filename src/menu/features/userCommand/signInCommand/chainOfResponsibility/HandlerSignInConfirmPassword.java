package menu.features.userCommand.signInCommand.chainOfResponsibility;

import constant.Constants;
import menu.features.CommandInput;
import menu.template.NavigateWrongAttempts;
import menu.template.Navigator;
import menu.features.userCommand.HandlerUser;
import menu.features.userCommand.RequestUser;
import menu.features.userCommand.signInCommand.CommandReEnterPassword;
import menu.features.userCommand.signInCommand.CommandSignInProcess;

public class HandlerSignInConfirmPassword implements HandlerUser {
    private static int confirmPasswordCount = 0;
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
        return false;
    }

    @Override
    public void handle(RequestUser requestUser) {
        while (!doHandle(requestUser)) {
            confirmPasswordCount++;
            System.out.println("Password not matched!");

            if (confirmPasswordCount == Constants.MAX_WRONG_ATTEMPT) {
                System.out.println("You've entered mismatched password more than " + confirmPasswordCount + " times.");
                confirmPasswordCount = 0;
                Navigator navigateWrongAttempts = new NavigateWrongAttempts(new CommandSignInProcess());
                navigateWrongAttempts.navigate();
            }
            this.doHandle(requestUser);
        }
        if (next != null) {
            next.handle(requestUser);
        }
    }
}
