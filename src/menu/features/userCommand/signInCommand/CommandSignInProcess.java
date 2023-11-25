package menu.features.userCommand.signInCommand;

import constant.Constants;
import menu.template.Command;
import menu.template.CommandInput;
import menu.features.userCommand.HandlerUser;
import menu.features.userCommand.signInCommand.chainOfResponsibility.HandlerCreateNewUser;
import menu.features.userCommand.signInCommand.chainOfResponsibility.HandlerNavigateStart;
import menu.features.userCommand.signInCommand.chainOfResponsibility.HandlerPasswordValidFormat;
import menu.features.userCommand.signInCommand.chainOfResponsibility.HandlerSignInConfirmPassword;
import menu.features.userCommand.signInCommand.chainOfResponsibility.HandlerSignInPassword;
import menu.features.userCommand.signInCommand.chainOfResponsibility.HandlerSignInUsernameExisted;
import menu.features.userCommand.signInCommand.chainOfResponsibility.HandlerUsernameValidFormat;

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
//        HandlerUser handlerSaveNewUser = new HandlerSaveNewUser(handlerNavigateMain);
        HandlerUser handlerCreateNewUser = new HandlerCreateNewUser(handlerNavigateStart);
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
