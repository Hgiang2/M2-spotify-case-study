package menu.features.registerArtist;

import menu.features.userCommand.signInCommand.CommandInputUsername;
import menu.template.Command;
import menu.template.CommandInput;

public class CommandInputStageName implements Command {
    @Override
    public void execute() {
        HandlerString handleNavigateConfirmStageName = new HandlerNavigateConfirmStageName(null);
        HandlerString handleCheckExist = new HandlerCheckExisted(handleNavigateConfirmStageName);

        CommandInput input = new CommandInputUsername("Enter your stage name: ");
        input.execute();
        handleCheckExist.handle(input.getInput());
    }
}
