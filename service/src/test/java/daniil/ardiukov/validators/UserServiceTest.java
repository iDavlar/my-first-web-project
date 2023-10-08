package daniil.ardiukov.validators;

import daniil.ardiukov.UserDto;
import daniil.ardiukov.UserService;
import org.junit.Test;

import static org.junit.Assert.fail;

public class UserServiceTest {
    @Test
    public void registerNew() {
        UserDto userDto = UserDto.builder()
                .name("Даниил")
                .email("danielardukov@gmail.com")
                .age("25")
                .login("Davlar")
                .password("123456")
                .build();

        if (new UserService().registerNew(userDto)) {

            fail("A duplicate has been created!");
        } else {
            System.out.println(userDto.getErrors());
        }

    }
}
