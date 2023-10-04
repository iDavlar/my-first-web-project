package daniil.ardiukov;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;
    private String name;
    private String age;
    private String email;
    private String login;
    private String password;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.age = String.valueOf(user.getAge());
        this.email = user.getEmail();
        this.login = user.getLogin();
        this.password = user.getPassword();
    }

}
