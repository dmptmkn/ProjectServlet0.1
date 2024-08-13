package org.example.service;

import org.example.dto.CreateUserDto;
import org.example.dto.UserDto;

public interface UserService {

    boolean create(CreateUserDto newUser);
    UserDto login(String login, String password);

}
