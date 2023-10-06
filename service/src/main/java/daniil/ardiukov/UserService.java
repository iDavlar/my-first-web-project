package daniil.ardiukov;

import daniil.ardiukov.validators.AuthUserValidator;
import daniil.ardiukov.validators.Validator;

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

    public boolean updateUser(int id, String name) {
        return userDao.updateUserName(id, name);
    }

    public boolean checkAuthentication(UserDto usedData) {
        if (new AuthUserValidator().validate(usedData)
                && userDao.auth(usedData.getLogin(), usedData.getPassword())) {
            return true;
        }

        usedData.getErrors().put("Auth", "Неверный логин или пароль");
        return false;
    }
}
