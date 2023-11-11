package services.validator;

import constant.Constants;

import java.util.regex.Pattern;

public class ValidatePasswordFormat implements Validator {
    private String password;

    public ValidatePasswordFormat(String password) {
        this.password = password;
    }

    @Override
    public boolean isCheck() {
        return Pattern.compile(Constants.PASSWORD_REGEX).matcher(password).find() && password.length() >= Constants.PASSWORD_MIN_LENGTH;
    }
}
