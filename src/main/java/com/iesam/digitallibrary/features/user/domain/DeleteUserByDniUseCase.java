package com.iesam.digitallibrary.features.user.domain;

public class DeleteUserByDniUseCase {
    private final UserRepository userRepository;

    public DeleteUserByDniUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(String dni) {
        userRepository.delete(dni);
    }
}
