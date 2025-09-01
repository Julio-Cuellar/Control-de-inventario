package com.jcode.userservice.service;

import com.jcode.userservice.domain.User;
import com.jcode.userservice.dto.RegisterRequest;
import com.jcode.userservice.dto.UserDTO;
import com.jcode.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    // ----------CREATE USER-----------



    public UserDTO register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email ya registrado");
        }
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("Username ya registrado");
        }
        User user = User.builder()
                .name(request.getName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .username(request.getUsername())
                .phoneNumber(request.getPhoneNumber())
                .hashPassword(passwordEncoder.encode(request.getPassword()))
                .enabled(false)
                .build();
        user = userRepository.save(user);
        return toDto(user);


    }


    private UserDTO toDto (User user){
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .lastname(user.getLastName())
                .email(user.getEmail())
                .userName(user.getUsername())
                .enabled(user.isEnabled())
                .StoreIds(user.getStoreIds())
                .build();
    }

}
