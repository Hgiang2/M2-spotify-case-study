package menu.features.userCommand.logInCommand.chainOfResponsibility;

import constant.Constants;
import menu.template.CommandInput;
import services.validator.Validator;
import services.validator.ValidateUserCorrectPassword;
import menu.features.userCommand.HandlerUser;
import menu.features.userCommand.RequestUser;
import menu.features.userCommand.signInCommand.CommandInputPassword;

public class HandlerCheckLogInPassword implements HandlerUser {
    private HandlerUser next;
    private static int wrongPasswordCount = 0;

    public HandlerCheckLogInPassword(HandlerUser next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestUser requestUser) {
        String password = requestUser.getPassword();
        String username = requestUser.getUsername();
        Validator validatePassword = new ValidateUserCorrectPassword(username, password);
        return validatePassword.isCheck();
    }

    @Override
    public void handle(RequestUser requestUser) {
        while (!doHandle(requestUser)) {
            wrongPasswordCount++;
            System.out.println("Incorrect Password " + wrongPasswordCount + " times");
            CommandInput inputPassword = new CommandInputPassword("Re-enter your password: ");
            inputPassword.execute();
            requestUser.setPassword(inputPassword.getInput());

            if (wrongPasswordCount == Constants.MAX_WRONG_ATTEMPT) {
                System.out.println("You've entered incorrect password more than " + wrongPasswordCount + " times.");
                System.out.println();
                System.out.println("Waiting time: 5 seconds");
                System.out.println();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Exit to Start.......");
                wrongPasswordCount = 0;
                Constants.BACK_TO_START.execute();
            }
            this.doHandle(requestUser);
        }
        if (next != null) {
            wrongPasswordCount = 0;
            next.handle(requestUser);
        }
    }
}
