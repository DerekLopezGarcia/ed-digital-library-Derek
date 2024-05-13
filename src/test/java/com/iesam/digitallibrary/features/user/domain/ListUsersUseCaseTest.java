package com.iesam.digitallibrary.features.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ListUsersUseCaseTest {
    @Mock
    UserRepository userRepository;
    ListUsersUseCase listUsersUseCase;

    @BeforeEach
    void setUp() {
        listUsersUseCase = new ListUsersUseCase(userRepository);
    }

    @AfterEach
    void clear() {
        listUsersUseCase = null;
    }
    @Test
    public void listausuarios() {
        listUsersUseCase.execute();
        verify(userRepository, times(1)).getAll();
    }
}