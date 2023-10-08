package daniil.ardiukov;

import daniil.ardiukov.validators.AuthUserValidator;
import daniil.ardiukov.validators.ChangeUserValidator;
import daniil.ardiukov.validators.RegUserValidator;

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

    public boolean checkAuthentication(UserDto userData) {
        Optional<User> user;
        if (new AuthUserValidator().validate(userData)
                && (user = userDao.findByLogPass(userData.getLogin(), userData.getPassword())).isPresent()) {
            userData.fillFromUser(user.get());
            return true;
        }

        userData.getErrors().put("Auth", "Неверный логин или пароль");
        return false;
    }

    public boolean registerNew(UserDto userData) {
        Optional<User> user;
        if (new RegUserValidator().validate(userData)
                && hasDuplicates(userData)
                && (user = createUser(userData)).isPresent()) {
            userData.fillFromUser(user.get());
            return true;
        }

        return false;
    }

    private boolean hasDuplicates(UserDto userData) {
        boolean result = true;
        if (userDao.find(user -> user.getEmail().equals(userData.getEmail())).isPresent()) {
            result = false;
            userData.getErrors().put("Email", "Email занят!");
        }
        if (userDao.find(user -> user.getLogin().equals(userData.getLogin())).isPresent()) {
            result = false;
            userData.getErrors().put("Login", "Логин занят!");
        }
        return result;
    }

    private boolean hasDuplicates(int exceptId, UserDto userData) {
        boolean result = true;
        if (userDao.find(user -> user.getId() != exceptId
                && user.getEmail().equals(userData.getEmail())).isPresent()) {
            result = false;
            userData.getErrors().put("Email", "Email занят!");
        }
        if (userDao.find(user -> user.getId() != exceptId
                && user.getLogin().equals(userData.getLogin())).isPresent()) {
            result = false;
            userData.getErrors().put("Login", "Логин занят!");
        }
        return result;
    }

    private Optional<User> createUser(UserDto userData) {
        return userDao.createNewUser(
                userData.getName(),
                Integer.parseInt(userData.getAge()),
                userData.getEmail(),
                userData.getLogin(),
                userData.getPassword()
        );
    }

    public boolean changeUser(UserDto userData) {
        Optional<User> user;
        if (new ChangeUserValidator().validate(userData)
                && hasDuplicates(userData.getId(), userData)
                && (user = updateData(userData)).isPresent()) {
            userData.fillFromUser(user.get());
            return true;
        }

        return false;
    }

    private Optional<User> updateData(UserDto userData) {
        return userDao.update(
                userData.getId(),
                user -> {
                    user.setName(userData.getName());
                    user.setAge(Integer.parseInt(userData.getAge()));
                    user.setEmail(userData.getEmail());
                    user.setLogin(userData.getLogin());
                    user.setPassword(userData.getPassword());
                }
        );
    }
}
