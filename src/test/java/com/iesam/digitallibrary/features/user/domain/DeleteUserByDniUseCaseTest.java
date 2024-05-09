package com.iesam.digitallibrary.features.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class DeleteUserByDniUseCaseTest {
    @Mock
    UserRepository userRepository;
    DeleteUserByDniUseCase deleteUserByDniUseCase;

    @BeforeEach
    void setUp() {
        deleteUserByDniUseCase = new DeleteUserByDniUseCase(userRepository);

    }

    @AfterEach
    void clear() {
        deleteUserByDniUseCase = null;
    }
    @Test
   public void eliminarusuarioporeldni() {
        String dni = "DNI";
        deleteUserByDniUseCase.execute(dni);
        Mockito.verify(userRepository, Mockito.times(1)).delete(dni);
    }
}