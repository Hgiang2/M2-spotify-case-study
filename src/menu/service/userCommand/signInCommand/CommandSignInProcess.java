package menu.service.userCommand.signInCommand;

import constant.Constants;
import menu.menuCommand.Command;
import menu.menuCommand.CommandInput;
import menu.service.userCommand.HandlerUser;
import menu.service.userCommand.signInCommand.chainOfResponsibility.HandlerCreateNewUser;
import menu.service.userCommand.signInCommand.chainOfResponsibility.HandlerNavigateMain;
import menu.service.userCommand.signInCommand.chainOfResponsibility.HandlerPasswordValidFormat;
import menu.service.userCommand.signInCommand.chainOfResponsibility.HandlerSaveNewUser;
import menu.service.userCommand.signInCommand.chainOfResponsibility.HandlerSignInConfirmPassword;
import menu.service.userCommand.signInCommand.chainOfResponsibility.HandlerSignInPassword;
import menu.service.userCommand.signInCommand.chainOfResponsibility.HandlerSignInUsernameExisted;
import menu.service.userCommand.signInCommand.chainOfResponsibility.HandlerUsernameValidFormat;

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
        HandlerUser handlerNavigateMain = new HandlerNavigateMain(null);
        HandlerUser handlerSaveNewUser = new HandlerSaveNewUser(handlerNavigateMain);
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
