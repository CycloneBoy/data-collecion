package com.cycloneboy.controller;

import com.cycloneboy.domain.UserInfo;
import com.cycloneboy.repository.UserInfoRepository;
import com.cycloneboy.utils.ResultMsg;
import com.cycloneboy.utils.ResultStatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/14.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @RequestMapping("/")
    public  Object index(){
        UserInfo user = new UserInfo();
        user.setId(1);
        user.setName("cycloneboy");
        user.setPassword("123456");
        userInfoRepository.save(user);

        UserInfo userEntrity = userInfoRepository.findUserInfoById(1);
        ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(),ResultStatusCode.OK.getErrmsg(),userEntrity);
        return resultMsg;

    }

    @RequestMapping("getuser")
    public Object getUser(int id){
        UserInfo userEntrity = userInfoRepository.findUserInfoById(id);
        ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(),ResultStatusCode.OK.getErrmsg(),userEntrity);
        return resultMsg;
    }

    @RequestMapping("getusers")
    public Object getUsers(String role){
        List<UserInfo> userEntities = userInfoRepository.findUserInfoByRole(role);
        ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(),ResultStatusCode.OK.getErrmsg(),userEntities);
        return resultMsg;
    }

    @Modifying
    @RequestMapping("updateuser")
    public Object updateUser(@RequestBody UserInfo userEntity){
        UserInfo user = userInfoRepository.findUserInfoById(userEntity.getId());
        if(user != null){
            user.setName(userEntity.getName());
            userInfoRepository.save(user);
        }
        ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(),ResultStatusCode.OK.getErrmsg(),null);
        return resultMsg;
    }

    @Modifying
    @RequestMapping("deleteuser")
    public Object deleteUser(int id){
        userInfoRepository.delete(id);
        ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(),ResultStatusCode.OK.getErrmsg(),null);
        return resultMsg;
    }
}
