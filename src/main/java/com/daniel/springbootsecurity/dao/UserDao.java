package com.daniel.springbootsecurity.dao;

import com.daniel.springbootsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Daniel
 * @Date: 2019/7/27 14:55
 */
public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
