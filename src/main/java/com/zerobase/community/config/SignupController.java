package com.zerobase.community.config;

import com.zerobase.community.dto.SignupRequest;
import com.zerobase.community.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class SignupController {
    private final UserService userService;
    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }
    @PostMapping("/user")
    public String signup(SignupRequest request) {
        userService.save(request);
        return "redirect:/login";
    }
}
