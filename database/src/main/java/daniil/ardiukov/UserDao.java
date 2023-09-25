package daniil.ardiukov;

import java.util.Optional;

public class UserDao {
    public Optional<User> findbyId(Long id) {
        User user = new User();
        user.setName("Даниил");
        return Optional.of(user);
    }
}
