package com.cycloneboy.repository;


import com.cycloneboy.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by CycloneBoy on 2017/7/17.
 */
@Repository
public interface SysUserRepository extends JpaRepository<SysUser,Long> {

    SysUser findByUsername(String username);
}
