package com.ToDoListApp.ToDoListApp.Repository;

import com.ToDoListApp.ToDoListApp.Model.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserInfoRepository extends MongoRepository<UserInfo, String> {
    Optional<UserInfo> findByUserId(String s);

    UserInfo findByEmail(String email);
}

