package menu.features.checkPlan.inputMonth;

import menu.features.Command;
import menu.template.NavigateTotalPayment;
import menu.template.Navigator;

public class HandlerNavigateTotalPayment implements HandlerInputMonth {
    private HandlerInputMonth next;

    public HandlerNavigateTotalPayment(HandlerInputMonth next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(String months) {
        int monthCount = Integer.parseInt(months);
        if (monthCount < 1 || monthCount > 12) {
            System.out.println("Out of bounds! Month must be between 1 & 12");
            Command inputMonth = new CommandInputMonthProcess();
            inputMonth.execute();
        }
        Navigator navigator = new NavigateTotalPayment(monthCount);
        navigator.navigate();
        return true;
    }

    @Override
    public void handle(String months) {
        while (!doHandle(months)) {
            return;
        }
        if (next != null) {
            next.handle(months);
        }
    }
}
