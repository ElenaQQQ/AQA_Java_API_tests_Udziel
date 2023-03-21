package entities;

import lombok.*;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class UserDataToRegistration {
    private String password;
    private String username;
    private String email;

}
