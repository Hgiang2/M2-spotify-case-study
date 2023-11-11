package menu.service.userCommand.signInCommand.chainOfResponsibility;

import menu.menuCommand.CommandInput;
import menu.service.userCommand.HandlerUser;
import menu.service.userCommand.RequestUser;
import services.validator.ValidatePasswordFormat;
import services.validator.Validator;
import menu.service.userCommand.signInCommand.CommandInputPassword;

public class HandlerPasswordValidFormat implements HandlerUser {
    private HandlerUser next;

    public HandlerPasswordValidFormat(HandlerUser next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestUser requestUser) {
        String password = requestUser.getPassword();
        Validator validatePasswordFormat = new ValidatePasswordFormat(password);
        return validatePasswordFormat.isCheck();
    }

    @Override
    public void handle(RequestUser requestUser) {
        while (!doHandle(requestUser)) {
            System.out.println("Password must be at least 8 characters & have at least 1 UPPERCASE, 1 lowercase and 1 special character.");
            CommandInput reEnterPassword = new CommandInputPassword("Please choose another password: ");
            reEnterPassword.execute();
            requestUser.setPassword(reEnterPassword.getInput());
            this.doHandle(requestUser);
        }
        if (next != null) {
            next.handle(requestUser);
        }
    }

//    private boolean checkPasswordFormat(RequestUser requestUser) {
//        String password = requestUser.getPassword();
//        return Pattern.compile(regex).matcher(password).find() && password.length() >= 8;
//    }
}
