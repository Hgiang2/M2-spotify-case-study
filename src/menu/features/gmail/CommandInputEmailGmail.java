package menu.features.gmail;

import constant.Constants;
import menu.features.registerArtist.HandlerCheckEmail;
import menu.features.registerArtist.HandlerNavigateArtistRegisterReturn;
import menu.features.registerArtist.HandlerSetEmail;
import menu.features.registerArtist.HandlerString;
import menu.features.userCommand.signInCommand.CommandInputUsername;
import menu.template.Command;
import menu.template.CommandInput;

public class CommandInputEmailGmail implements Command {
    @Override
    public void execute() {
        HandlerString handlerNavigate = new HandlerNavigateGmail(null);
        HandlerString handlerRightEmail = new HandlerCheckRightEmail(handlerNavigate);
        HandlerString handlerCheckEmail = new HandlerCheckFormat(handlerRightEmail);

        CommandInput input = new CommandInputUsername(Constants.BLANK);
        input.execute();

        handlerCheckEmail.handle(input.getInput());
    }
}
