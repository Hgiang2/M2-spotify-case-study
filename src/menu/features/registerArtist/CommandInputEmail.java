package menu.features.registerArtist;

import constant.Constants;
import entity.Request;
import menu.features.Command;
import menu.features.CommandInput;
import menu.features.userCommand.signInCommand.CommandInputUsername;

public class CommandInputEmail implements Command {
    private Request request;

    public CommandInputEmail(Request request) {
        this.request = request;
    }

    @Override
    public void execute() {
        HandlerString handlerNavigate = new HandlerNavigateArtistRegisterReturn(null);
        HandlerString handlerSetEmail = new HandlerSetEmail(handlerNavigate, request);
        HandlerString handlerCheckEmail = new HandlerCheckEmail(handlerSetEmail, request);

        CommandInput input = new CommandInputUsername(Constants.BLANK);
        input.execute();

        handlerCheckEmail.handle(input.getInput());
    }
}
