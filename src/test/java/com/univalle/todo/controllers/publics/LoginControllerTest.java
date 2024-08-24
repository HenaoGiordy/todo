package com.univalle.todo.controllers.publics;

import com.univalle.todo.DTO.auth.AuthRequest;
import com.univalle.todo.DTO.auth.AuthResponse;
import com.univalle.todo.DTO.register.RegisterRequest;
import com.univalle.todo.DTO.register.RegisterResponse;
import com.univalle.todo.entities.Usuario;
import com.univalle.todo.services.UserDetailServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

@WebMvcTest(LoginController.class)
class LoginControllerTest {

    @MockBean
    private UserDetailServiceImp userDetailServiceImp;

    @Test
    void testLoginSuccess() throws Exception {
        AuthRequest authRequest = new AuthRequest("admin", "admin");
        AuthResponse authResponse = Mockito.mock(AuthResponse.class);

        Mockito.when(userDetailServiceImp.login(authRequest)).thenReturn(authResponse);
    }

    @Test
    void registerSuccess() throws Exception {
        RegisterRequest authRequest = new RegisterRequest("admin", "admin");
        RegisterResponse registerResponse = Mockito.mock(RegisterResponse.class);

        Mockito.when(userDetailServiceImp.register(authRequest)).thenReturn(registerResponse);
    }

}
