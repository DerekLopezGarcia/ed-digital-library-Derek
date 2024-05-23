package com.iesam.digitallibrary;

import com.iesam.digitallibrary.features.book.presentation.BookPresentation;
import com.iesam.digitallibrary.features.loan.presentation.LoanPresentation;
import com.iesam.digitallibrary.features.user.presentation.UserPresentation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            menuprincipal();
            option = scanner.nextInt();
            switch (option) {
                case 0:
                    System.out.println("Saliendo del programa");
                    break;
                case 1:
                    UserPresentation.menuUsuario();
                    break;
                case 2:
                    BookPresentation.BookMenu();
                    break;
                case 3:
                    LoanPresentation.LoanMenu();
                    break;
            }
        } while (option != 0);
        scanner.close();
    }

    public static void menuprincipal() {
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("0. Salir");
        System.out.println("1. Menu de usuario");
        System.out.println("2. Menu de libro");
        System.out.println("3. Menu de préstamo");
        System.out.println("Introduce una opción:");
    }
}