package services.validator;

import constant.Constants;

import java.util.regex.Pattern;

public class ValidateEmailFormat implements Validator{
    private String email;

    public ValidateEmailFormat(String email) {
        this.email = email;
    }

    @Override
    public boolean isCheck() {
        return Pattern.compile(Constants.EMAIL_REGEX).matcher(email).matches();
    }
}
