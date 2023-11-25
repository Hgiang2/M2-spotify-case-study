package menu.features.userCommand.logInCommand.chainOfResponsibility;

import constant.Constants;
import menu.features.userCommand.HandlerUser;
import menu.features.userCommand.RequestUser;
import menu.features.userCommand.logInCommand.CommandLogInProcess;
import menu.features.userCommand.signInCommand.CommandInputUsername;
import menu.template.CommandInput;
import menu.template.NavigateWrongAttempts;
import menu.template.Navigator;
import services.validator.ValidateUserExisted;
import services.validator.Validator;

public class HandlerLogInUsernameExisted implements HandlerUser {
    private static int wrongUsernameCount = 0;
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
//        if(!doHandle(requestUser)){
//            System.out.println("Username not found!");
//            Command reEnterUsername = new CommandLogInProcess();
//            reEnterUsername.execute();
//        }
        while (!doHandle(requestUser)) {
            wrongUsernameCount++;
            System.out.println("Username not found!");
            CommandInput reEnterUsername = new CommandInputUsername("Enter another username: ");
            reEnterUsername.execute();
            requestUser.setUsername(reEnterUsername.getInput());

            if (wrongUsernameCount == Constants.MAX_WRONG_ATTEMPT) {
                System.out.println("You've entered incorrect username more than " + wrongUsernameCount + " times.");
                wrongUsernameCount = 0;
                Navigator navigateWrongAttempts = new NavigateWrongAttempts(new CommandLogInProcess());
                navigateWrongAttempts.navigate();
            }
            this.doHandle(requestUser);
        }
        if(next != null) {
            next.handle(requestUser);
        }
    }
}
