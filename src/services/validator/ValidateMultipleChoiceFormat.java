package services.validator;

import constant.Constants;

import java.util.regex.Pattern;

public class ValidateMultipleChoiceFormat implements Validator{
    private String choice;

    public ValidateMultipleChoiceFormat(String choice) {
        this.choice = choice;
    }

    @Override
    public boolean isCheck() {
        return Pattern.compile(Constants.MULTIPLE_CHOICE_REGEX).matcher(choice).find();
    }
}
