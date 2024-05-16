package com.iesam.digitallibrary.features.user.domain;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class NewUserUseCaseTest {
    @Mock
    UserRepository userRepository;
    NewUserUseCase newUserUseCase;

    @BeforeEach
    void setUp() {
        newUserUseCase = new NewUserUseCase(userRepository);
    }

    @AfterEach
    public void clear() {
        newUserUseCase = null;
    }

    @Test
    public void recibounusuarioyloguardo() {
        User user = new User("name", "email", "DNI");
        newUserUseCase.execute(user);
        verify(userRepository, times(1)).save(user);

    }
}