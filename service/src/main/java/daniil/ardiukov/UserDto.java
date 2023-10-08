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
    private volatile Map<String, String> errors = new HashMap<>();

    public UserDto(User user) {
        this.fillFromUser(user);
    }

    public void fillFromUser(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.age = String.valueOf(user.getAge());
        this.email = user.getEmail();
        this.login = user.getLogin();
        this.password = user.getPassword();
    }

    public Map<String, String> getErrors() {
        if (errors == null) {
            synchronized (this) {
                if (errors == null) {
                    errors = new HashMap<>();
                }
            }
        }
        return errors;
    }
}
