package com.iesam.digitallibrary;

import java.util.List;
import java.util.Scanner;

import com.iesam.digitallibrary.features.book.domain.Book;
import com.iesam.digitallibrary.features.book.presentation.BookPresentation;
import com.iesam.digitallibrary.features.user.domain.User;
import com.iesam.digitallibrary.features.user.presentation.UserPresentation;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("0. Salir");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Eliminar usuario");
            System.out.println("3. Consultar usuario");
            System.out.println("4. Modificar usuario");
            System.out.println("5. Listar usuarios");
            System.out.println("6. Registrar libro");
            System.out.println("7. Eliminar libro");
            System.out.println("8. Consultar libro");
            System.out.println("9. Modificar libro");
            System.out.println("10. Listar libros");
            System.out.println("Introduce una opción:");

            option = scanner.nextInt();
            switch (option) {
                case 0:
                    System.out.println("Saliendo del programa");
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
                case 6:
                    // Pide los datos para Guardar un libro basado en la clase Book
                    System.out.println("Introduce el ISBN del libro");
                    String isbn = scanner.next();
                    System.out.println("Introduce el título del libro");
                    String title = scanner.next();
                    System.out.println("Introduce el autor del libro");
                    String author = scanner.next();
                    System.out.println("Introduce el año de publicación del libro");
                    int year = scanner.nextInt();
                    System.out.println("Introduce la editorial del libro");
                    String editorial = scanner.next();
                    Book book = new Book(title, author, isbn, editorial, year);
                    BookPresentation.saveBook(book);
                    System.out.println("Libro registrado correctamente");
                    break;
                case 7:
                    System.out.println("Introduce el ISBN del libro a eliminar");
                    String isbn1 = scanner.next();
                    BookPresentation.deleteBook(isbn1);
                    System.out.println("Libro eliminado correctamente");
                    break;
                case 8:
                    System.out.println("Introduce el ISBN del libro a consultar");
                    String isbn2 = scanner.next();
                    System.out.println(BookPresentation.getBook(isbn2).toString());
                    break;
                case 9:
                    System.out.println("Introduce el ISBN del libro a modificar");
                    String isbn3 = scanner.next();
                    System.out.println("Introduce el nuevo título del libro");
                    String title1 = scanner.next();
                    System.out.println("Introduce el nuevo autor del libro");
                    String author1 = scanner.next();
                    System.out.println("Introduce el nuevo año de publicación del libro");
                    int year1 = scanner.nextInt();
                    System.out.println("Introduce la nueva editorial del libro");
                    String editorial1 = scanner.next();
                    Book book1 = new Book(title1, author1, isbn3, editorial1, year1);
                    BookPresentation.updateBook(book1);
                    System.out.println("Libro modificado correctamente");
                    break;
                case 10:
                    System.out.println("Listado de libros:");
                    List<Book> books = BookPresentation.getAllBooks();
                    for (Book book2 : books) {
                        System.out.println(book2.toString());
                    }
                    break;

            }
        } while (option != 0);
        scanner.close();
    }
}