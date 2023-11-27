package menu.features.registerArtist;

import entity.Email;
import entity.EmailList;
import entity.Request;
import entity.RequestList;
import services.observer.Observer;
import services.observer.Subject;

public class HandlerSetEmail extends Subject implements HandlerString {
    private HandlerString next;
    private Request request;

    public HandlerSetEmail(HandlerString next, Request request) {
        this.next = next;
        this.request = request;
    }

    @Override
    public boolean doHandle(String stageName) {
        Observer observeEmail = EmailList.getInstance();
        Observer observeRequest = RequestList.getInstance();
        addObserver(observeEmail);
        addObserver(observeRequest);
        Email email = new Email(stageName);
        email.getRequestList().add(request);
        request.setEmail(stageName);
        EmailList.getInstance().getValidEmail().add(email);
        notifyObserver();
        removeAll();
        return true;
    }

    @Override
    public void handle(String stageName) {
        if (!doHandle(stageName)) {
            return;
        }
        if (next != null) {
            next.handle(stageName);
        }
    }
}
