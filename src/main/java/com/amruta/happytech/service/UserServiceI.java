package com.amruta.happytech.service;

import com.amruta.happytech.dto.UserDto;

import java.util.List;

public interface UserServiceI {

    UserDto saveUser(UserDto userDto);

    List<UserDto> getAllUser();

    UserDto updateUser(UserDto userDto,Long id);

    void delete (Long id);


}
