package menu.features.gmail;

import menu.features.registerArtist.CommandInputEmail;
import menu.features.registerArtist.HandlerString;
import menu.template.Command;
import services.validator.ValidateEmailFormat;
import services.validator.Validator;

public class HandlerCheckFormat implements HandlerString {
    private HandlerString next;

    public HandlerCheckFormat(HandlerString next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(String stageName) {
        Validator validator = new ValidateEmailFormat(stageName);
        return validator.isCheck();
    }

    @Override
    public void handle(String stageName) {
        if (!doHandle(stageName)) {
            System.out.println("Wrong email format!");
            Command reInput = new CommandInputEmailGmail();
            reInput.execute();
        }
        if (next != null) {
            next.handle(stageName);
        }
    }
}
