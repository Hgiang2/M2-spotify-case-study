package services.validator;

import constant.Constants;

import java.util.regex.Pattern;

public class ValidateChoiceFormat implements Validator{
    private String choice;

    public ValidateChoiceFormat(String choice) {
        this.choice = choice;
    }

    @Override
    public boolean isCheck() {
        return Pattern.compile(Constants.SINGLE_CHOICE_REGEX).matcher(choice).matches();
    }
}
