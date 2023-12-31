package menu.features.registerArtist;

import entity.Request;
import menu.features.Command;
import services.validator.ValidateEmailFormat;
import services.validator.Validator;

public class HandlerCheckEmail implements HandlerString {
    private Request request;

    private HandlerString next;

    public HandlerCheckEmail(HandlerString next, Request request) {
        this.next = next;
        this.request = request;
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
            Command reInput = new CommandInputEmail(request);
            reInput.execute();
        }
        if (next != null) {
            next.handle(stageName);
        }
    }
}
