package daniil.ardiukov;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class UsedDaoTest {

    @Test
    public void authenticationTest() {
        try {
            assertTrue(
                    UserDao.getInstance().findByLogPass("Davlar", "123456").isPresent()
            );

        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

    }
}
