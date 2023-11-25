package menu.features.userCommand.signInCommand;

import constant.Constants;
import menu.features.userCommand.signInCommand.chainOfResponsibility.*;
import menu.template.Command;
import menu.template.CommandInput;
import menu.features.userCommand.HandlerUser;

public class CommandSignInProcess implements Command {
//    private String description;
//    private String username;
//
//    public CommandSignInEnterUsername(String description, String input) {
//        this.description = description;
//        this.username = input;
//    }

    @Override
    public void execute() {
        HandlerUser handlerNavigateStart = new HandlerNavigateStart(null);
        HandlerUser handlerSaveNewUser = new HandlerSaveNewUser(handlerNavigateStart);
        HandlerUser handlerCreateNewUser = new HandlerCreateNewUser(handlerSaveNewUser);
        HandlerUser handlerConfirmPassword = new HandlerSignInConfirmPassword(handlerCreateNewUser);
        HandlerUser handlerCheckPasswordFormat = new HandlerPasswordValidFormat(handlerConfirmPassword);
        HandlerUser handlerNewPassword = new HandlerSignInPassword(handlerCheckPasswordFormat);
        HandlerUser handlerCheckUsernameExisted = new HandlerSignInUsernameExisted(handlerNewPassword);
        HandlerUser handlerCheckUsernameFormat = new HandlerUsernameValidFormat(handlerCheckUsernameExisted);


        CommandInput inputUsername = new CommandInputUsername("Enter a new username: ");
        inputUsername.execute();
        String newUsername = inputUsername.getInput();
        handlerCheckUsernameFormat.handle(new RequestNewLogIn(newUsername, Constants.BLANK));
    }
}
