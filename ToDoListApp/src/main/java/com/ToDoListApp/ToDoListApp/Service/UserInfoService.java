package com.ToDoListApp.ToDoListApp.Service;

import com.ToDoListApp.ToDoListApp.Model.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserInfoService {
    UserInfo findByUserInfoId (String userId);
    List<UserInfo> findAllUsers();
}
