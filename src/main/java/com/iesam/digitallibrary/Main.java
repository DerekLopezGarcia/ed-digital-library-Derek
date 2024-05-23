package com.iesam.digitallibrary;

import com.iesam.digitallibrary.features.book.domain.Book;
import com.iesam.digitallibrary.features.book.presentation.BookPresentation;
import com.iesam.digitallibrary.features.loan.domain.Loan;
import com.iesam.digitallibrary.features.loan.presentation.LoanPresentation;
import com.iesam.digitallibrary.features.user.domain.User;
import com.iesam.digitallibrary.features.user.presentation.UserPresentation;

import java.util.List;
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
                    int option2;
                    do {
                        menuUsuario();
                        option2 = scanner.nextInt();
                        switch (option2) {
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
                    } while (option2 != 0);
                    break;
                case 2:
                    int option3;
                    do {
                        menuLibro();
                        option3 = scanner.nextInt();
                        switch (option3) {
                            case 0:
                                System.out.println("Volviendo al menú principal");
                                break;
                            case 1:
                                System.out.println("Introduce el título del libro");
                                String title = scanner.next();
                                System.out.println("Introduce el autor del libro");
                                String author = scanner.next();
                                System.out.println("Introduce el ISBN del libro");
                                String ISBN = scanner.next();
                                System.out.println("Introduce la editorial del libro");
                                String editorial = scanner.next();
                                System.out.println("Introduce el año del libro");
                                int year = scanner.nextInt();
                                Book book = new Book(title, author, ISBN, editorial, year);
                                BookPresentation.saveBook(book);
                                System.out.println("Libro registrado correctamente");
                                break;
                            case 2:
                                System.out.println("Introduce el ISBN del libro a eliminar");
                                String ISBN0 = scanner.next();
                                BookPresentation.deleteBook(ISBN0);
                                System.out.println("Libro eliminado correctamente");
                                break;
                            case 3:
                                System.out.println("Introduce el ISBN del libro a consultar");
                                String ISBN2 = scanner.next();
                                System.out.println(BookPresentation.getBook(ISBN2).toString());
                                break;
                            case 4:
                                System.out.println("Introduce el título del libro");
                                String title1 = scanner.next();
                                System.out.println("Introduce el autor del libro");
                                String author1 = scanner.next();
                                System.out.println("Introduce el ISBN del libro");
                                String ISBN1 = scanner.next();
                                System.out.println("Introduce la editorial del libro");
                                String editorial1 = scanner.next();
                                System.out.println("Introduce el año del libro");
                                int year1 = scanner.nextInt();
                                Book book1 = new Book(title1, author1, ISBN1, editorial1, year1);
                                BookPresentation.updateBook(book1);
                                System.out.println("Libro modificado correctamente");
                                break;
                            case 5:
                                System.out.println("Listado de libros:");
                                List<Book> books = BookPresentation.getAllBooks();
                                for (Book book2 : books) {
                                    System.out.println(book2.toString());
                                }
                                break;
                        }
                    } while (option3 != 0);
                    break;
                case 3:
                    int option4;
                    do {

                        menuPrestamo();
                        option4 = scanner.nextInt();
                        switch (option4) {
                            case 0:
                                System.out.println("Volviendo al menú principal");
                                break;
                            case 1:
                                System.out.println("Crear préstamo");
                                System.out.println("Introduce el ID del préstamo");
                                String id0 = scanner.next();
                                System.out.println("Introduce el DNI del usuario");
                                String userDNI = scanner.next();
                                System.out.println("Introduce el ISBN del libro");
                                String bookISBN = scanner.next();
                                System.out.println("Introduce la fecha de préstamo");
                                String date = scanner.next();
                                System.out.println("Introduce la fecha de devolución");
                                String returnDate = scanner.next();
                                Loan loan = new Loan(id0, userDNI, bookISBN, date, returnDate, false);
                                LoanPresentation.createLoan(loan);
                                System.out.println("Préstamo creado correctamente");
                                break;
                            case 2:
                                System.out.println("Introduce el ID del préstamo a eliminar");
                                String id = scanner.next();
                                LoanPresentation.deleteLoan(id);
                                System.out.println("Préstamo eliminado correctamente");
                                break;
                            case 3:
                                System.out.println("Introduce el ID del préstamo a consultar");
                                String id1 = scanner.next();
                                System.out.println(LoanPresentation.getLoan(id1).toString());
                                break;
                            case 4:
                                System.out.println("Introduce el ID del préstamo a modificar");
                                String id2 = scanner.next();
                                System.out.println("Introduce el DNI del usuario");
                                String userDNI1 = scanner.next();
                                System.out.println("Introduce el ISBN del libro");
                                String bookISBN1 = scanner.next();
                                System.out.println("Introduce la fecha de préstamo");
                                String date1 = scanner.next();
                                System.out.println("Introduce la fecha de devolución");
                                String returnDate1 = scanner.next();
                                Loan loan1 = new Loan(id2, userDNI1, bookISBN1, date1, returnDate1, false);
                                LoanPresentation.updateLoan(loan1);
                                System.out.println("Préstamo modificado correctamente");
                                break;
                            case 5:
                                System.out.println("Listado de préstamos:");
                                List<Loan> loans = LoanPresentation.list();
                                for (Loan loan2 : loans) {
                                    System.out.println(loan2.toString());
                                }
                                break;
                            case 6:
                                System.out.println("Listado de préstamos no finalizados:");
                                List<Loan> loans1 = LoanPresentation.listUnfinished();
                                for (Loan loan3 : loans1) {
                                    System.out.println(loan3.toString());
                                }
                                break;
                            case 7:
                                System.out.println("Listado de préstamos finalizados:");
                                List<Loan> loans2 = LoanPresentation.listFinished();
                                for (Loan loan4 : loans2) {
                                    System.out.println(loan4.toString());
                                }
                                break;
                        }
                    } while (option4 != 0);
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

    public static void menuUsuario() {
        System.out.println("MENÚ DE USUARIO");
        System.out.println("0. Volver al menú principal");
        System.out.println("1. Registrar usuario");
        System.out.println("2. Eliminar usuario");
        System.out.println("3. Consultar usuario");
        System.out.println("4. Modificar usuario");
        System.out.println("5. Listar usuarios");
        System.out.println("Introduce una opción:");
    }

    public static void menuLibro() {
        System.out.println("MENÚ DE LIBRO");
        System.out.println("0. Volver al menú principal");
        System.out.println("1. Registrar libro");
        System.out.println("2. Eliminar libro");
        System.out.println("3. Consultar libro");
        System.out.println("4. Modificar libro");
        System.out.println("5. Listar libros");
        System.out.println("Introduce una opción:");
    }

    public static void menuPrestamo() {
        System.out.println("MENÚ DE PRÉSTAMO");
        System.out.println("0. Volver al menú principal");
        System.out.println("1. Crear préstamo");
        System.out.println("2. Eliminar préstamo");
        System.out.println("3. Consultar préstamo");
        System.out.println("4. Modificar préstamo");
        System.out.println("5. Listar préstamos");
        System.out.println("6. Listar préstamos no finalizados");
        System.out.println("7. Listar préstamos finalizados");
        System.out.println("Introduce una opción:");
    }
}