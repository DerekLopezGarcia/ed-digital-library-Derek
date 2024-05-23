package com.iesam.digitallibrary.features.book.presentation;

import com.iesam.digitallibrary.features.book.data.BookDataRepository;
import com.iesam.digitallibrary.features.book.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

;

public class BookPresentation {

    public static void saveBook(Book book) {
        SaveBookUseCase saveBookUseCase = new SaveBookUseCase(BookDataRepository.newInstance());
        saveBookUseCase.execute(book);
    }

    public static void deleteBook(String isbn) {
        DeleteBookUseCase deleteBookUseCase = new DeleteBookUseCase(BookDataRepository.newInstance());
        deleteBookUseCase.execute(isbn);
    }

    public static Book getBook(String isbn) {
        GetBookByIsbnUseCase getBookByIsbnUseCase = new GetBookByIsbnUseCase(BookDataRepository.newInstance());
        return getBookByIsbnUseCase.execute(isbn);
    }

    public static void updateBook(Book book) {
        ModifyBookUseCase modifyBookUseCase = new ModifyBookUseCase(BookDataRepository.newInstance());
        modifyBookUseCase.execute(book);
    }

    public static ArrayList<Book> getAllBooks() {
        GetAllBookUseCase getAllBookUseCase = new GetAllBookUseCase(BookDataRepository.newInstance());
        return getAllBookUseCase.execute();
    }

    public static void BookMenu() {
        int option;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("MENÚ DE LIBRO");
            System.out.println("0. Volver al menú principal");
            System.out.println("1. Registrar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Consultar libro");
            System.out.println("4. Modificar libro");
            System.out.println("5. Listar libros");
            System.out.println("Introduce una opción:");
            option = scanner.nextInt();
            switch (option) {
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
        } while (option != 0);
    }

}
