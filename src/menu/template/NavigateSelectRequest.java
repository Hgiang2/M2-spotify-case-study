package menu.template;

import entity.Request;

public class NavigateSelectRequest implements Navigator{
    private Request request;

    public NavigateSelectRequest(Request request) {
        this.request = request;
    }
    private void displayRequestMenu() {

    }

    @Override
    public void navigate() {
        displayRequestMenu();
    }
}
