package com.iesam.digitallibrary.features.loan.presentation;

import com.iesam.digitallibrary.features.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.features.loan.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoanPresentation {
    public static void createLoan(Loan loan) {
        CheckIfLoanPosibleUseCase checkIfLoanPosibleUseCase = new CheckIfLoanPosibleUseCase(LoanDataRepository.newInstance());
        checkIfLoanPosibleUseCase.execute(loan.getBookISBN());
        CreateLoanUseCase createLoanUseCase = new CreateLoanUseCase(LoanDataRepository.newInstance());
        createLoanUseCase.execute(loan);
    }
    public static void deleteLoan(String id) {
        DeleteLoanUseCase deleteLoanUseCase = new DeleteLoanUseCase(LoanDataRepository.newInstance());
        deleteLoanUseCase.execute(id);
    }
    public static Loan getLoan(String id) {
        GetLoanByIdUseCase getLoanByIdUseCase = new GetLoanByIdUseCase(LoanDataRepository.newInstance());
        return getLoanByIdUseCase.execute(id);
    }
    public static ArrayList<Loan> list() {
        GetAllLoanUseCase getAllLoanUseCase = new GetAllLoanUseCase(LoanDataRepository.newInstance());
        return getAllLoanUseCase.execute();
    }
    public static void updateLoan(Loan loan) {
        ModifyLoanByIdUseCase modifyLoanByIdUseCase = new ModifyLoanByIdUseCase(LoanDataRepository.newInstance());
        modifyLoanByIdUseCase.execute(loan);
    }
    public static ArrayList<Loan> listUnfinished() {
        GetUnfinishedLoansUseCase getUnfinishedLoansUseCase = new GetUnfinishedLoansUseCase(LoanDataRepository.newInstance());
        return getUnfinishedLoansUseCase.execute();
    }
    public static ArrayList<Loan> listFinished() {
        GetFinishedLoansUseCase getFinishedLoansUseCase = new GetFinishedLoansUseCase(LoanDataRepository.newInstance());
        return getFinishedLoansUseCase.execute();
    }
    public static void LoanMenu() {
        int option;
        Scanner scanner = new Scanner(System.in);
        do {
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
            option = scanner.nextInt();
            switch (option) {
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
        } while (option != 0);

        }while (option != 0);
    }
}
