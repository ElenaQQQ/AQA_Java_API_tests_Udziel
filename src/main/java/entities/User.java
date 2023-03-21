package entities;

import lombok.*;

//import java.util.Random;

//@Data
//@Accessors(chain = true) //Due to this annotation we can create all fields to User like chain (User createUser)
@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class User {
        private String email;
        private Integer id;
        private String username;
        private String first_name;
        private String last_name;
        private Boolean is_active;
        private String date_joined;
        private String role;
        private String date_birth;

//        @JsonCreator
//        public User(
//                @JsonProperty("name") String email,
//                @JsonProperty("id") Integer id,
//                @JsonProperty("username") String username,
//                @JsonProperty("first_name") String firstName,
//                @JsonProperty("last_name") String last_name,
//                @JsonProperty("is_active") Boolean is_active,
//                @JsonProperty("date_joined") String date_joined,
//                @JsonProperty("role") String role,
//                @JsonProperty("date_birth") String date_birth)
//        {
//                this.email = email;
//                this.id = id;
//                this.username = username;
//                this.first_name = firstName;
//                this.last_name = last_name;
//                this.is_active = is_active;
//                this.date_joined = date_joined;
//                this.role = role;
//                this.date_birth = date_birth;
//        }

}

