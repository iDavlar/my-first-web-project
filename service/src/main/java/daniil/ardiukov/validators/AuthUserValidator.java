package daniil.ardiukov.validators;

import java.util.List;

public class AuthUserValidator extends UserValidator {
    @Override
    protected List<String> getValidatorMethodNames() {
        return List.of("validateLogin", "validatePassword");
    }
}
