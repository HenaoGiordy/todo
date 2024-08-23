package com.univalle.todo.services;

import com.univalle.todo.entities.Usuario;
import com.univalle.todo.repository.UserRepository;
import com.univalle.todo.security.JwtUtils;
import lombok.AllArgsConstructor;
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
}
