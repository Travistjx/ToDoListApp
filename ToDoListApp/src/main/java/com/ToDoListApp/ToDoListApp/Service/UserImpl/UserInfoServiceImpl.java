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
}
