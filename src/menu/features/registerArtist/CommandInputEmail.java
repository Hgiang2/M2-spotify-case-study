package menu.features.registerArtist;

import constant.Constants;
import menu.features.userCommand.signInCommand.CommandInputUsername;
import menu.template.*;

public class CommandInputEmail implements Command {
    @Override
    public void execute() {
        HandlerString handlerNavigate = new HandlerNavigateArtistRegisterReturn(null);
        HandlerString handlerSetEmail = new HandlerSetEmail(handlerNavigate);
        HandlerString handlerCheckEmail = new HandlerCheckEmail(handlerSetEmail);

        CommandInput input = new CommandInputUsername(Constants.BLANK);
        input.execute();

        handlerCheckEmail.handle(input.getInput());
    }
}
