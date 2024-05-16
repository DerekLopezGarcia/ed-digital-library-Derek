package com.iesam.digitallibrary.features.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class GetUserByDniUseCaseTest {
    @Mock
    UserRepository userRepository;
    GetUserByDniUseCase getUserByDniUseCase;
    @BeforeEach
    void setUp() {
        getUserByDniUseCase = new GetUserByDniUseCase(userRepository);
    }

    @AfterEach
    public void clear() {
        getUserByDniUseCase = null;
    }
    @Test
    public void recibounDNIydevuelvoelusuario() {
        //given
        User userExpected = new User("name","email","DNI");
        Mockito.when(userRepository.get("DNI")).thenReturn(userExpected);
        //when
        User userReceived = getUserByDniUseCase.execute("DNI");
        //then
        Assertions.assertEquals(userReceived.DNI, "DNI");
        Assertions.assertEquals(userReceived.email, "email");
        Assertions.assertEquals(userReceived.name, "name");
        Assertions.assertEquals(userReceived, userExpected);
    }
}