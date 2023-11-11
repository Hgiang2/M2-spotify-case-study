package services.validator;

import constant.Constants;

import java.util.regex.Pattern;

public class ValidateUsernameFormat implements Validator{
    private String username;

    public ValidateUsernameFormat(String username) {
        this.username = username;
    }

    @Override
    public boolean isCheck() {
        return Pattern.compile(Constants.USERNAME_REGEX).matcher(username).find() && username.length() < Constants.USERNAME_MAX_LENGTH;
    }
}
