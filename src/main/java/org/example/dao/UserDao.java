package org.example.dao;

import org.example.entity.User;

import java.util.List;

public interface UserDao {

    boolean save(User user);
    List<User> findAll();
    User findById(Long id);
    User findByLoginAndPassword(String login, String password);
    boolean update(Long id, User user);
    boolean delete(Long id);

}
