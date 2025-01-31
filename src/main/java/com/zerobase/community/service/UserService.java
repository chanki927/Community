package com.zerobase.community.service;

import com.zerobase.community.dto.SignupRequest;
import com.zerobase.community.entity.User;
import com.zerobase.community.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public Long save(SignupRequest request) {
        return userRepository.save(User.builder()
                .userId(request.getUserId())
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .createdDate(LocalDateTime.now())
                .build()).getId();
    }
}
