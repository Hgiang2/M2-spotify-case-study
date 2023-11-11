package menu.service.userCommand;

public interface HandlerUser {
    boolean doHandle(RequestUser requestUser);
    void handle(RequestUser requestUser);
}
