package com.iesam.digitallibrary.features.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ModifyUserUseCaseTest {
    @Mock
    UserRepository userRepository;
    ModifyUserUseCase modifyUserUseCase;

    @BeforeEach
    void setUp() {
        modifyUserUseCase = new ModifyUserUseCase(userRepository);
    }

    @AfterEach
    void clear() {
        modifyUserUseCase = null;
    }

    @Test
    public void modificarusuario() {
        User user = new User("name", "mail", "Dni");
        modifyUserUseCase.execute(user);
        Mockito.verify(userRepository, Mockito.times(1)).delete(user.getDNI());
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }
}