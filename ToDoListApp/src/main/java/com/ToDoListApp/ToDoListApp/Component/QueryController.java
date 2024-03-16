package com.ToDoListApp.ToDoListApp.Component;

import com.ToDoListApp.ToDoListApp.Model.UserInfo;
import com.ToDoListApp.ToDoListApp.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class QueryController{

    @Autowired
    private final UserInfoService userInfoService;

    public QueryController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @QueryMapping
    public UserInfo getUserInfoById(@Argument String userId) {
        return userInfoService.findByUserInfoId(userId);
    }

    @QueryMapping
    public List<UserInfo> getAllUsers() {
        return userInfoService.findAllUsers();
    }
}
