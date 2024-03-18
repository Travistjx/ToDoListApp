package com.ToDoListApp.ToDoListApp.Service.UserImpl;

import com.ToDoListApp.ToDoListApp.Model.UserInfo;
import com.ToDoListApp.ToDoListApp.Repository.UserInfoRepository;
import com.ToDoListApp.ToDoListApp.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private final UserInfoRepository userInfoRepository;

    public UserInfoServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }


    @Override
    public UserInfo findByUserInfoId(String userId) {
        Optional<UserInfo> userInfo = userInfoRepository.findByUserId(userId);
        return userInfo.orElse(null);
    }

    @Override
    public List<UserInfo> findAllUsers() {
        return userInfoRepository.findAll();
    }

    @Override
    public boolean checkValidity(String email, String password) {
        UserInfo user = userInfoRepository.findByEmail(email);
        if (user != null) {
            return user.getPassword().equals(password);
        }

        return false;
    }

    @Override
    public String saveUsers(String email, String password, String name) {
        // Check if a user with the provided email already exists
        UserInfo existingUser = userInfoRepository.findByEmail(email);
        if (existingUser != null) return "Email already in use.";

        // Create the new user
        UserInfo userInfo = new UserInfo(email, password, name);
        UserInfo savedUser = userInfoRepository.save(userInfo);
        return savedUser.getUserId() != null? "Registration successful.": "An error occurred. Please try again.";
    }
}
