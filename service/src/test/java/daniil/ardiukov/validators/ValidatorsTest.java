package daniil.ardiukov.validators;

import daniil.ardiukov.UserDto;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorsTest {
    @Test
    public void validateUserDto() {
        UserDto userDto1 = UserDto.builder()
                .login("Daniil")
                .password("dsdsdfd")
                .build();
        if (!new AuthUserValidator().validate(userDto1)) {
            System.out.println(userDto1.getErrors());
            fail("Must be true");
        }

        UserDto userDto2 = UserDto.builder()
                .login("")
                .password("")
                .build();
        if (new AuthUserValidator().validate(userDto2)) {
            System.out.println(userDto2.getErrors());
            fail("Must be false");
        } else {
            System.out.println(userDto2.getErrors());
        }
    }
}
