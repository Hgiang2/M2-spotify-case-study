package menu.service.userCommand.logInCommand;

import constant.Constants;
import menu.menuCommand.Command;
import menu.menuCommand.CommandInput;
import menu.service.userCommand.HandlerUser;
import menu.service.userCommand.logInCommand.chainOfResponsibility.HandlerCheckLogInPassword;
import menu.service.userCommand.logInCommand.chainOfResponsibility.HandlerLogInPassword;
import menu.service.userCommand.logInCommand.chainOfResponsibility.HandlerLogInUsernameExisted;
import menu.service.userCommand.logInCommand.chainOfResponsibility.HandlerSaveUser;
import menu.service.userCommand.signInCommand.CommandInputUsername;
import menu.service.userCommand.signInCommand.RequestNewLogIn;
import menu.service.userCommand.signInCommand.chainOfResponsibility.HandlerNavigateMain;

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
