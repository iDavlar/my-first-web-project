package daniil.ardiukov;

import java.util.HashMap;

public class AfterDataMap extends HashMap<String, String> {
    public static AfterDataMap of(UserDto userDto) {
        AfterDataMap result = new AfterDataMap();
        result.put("Name", userDto.getName());
        result.put("Age", userDto.getAge());
        result.put("Email", userDto.getEmail());
        result.put("Login", userDto.getLogin());
        result.put("Password", userDto.getPassword());

        return result;
    }
}
