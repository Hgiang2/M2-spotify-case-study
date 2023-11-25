package menu.features.registerArtist;

import menu.template.Command;
import services.validator.ValidateCheckArtistNameExisted;
import services.validator.Validator;

public class HandlerCheckExisted implements HandlerString {
    private HandlerString next;

    public HandlerCheckExisted(HandlerString next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(String stageName) {
        Validator validator = new ValidateCheckArtistNameExisted(stageName);
        return !validator.isCheck();
    }

    @Override
    public void handle(String stageName) {
        while (!doHandle(stageName)) {
            System.out.println("This Artist's name has already exist!");
            Command reInput = new CommandInputStageName();
            reInput.execute();
        }
        if (next != null) {
            next.handle(stageName);
        }
    }
}
