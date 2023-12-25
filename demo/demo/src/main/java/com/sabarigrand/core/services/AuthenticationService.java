package com.sabarigrand.core.services;

import com.sabarigrand.core.config.JwtService;
import com.sabarigrand.core.models.entities.UserEntity;
import com.sabarigrand.core.models.requests.AuthenticationRequest;
import com.sabarigrand.core.models.requests.RegisterRequest;
import com.sabarigrand.core.models.responses.AuthenticationResponse;
import com.sabarigrand.core.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        //TODO: CHECK IF USER EXISTS BEFORE CREATING A NEW USER

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(request.getEmail());
        userEntity.setUsername(request.getUsername());
        userEntity.setFirstName(request.getFirstName());
        userEntity.setLastName(request.getLastName());
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        userEntity.setRole(UserEntity.Role.USER);
        userEntity.setEnabled(true);
        userEntity.setCreatedDate(new Date());
        userEntity.setModifiedDate(new Date());

        userRepository.save(userEntity);

        String jwtToken = jwtService.generateToken(userEntity);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));

        UserEntity userEntity = userRepository.fetchUserByEmail(request.getEmail());
        String jwtToken = jwtService.generateToken(userEntity);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
