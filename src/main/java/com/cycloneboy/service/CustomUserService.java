package com.cycloneboy.service;


import com.cycloneboy.domain.SysUser;
import com.cycloneboy.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by CycloneBoy on 2017/7/17.
 */
public class CustomUserService implements UserDetailsService{

    @Autowired
    SysUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println("username: " + username);
        System.out.println("username: " + user.getUsername() + " ,password: " + user.getPassword());
        return  user;
    }
}
