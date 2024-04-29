package com.iesam.digitallibrary.features.user.domain;

public class GetUserByDniUseCase {
    private final UserRepository userRepository;

    public GetUserByDniUseCase(UserRepository userRepository){this.userRepository = userRepository;}

    public User execute (String dni){
        return userRepository.get(dni);
    }

}
