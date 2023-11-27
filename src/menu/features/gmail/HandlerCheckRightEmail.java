package menu.features.gmail;

import menu.features.registerArtist.HandlerString;
import services.validator.ValidateEmailExisted;
import services.validator.ValidateEmailFormat;
import services.validator.Validator;

public class HandlerCheckRightEmail implements HandlerString {
    private HandlerString next;

    public HandlerCheckRightEmail(HandlerString next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(String stageName) {
        Validator validateFormat = new ValidateEmailFormat(stageName);
        Validator validateExisted = new ValidateEmailExisted(stageName);
        return validateFormat.isCheck() && validateExisted.isCheck();
    }

    @Override
    public void handle(String stageName) {
        if (!doHandle(stageName)) {
            next = new HandlerNavigateWrongEmail(null);
        }
        if (next != null) {
            next.handle(stageName);
        }
    }
}
