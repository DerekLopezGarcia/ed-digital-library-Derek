package com.iesam.digitallibrary.features.user.presentation;

import com.iesam.digitallibrary.features.user.data.UserDataRepository;
import com.iesam.digitallibrary.features.user.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserPresentation {
    public static void save(User user) {
        NewUserUseCase newUserUseCase = new NewUserUseCase(UserDataRepository.newInstance());
        newUserUseCase.execute(user);
    }

    public static void delete(String dni) {
        DeleteUserByDniUseCase deleteUserByDniUseCase = new DeleteUserByDniUseCase(UserDataRepository.newInstance());
        deleteUserByDniUseCase.execute(dni);
    }

    public static User get(String dni) {
        GetUserByDniUseCase getUserByDniUseCase = new GetUserByDniUseCase(UserDataRepository.newInstance());
        return getUserByDniUseCase.execute(dni);
    }

    public static void modify(User user) {
        ModifyUserUseCase modifyUserUseCase = new ModifyUserUseCase(UserDataRepository.newInstance());
        modifyUserUseCase.execute(user);
    }

    public static ArrayList<User> list() {
        ListUsersUseCase listUsersUseCase = new ListUsersUseCase(UserDataRepository.newInstance());
        return listUsersUseCase.execute();
    }

    public static void menuUsuario() {
        int option;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Crear usuario");
            System.out.println("2. Modificar usuario");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Listar usuarios");
            System.out.println("5. Volver al menú principal");
            System.out.println("Introduce una opción:");
            option = scanner.nextInt();
            switch (option) {
                case 0:
                    System.out.println("Volviendo al menú principal");
                    break;
                case 1:
                    System.out.println("Introduce el nombre del usuario");
                    String name = scanner.next();
                    System.out.println("Introduce el email del usuario");
                    String email = scanner.next();
                    System.out.println("Introduce el DNI del usuario");
                    String DNI = scanner.next();
                    User user = new User(name, email, DNI);
                    UserPresentation.save(user);
                    System.out.println("Usuario registrado correctamente");
                    break;
                case 2:
                    System.out.println("Introduce el DNI del usuario a eliminar");
                    String dni = scanner.next();
                    UserPresentation.delete(dni);
                    System.out.println("Usuario eliminado correctamente");
                    break;
                case 3:
                    System.out.println("Introduce el DNI del usuario a consultar");
                    String dni1 = scanner.next();
                    System.out.println(UserPresentation.get(dni1).toString());
                    break;
                case 4:
                    System.out.println("Introduce el dni del usuario a modificar");
                    String dni2 = scanner.next();
                    System.out.println("Introduce el nuevo nombre del usuario");
                    String name1 = scanner.next();
                    System.out.println("Introduce el nuevo email del usuario");
                    String email1 = scanner.next();
                    User user1 = new User(name1, email1, dni2);
                    UserPresentation.modify(user1);
                    System.out.println("Usuario modificado correctamente");
                    break;
                case 5:
                    System.out.println("Listado de usuarios:");
                    List<User> users = UserPresentation.list();
                    for (User user2 : users) {
                        System.out.println(user2.toString());
                    }
                    break;
            }
        }while (option != 0);
    }
}
