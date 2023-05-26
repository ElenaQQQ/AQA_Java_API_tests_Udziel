package entities;

import lombok.*;
import lombok.RequiredArgsConstructor;

//import java.util.Random;

//@Accessors(chain = true) //Due to this annotation we can create all fields to User like chain (User createUser)
@Data @RequiredArgsConstructor
public class User {
        private String email;
        private String password;
        private String current_password;
        private Integer id;
        private String username;
        private String first_name;
        private String last_name;
        private Boolean is_active;
        private String date_joined;
        private String role;
        private String date_birth;

        public User(String userEmailRandom, String userPasswordRandom, String userName) {
                email = userEmailRandom;
                password = userPasswordRandom;
                username = userName;
                current_password = userPasswordRandom;
        }

        public User(String user_email, String user_password) {
                email = user_email;
                password = user_password;
                current_password = user_password;
        }


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

