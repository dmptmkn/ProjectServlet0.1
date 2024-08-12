package org.example.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.dao.UserDao;
import org.example.dao.UserDaoImpl;
import org.example.entity.User;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

    UserDao dao = UserDaoImpl.getInstance();

    @Override
    public boolean save(User user) {
        return dao.save(user);
    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public boolean update(Long id, User user) {
        return dao.update(id, user);
    }

    @Override
    public boolean delete(Long id) {
        return dao.delete(id);
    }
}
