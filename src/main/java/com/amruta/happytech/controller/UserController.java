package com.amruta.happytech.controller;

import com.amruta.happytech.dto.UserDto;
import com.amruta.happytech.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserServiceI userServiceI;
   @PostMapping("/saveusers")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){

        UserDto userDto1 = userServiceI.saveUser(userDto);
        return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
    }

    @GetMapping("/getallUser")
    public ResponseEntity<List<UserDto>> getallUser(){

        List<UserDto> allUser = userServiceI.getAllUser();
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }
@PutMapping("/updateUser/{id}")
public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable Long id){

    UserDto userDto1 = userServiceI.updateUser(userDto,id);
    return new ResponseEntity<>(userDto1,HttpStatus.CREATED);
}
@DeleteMapping("/User/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){

         userServiceI.delete(id);
        return new ResponseEntity<>("delete successfully", HttpStatus.OK);
    }
}
