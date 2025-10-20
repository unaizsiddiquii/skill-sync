package com.skillsync.service.lmpl;

import com.skillsync.model.dto.UserDTO;
import com.skillsync.model.dto.UserRegisterDTO;
import com.skillsync.model.entity.Role;
import com.skillsync.model.entity.User;
import com.skillsync.repository.RoleRepository;
import com.skillsync.repository.UserRepository;
import com.skillsync.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO registerUser(UserRegisterDTO userRegisterDTO) {
        if (userRepository.existsByEmail(userRegisterDTO.getEmail())) {
            throw new RuntimeException("Email is already in use");
        } else if (userRepository.existsByUsername(userRegisterDTO.getUsername())) {
            throw new RuntimeException("Username is already in use");
        }

        Role roleUser = roleRepository.findByName("ROLE_USER").orElseThrow(() -> new RuntimeException("Role not found"));

        User user = User.builder().username(userRegisterDTO.getUsername()).email(userRegisterDTO.getEmail()).password(passwordEncoder.encode(userRegisterDTO.getPassword())).roles(Set.of(roleUser)).build();

        User saved = userRepository.save(user);
        return mapToDTO(user);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        return userRepository.findByEmail(email).map(this::mapToDTO).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<UserDTO> getAllUser() {
        return userRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private UserDTO mapToDTO(User user) {
        return UserDTO.builder().id(user.getId()).username(user.getUsername()).email(user.getEmail()).skills(user.getSkills().stream().map(s -> s.getName()).collect(Collectors.toSet())).roles(user.getRoles().stream().map(r -> r.getName()).collect(Collectors.toSet())).build();
    }
}
