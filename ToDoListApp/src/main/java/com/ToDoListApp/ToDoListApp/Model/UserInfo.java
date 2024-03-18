package com.ToDoListApp.ToDoListApp.Model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "user_info")
public class UserInfo{
        @Id
        private String userId;

        @Field("name")
        private String name;

        @Field("email")
        @Indexed(unique = true)
        private String email;

        @Field("password")
        private String password;

        @Field("role")
        private Role role;

        public UserInfo (String email, String password, String name){
                this.email = email;
                this.password = password;
                this.name = name;
                this.role = Role.ROLE_USER;
        }
}
