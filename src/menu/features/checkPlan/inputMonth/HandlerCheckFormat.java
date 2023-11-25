package menu.features.checkPlan.inputMonth;

import services.validator.ValidateChoiceFormat;
import services.validator.Validator;

public class HandlerCheckFormat implements HandlerInputMonth {
    private HandlerInputMonth next;

    public HandlerCheckFormat(HandlerInputMonth next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(String months) {
        Validator validator = new ValidateChoiceFormat(months);
        return validator.isCheck();
    }

    @Override
    public void handle(String months) {
        if (!doHandle(months)) return;
        if (next != null) next.handle(months);
    }
}
