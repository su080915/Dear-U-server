package com.example.dearu.domain.user.init;


import com.example.dearu.domain.user.domain.User;
import com.example.dearu.domain.user.domain.UserRole;
import com.example.dearu.domain.user.repository.UserRepository;
import com.example.dearu.global.config.admin.AdminProperties;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserInit {
    private final AdminProperties adminProperties;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        if (userRepository.existsByUsername(adminProperties.getUsername())) return;

        userRepository.save(
                User.builder()
                        .role(UserRole.ADMIN)
                        .username(adminProperties.getUsername())
                        .name("관리자")
                        .studentNumber("학번없음ㅋ")
                        .password(passwordEncoder.encode(adminProperties.getPassword()))
                        .build()
        );
    }
}
