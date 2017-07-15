package com.cycloneboy.repository;

import com.cycloneboy.domain.Helmet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/15.
 */
@Repository
public interface HelmetRepository extends JpaRepository<Helmet,Integer>{

    Helmet findHelmetById(int id);

    List<Helmet> findHelmetsByName(String name);


}
