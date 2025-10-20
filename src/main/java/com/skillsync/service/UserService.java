package com.skillsync.service;

import com.skillsync.model.dto.UserDTO;
import com.skillsync.model.dto.UserRegisterDTO;

import java.util.List;

public interface UserService {

    UserDTO registerUser(UserRegisterDTO userRegisterDTO);

    UserDTO getUserByEmail(String email);

    List<UserDTO> getAllUser();

}
