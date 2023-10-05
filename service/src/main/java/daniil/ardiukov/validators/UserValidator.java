package daniil.ardiukov.validators;

import daniil.ardiukov.UserDto;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.regex.Pattern;

public abstract class UserValidator implements Validator<UserDto> {

    private static String EMAIL_MASK = "^[\\w-.]+@\\w{2,6}.(com|ru|net|org)$";

    private static String NAME_MASK = "^[A-Za-zА-Яа-я]+$";

    private static String AGE_MASK = "^(1[6-9]|[2-9][0-9]|100)$";

    private static String LOGIN_MASK_1 = "^\\w{5,12}$";

    private static String LOGIN_MASK_2 = "^[A-Za-z].*$";

    private static String PASSWORD_MASK = "^[\\w!?]{6,12}$";

    @Override
    public boolean validate(UserDto object) {
        List<String> methods = getValidatorMethodNames();
        boolean allValid = true;
        for (String methodName : methods) {
            try {
                if (!((Boolean) (this.getClass().getMethod(methodName, UserDto.class).invoke(this, object)))) {
                    allValid = false;
                }
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return allValid;
    }

    protected abstract List<String> getValidatorMethodNames();

    public boolean validateName(UserDto object) {
        boolean result = true;
        String error = "";
        String value = object.getName();

        if (value == null
                || value.isEmpty()) {
            error = "Имя не должно быть пустым";
        } else if (!value.matches(NAME_MASK)) {
            error = "Имя должно состоять только из букв";
        }

        if (!result) {
            object.getErrors().put("Name", error);
        }

        return result;
    }

    public boolean validateAge(UserDto object) {
        boolean result = true;
        String error = "";
        String value = object.getAge();

        if (value == null
                || value.isEmpty()) {
            error = "Укажите возраст";
        } else if (!value.matches(AGE_MASK)) {
            error = "Возраст должен быть в диапазоне от 16 до 100";
        }

        if (!result) {
            object.getErrors().put("Age", error);
        }

        return result;
    }

    public boolean validateEmail(UserDto object) {
        boolean result = true;
        String error = "";
        String value = object.getEmail();

        if (value == null
                || value.isEmpty()) {
            error = "Укажите e-mail";
        } else if (!value.matches(EMAIL_MASK)) {
            error = "Указан не действительный e-mail";
        }

        if (!result) {
            object.getErrors().put("Email", error);
        }

        return result;
    }

    public boolean validateLogin(UserDto object) {
        boolean result = true;
        String error = "";
        String value = object.getLogin();

        if (value == null
                || value.isEmpty()) {
            error = "Укажите логин";
        } else if (!value.matches(LOGIN_MASK_1)) {
            error = "Логин должен состоять из 5 - 12 латинских букв, цифр и знака '_'";
        } else if (!value.matches(LOGIN_MASK_2)) {
            error = "Логин должен начинаться с буквы";
        }

        if (!result) {
            object.getErrors().put("Login", error);
        }

        return result;
    }

    public boolean validatePassword(UserDto object) {
        boolean result = true;
        String error = "";
        String value = object.getPassword();

        if (value == null
                || value.isEmpty()) {
            error = "Укажите пароль";
        } else if (!value.matches(PASSWORD_MASK)) {
            error = "Пароль должен состоять из 6 - 12 латинских букв, цифр и символов '_!?'";
        }

        if (!result) {
            object.getErrors().put("Password", error);
        }

        return result;
    }


}
