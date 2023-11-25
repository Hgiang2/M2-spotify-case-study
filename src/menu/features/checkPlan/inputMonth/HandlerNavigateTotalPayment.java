package menu.features.checkPlan.inputMonth;

import menu.template.Navigator;

public class HandlerNavigateTotalPayment implements HandlerInputMonth{
    private HandlerInputMonth next;

    public HandlerNavigateTotalPayment(HandlerInputMonth next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(String months) {
        int monthCount = Integer.parseInt(months);
        Navigator navigator = new NavigateTotalPayment(monthCount);
        navigator.navigate();
        return true;
    }

    @Override
    public void handle(String months) {
        if (!doHandle(months)) return;
        if (next != null) next.handle(months);
    }
}
