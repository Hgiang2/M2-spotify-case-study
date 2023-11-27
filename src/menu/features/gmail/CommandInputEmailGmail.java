package menu.features.gmail;

import constant.Constants;
import menu.features.registerArtist.HandlerString;
import menu.features.userCommand.signInCommand.CommandInputUsername;
import menu.features.Command;
import menu.features.CommandInput;

public class CommandInputEmailGmail implements Command {
    @Override
    public void execute() {
        HandlerString handlerNavigate = new HandlerNavigateGmail(null);
        HandlerString handlerSetEmail = new HandlerSetCurrentEmail(handlerNavigate);
        HandlerString handlerRightEmail = new HandlerCheckRightEmail(handlerSetEmail);

        CommandInput input = new CommandInputUsername(Constants.BLANK);
        input.execute();

        handlerRightEmail.handle(input.getInput());
    }
}
