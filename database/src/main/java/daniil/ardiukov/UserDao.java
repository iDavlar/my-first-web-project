package daniil.ardiukov;

import java.io.*;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserDao {

    public static final String CONF_FILE_NAME = "database.properties";

    public static final String PROFILES_FILE_PROP_NAME = "users.json";

    public static final File USERS_DATA = getUsersFile();

    public static UserDao instance;

    private List<User> users;

    private UserDao() {
        this.users = userInitiation();
    }

    public static UserDao getInstance() {
        if (instance == null) {
            synchronized (UserDao.class) {
                if (instance == null) {
                    instance = new UserDao();
                }
            }
        }
        return instance;
    }

    private static File getUsersFile() {
        String userJsonFileName = getProperty(CONF_FILE_NAME, PROFILES_FILE_PROP_NAME);
        return new File(userJsonFileName);
    }

    private static String getProperty(String resource, String propertyName) {
        try (InputStream is = UserDao.class.getResourceAsStream("/" + resource)) {
            Properties prop = new Properties();
            prop.load(is);
            return prop.getProperty(propertyName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<User> userInitiation() {
        if (!USERS_DATA.exists()) {
            return createData();
        }
        return loadData();
    }

    private List<User> createData() {
        try {
            if (!USERS_DATA.exists()) {
                USERS_DATA.createNewFile();
            }
            List<User> users = getInitialUserData();
            saveData(users);
            return users;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<User> getInitialUserData() {
        List<User> result = new ArrayList<>();
        result.add(new User(1, "Даниил", 25, "mail@mail.ru", "Davlar", "123456"));

        return result;
    }

    private List<User> loadData() {
        try (FileInputStream fis = new FileInputStream(USERS_DATA)) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(fis, new TypeReference<List<User>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveData(List<User> data) {
        try (FileOutputStream ois = new FileOutputStream(USERS_DATA)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(ois, data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> findbyId(Integer id) {
        return users.stream().filter(user -> user.getId() == id).findFirst();
    }

    public Optional<List<User>> getAllUsers() {
        return Optional.of(this.users);
    }

    public boolean updateUserName(int id, String name) {
        try {
            User user = findbyId(id).get();
            user.setName(name);
            saveData(users);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean auth(String login, String password) {
        return users.stream()
                .filter(user -> user.getName().equals(login))
                .anyMatch(user -> user.getPassword().equals(password));
    }
}
