package daniil.ardiukov;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private int id;
    private String name;
    private String age;
    private String email;
    private String login;
    private String password;
    private Map<String, String> errors = new HashMap<>();

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.age = String.valueOf(user.getAge());
        this.email = user.getEmail();
        this.login = user.getLogin();
        this.password = user.getPassword();
    }

}
