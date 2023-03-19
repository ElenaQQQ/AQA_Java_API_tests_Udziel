package entities;

import lombok.*;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class UserCreated {
    private String email;
    private Integer id;
    private String username;

//    public UserCreated() {
//    }


//    public UserCreated(Integer id, String username, String email) {
//        this.id = id;
//        this.username = username;
//        this.email = email;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getEmail() {
//        return email;
//    }
}
