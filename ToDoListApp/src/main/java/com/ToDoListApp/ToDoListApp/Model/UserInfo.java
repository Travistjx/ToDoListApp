package com.ToDoListApp.ToDoListApp.Model;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user_info")
public class UserInfo{
        @Id
        @Field("user_id")
        private String userId;

        @Field("first_name")
        private String firstName;

        @Field("last_name")
        private String lastName;
}
