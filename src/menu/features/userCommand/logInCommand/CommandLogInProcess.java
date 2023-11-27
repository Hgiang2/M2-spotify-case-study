package menu.features.userCommand.logInCommand;

import constant.Constants;
import menu.features.userCommand.signInCommand.chainOfResponsibility.HandlerNavigateMain;
import menu.features.Command;
import menu.features.CommandInput;
import menu.features.userCommand.HandlerUser;
import menu.features.userCommand.logInCommand.chainOfResponsibility.HandlerCheckLogInPassword;
import menu.features.userCommand.logInCommand.chainOfResponsibility.HandlerLogInPassword;
import menu.features.userCommand.logInCommand.chainOfResponsibility.HandlerLogInUsernameExisted;
import menu.features.userCommand.logInCommand.chainOfResponsibility.HandlerSaveUser;
import menu.features.userCommand.signInCommand.CommandInputUsername;
import menu.features.userCommand.signInCommand.RequestNewLogIn;

public class CommandLogInProcess implements Command {
    @Override
    public void execute() {
        HandlerUser handlerNavigateMain = new HandlerNavigateMain(null);
        HandlerUser handlerSaveUser = new HandlerSaveUser(handlerNavigateMain);
        HandlerUser handlerCheckLogInPassword = new HandlerCheckLogInPassword(handlerSaveUser);
        HandlerUser handlerLoginPassword = new HandlerLogInPassword(handlerCheckLogInPassword);
        HandlerUser handlerCheckUsernameExisted = new HandlerLogInUsernameExisted(handlerLoginPassword);

        CommandInput inputUsername = new CommandInputUsername("Enter your username: ");
        inputUsername.execute();
        String loginUsername = inputUsername.getInput();
        handlerCheckUsernameExisted.handle(new RequestNewLogIn(loginUsername, Constants.BLANK));
    }
}
