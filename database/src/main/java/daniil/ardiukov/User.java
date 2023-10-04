package daniil.ardiukov;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    @NonNull
    private int id;
    private String name;
    private int age;
    private String email;
    private String login;
    private String password;
}
