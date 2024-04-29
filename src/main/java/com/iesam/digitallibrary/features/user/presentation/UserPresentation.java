package com.iesam.digitallibrary.features.user.presentation;

import com.iesam.digitallibrary.features.user.data.UserDataRepository;
import com.iesam.digitallibrary.features.user.domain.*;

public class UserPresentation {
    public static void save(User user){
        NewUserUseCase newUserUseCase = new NewUserUseCase(UserDataRepository.newInstance());
        newUserUseCase.execute(user);
    }
    public static void delete(String dni){
        DeleteUserByDniUseCase deleteUserByDniUseCase = new DeleteUserByDniUseCase(UserDataRepository.newInstance());
        deleteUserByDniUseCase.execute(dni);
    }
    public static User  get (String dni){
        GetUserByDniUseCase getUserByDniUseCase = new GetUserByDniUseCase(UserDataRepository.newInstance());
       return getUserByDniUseCase.execute(dni);
    }
    public static void modify(User user){
        ModifyUserUseCase modifyUserUseCase = new ModifyUserUseCase(UserDataRepository.newInstance());
        modifyUserUseCase.execute(user);
    }
    public static void list(){
        ListUsersUseCase listUsersUseCase = new ListUsersUseCase(UserDataRepository.newInstance());
        listUsersUseCase.execute();
    }
}
