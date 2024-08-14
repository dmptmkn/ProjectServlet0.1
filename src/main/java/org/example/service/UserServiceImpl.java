package org.example.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.dao.UserDao;
import org.example.dao.UserDaoImpl;
import org.example.dto.CreateUserDto;
import org.example.dto.UserDto;
import org.example.entity.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

    private static final UserServiceImpl INSTANCE = new UserServiceImpl();
    private final UserDao dao = UserDaoImpl.getInstance();

    public static UserServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean create(CreateUserDto newUser) {
        User user = User.builder()
                .name(newUser.getName())
                .lastName(newUser.getLastName())
                .age(Integer.parseInt(newUser.getAge()))
                .login(newUser.getLogin())
                .password(newUser.getPassword())
                .build();

        return dao.save(user);
    }

    @Override
    public UserDto login(String login, String password) {
        User user = dao.findByLoginAndPassword(login, password);

        UserDto userDto = null;
        if (user != null) {
            userDto = UserDto.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .lastName(user.getLastName())
                    .age(String.valueOf(user.getAge()))
                    .build();
        }

        return userDto;
    }
}
