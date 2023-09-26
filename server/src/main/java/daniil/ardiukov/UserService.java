package daniil.ardiukov;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserDao userDao = UserDao.getInstance();

    public Optional<UserDto> getUser(Integer id) {
        return userDao.findbyId(id).map(UserDto::new);
    }

    public Optional<List<UserDto>> getUsers() {
        return userDao.getAllUsers().map(list -> list.stream().map(UserDto::new).toList());
    }
}
