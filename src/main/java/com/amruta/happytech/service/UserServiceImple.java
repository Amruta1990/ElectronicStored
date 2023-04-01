package com.amruta.happytech.service;

import com.amruta.happytech.dto.UserDto;
import com.amruta.happytech.exception.ResourceNotFoundException;
import com.amruta.happytech.model.User;
import com.amruta.happytech.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImple implements UserServiceI {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    private ModelMapper modelmapper;
    @Override
    public UserDto saveUser(UserDto userDto) {
        User map = this.modelmapper.map(userDto, User.class);
        User save = this.userRepository.save(map);

        return this.modelmapper.map(save,UserDto.class);


    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> all = this.userRepository.findAll();
        List<UserDto> userDtos = all.stream().map((user) -> this.modelmapper.map(user, UserDto.class)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {

        User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found exception"));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setAge(userDto.getAge());
        User save = this.userRepository.save(user);
        return this.modelmapper.map(save,UserDto.class);
    }

    @Override
    public void delete(Long id) {

        User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found exception"));
        this.userRepository.delete(user);

    }
}
