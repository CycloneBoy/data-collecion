package com.cycloneboy.repository;

import com.cycloneboy.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/14.
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {

        UserInfo findUserInfoById(int id);

        List<UserInfo> findUserInfoByRole(String role);

        @Query(value = "select * from t_user limit ?1",nativeQuery = true)
        List<UserInfo> findAllUsersByCount(int count);
}
