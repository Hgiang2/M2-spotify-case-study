package menu.features.selectRequest;

import entity.Request;
import menu.template.Command;
import menu.template.NavigateSelectRequest;
import menu.template.Navigator;

public class CommandSelectRequest implements Command {
    private Request request;

    public CommandSelectRequest(Request request) {
        this.request = request;
    }

    @Override
    public void execute() {
        Navigator navigator = new NavigateSelectRequest(request);
        navigator.navigate();
    }
}
