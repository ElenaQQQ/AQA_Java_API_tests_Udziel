package entities;

import lombok.*;
import lombok.RequiredArgsConstructor;

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
        private String new_password;

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

}

