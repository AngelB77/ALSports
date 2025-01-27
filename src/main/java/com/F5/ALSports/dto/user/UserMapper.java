package com.F5.ALSports.dto.user;

import com.F5.ALSports.model.User;
import com.F5.ALSports.model.User;

public class UserMapper {
    public static User dtoToEntity(UserRequest userRequest) {
        return new User(userRequest.name(), userRequest.email(),
                userRequest.password());
    }
    public static UserResponse entityTodto(User user) {
        return new UserResponse(user.getName(), user.getEmail(),
                user.getPassword());

    }
}

