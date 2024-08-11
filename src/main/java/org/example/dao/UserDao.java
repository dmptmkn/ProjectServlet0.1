package org.example.dao;

import org.example.entity.User;

import java.util.List;

public interface UserDao {

    boolean save(User user);
    List<User> findAll();
    User findById(Long id);
    boolean update(Long id, User user);
    boolean delete(Long id);

}
