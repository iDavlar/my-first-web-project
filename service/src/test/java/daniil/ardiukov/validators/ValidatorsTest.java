package daniil.ardiukov.validators;

import daniil.ardiukov.UserDto;
import org.junit.Test;

public class ValidatorsTest {
    @Test
    public void validateUserDto() {
        boolean r = new AuthUserValidator().validate(
                UserDto.builder()
                        .login("Daniil")
                        .password("dsdsd")
                        .build()
        );
        System.out.println(r);
        int a = 1;
    }
}
