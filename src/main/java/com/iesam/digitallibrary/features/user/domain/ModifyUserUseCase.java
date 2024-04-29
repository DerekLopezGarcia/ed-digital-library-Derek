package com.iesam.digitallibrary.features.user.domain;

public class ModifyUserUseCase {
private final UserRepository userRepository;

public ModifyUserUseCase(UserRepository userRepository){this.userRepository = userRepository;}

    public void  execute (User user){
        userRepository.delete(user.getDNI());
        userRepository.save(user);
    }
}
