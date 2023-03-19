package entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.crypto.Data;
import java.util.Date;

//import lombok.Data;
//import lombok.experimental.Accessors;
//
//import java.util.Random;
//
//@Data
//@Accessors(chain = true) //Due to this annotation we can create all fields to User like chain (User createUser)
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


        public User() {
        }

        public User(String email, Integer id, String username, String first_name, String last_name, Boolean is_active, String date_joined, String role, String date_birth) {
                this.email = email;
                this.id = id;
                this.username = username;
                this.first_name = first_name;
                this.last_name = last_name;
                this.is_active = is_active;
                this.date_joined = date_joined;
                this.role = role;
                this.date_birth = date_birth;
        }

        public String getEmail() {
                return email;
        }

        public Integer getId() {
                return id;
        }

        public String getUsername() {
                return username;
        }

        public String getFirst_name() {
                return first_name;
        }

        public String getLast_name() {
                return last_name;
        }

        public Boolean getIs_active() {
                return is_active;
        }

        public String getDate_joined() {
                return date_joined;
        }

        public String getRole() {
                return role;
        }

        public String getDate_birth() {
                return date_birth;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public void setFirst_name(String first_name) {
                this.first_name = first_name;
        }

        public void setLast_name(String last_name) {
                this.last_name = last_name;
        }

        public void setIs_active(Boolean is_active) {
                this.is_active = is_active;
        }

        public void setDate_joined(String date_joined) {
                this.date_joined = date_joined;
        }

        public void setRole(String role) {
                this.role = role;
        }

        public void setDate_birth(String date_birth) {
                this.date_birth = date_birth;
        }
}

