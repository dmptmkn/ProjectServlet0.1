package org.example.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateUserDto {

     String name;
     String lastName;
     String age;
     String login;
     String password;

}
