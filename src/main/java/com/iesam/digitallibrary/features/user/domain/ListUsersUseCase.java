package com.iesam.digitallibrary.features.user.domain;

import java.util.ArrayList;


public class ListUsersUseCase {
    private final UserRepository userRepository;

public ListUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ArrayList<User> execute() {
        return userRepository.getAll();
    }
}
