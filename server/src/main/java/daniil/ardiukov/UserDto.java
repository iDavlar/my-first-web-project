package daniil.ardiukov;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;
    @NonNull
    private String name;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

}
