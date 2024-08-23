package com.univalle.todo.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.univalle.todo.entities.Usuario;
import com.univalle.todo.repository.UserRepository;
import com.univalle.todo.services.UserDetailServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JwtUtils {
    @Value("${secret.jwt.key}")
    private String privateKey;

    @Value("${issuer.jwt}")
    private String issuer;

    private UserRepository userRepository;

    public JwtUtils(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String generateToken(Authentication authentication) {
        try {

            Algorithm algorithm = Algorithm.HMAC256(privateKey);
            String username = authentication.getName();
            Optional<Usuario> usuarioOpt = userRepository.findByUsername(username);
            Usuario usuario = usuarioOpt.orElseThrow();

            return JWT.create()
                    .withSubject(username)
                    .withClaim("id", usuario.getId())
                    .withIssuer(issuer)
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new JWTCreationException("Error", exception);
        }
    }

    public DecodedJWT validarToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(privateKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build();

            return  verifier.verify(token);
        } catch (JWTVerificationException exception){
            throw new JWTVerificationException("Invalid token");
        }
    }

}
