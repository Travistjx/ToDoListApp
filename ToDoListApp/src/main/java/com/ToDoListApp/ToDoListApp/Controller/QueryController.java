package com.ToDoListApp.ToDoListApp.Controller;

import com.ToDoListApp.ToDoListApp.Model.UserInfo;
import com.ToDoListApp.ToDoListApp.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
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

    @MutationMapping
    public boolean checkValidity(@Argument String email, @Argument String password) {
        return userInfoService.checkValidity(email, password);
    }

    @MutationMapping
    public String registerUser(@Argument String email, @Argument String password,  @Argument String name) {
        return userInfoService.saveUsers(email, password, name);
    }
}
