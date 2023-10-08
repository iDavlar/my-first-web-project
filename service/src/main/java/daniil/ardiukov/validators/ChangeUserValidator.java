package daniil.ardiukov.validators;

import java.util.List;

public class ChangeUserValidator extends UserValidator {
    @Override
    protected List<String> getValidatorMethodNames() {
        return List.of(
                "validateName",
                "validateAge",
                "validateEmail",
                "validateLogin",
                "validatePassword"
        );
    }
}
