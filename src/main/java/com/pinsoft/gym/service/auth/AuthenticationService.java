package com.pinsoft.gym.service.auth;

import com.pinsoft.gym.dto.AuthenticationRequest;
import com.pinsoft.gym.dto.AuthenticationResponse;
import com.pinsoft.gym.dto.RegisterRequest;
import com.pinsoft.gym.model.User;
import com.pinsoft.gym.repository.UserRepository;
import com.pinsoft.gym.utils.enums.Role;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
