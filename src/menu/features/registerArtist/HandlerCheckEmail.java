package menu.features.registerArtist;

import menu.template.Command;
import services.validator.ValidateEmailFormat;
import services.validator.Validator;

public class HandlerCheckEmail implements HandlerString {
    private HandlerString next;

    public HandlerCheckEmail(HandlerString next) {
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
            Command reInput = new CommandInputEmail();
            reInput.execute();
        }
        if (next != null) {
            next.handle(stageName);
        }
    }
}
