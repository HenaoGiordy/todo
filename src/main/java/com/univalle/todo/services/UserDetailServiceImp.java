package com.univalle.todo.services;

import com.univalle.todo.DTO.auth.AuthRequest;
import com.univalle.todo.DTO.auth.AuthResponse;
import com.univalle.todo.DTO.register.RegisterRequest;
import com.univalle.todo.DTO.register.RegisterResponse;
import com.univalle.todo.entities.Usuario;
import com.univalle.todo.repository.UserRepository;
import com.univalle.todo.security.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserDetailServiceImp implements UserDetailsService {

    private UserRepository userRepository;

    private JwtUtils jwtUtils;

    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(username));

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        return new User(usuario.getUsername(), usuario.getPassword(),authorities );
    }

    public AuthResponse login(AuthRequest request){
        String username = request.username();
        String password = request.password();

        Authentication authentication = this.authenticate(username, password);

        String token = jwtUtils.generateToken(authentication);

        return new AuthResponse(username, token, "Token creado Satisfactoriamente");
    }

    private Authentication authenticate(String username, String password) {
        UserDetails userDetails = loadUserByUsername(username);

        if (userDetails == null) {
            throw new UsernameNotFoundException(username);
        }
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Bad credentials");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    public RegisterResponse register(RegisterRequest register){
        String username = register.username();
        String password = register.password();
        userRepository.save(Usuario.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .build());
        return new RegisterResponse(username, "Usuario creado satisfactoriamente");
    }
}
