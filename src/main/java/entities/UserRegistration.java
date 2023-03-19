package entities;

import lombok.*;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class UserRegistration {
    private String password;
    private String username;
    private String email;

//    public UserRegistration() {
//    }
//
//    public UserRegistration(String password, String username, String email) {
//        this.password = password;
//        this.username = username;
//        this.email = email;
//    }
}
