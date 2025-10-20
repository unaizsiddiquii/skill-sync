package com.skillsync.controller;

import com.skillsync.model.dto.UserDTO;
import com.skillsync.model.dto.UserRegisterDTO;
import com.skillsync.model.entity.User;
import com.skillsync.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //Register new user
    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserRegisterDTO userRegisterDTO) {
        UserDTO userDTO = userService.registerUser(userRegisterDTO);
        return ResponseEntity.ok(userDTO);
    }

    //Get all users
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    //Get user by email
    @GetMapping("/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
        UserDTO user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

}
