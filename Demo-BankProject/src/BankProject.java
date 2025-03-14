import java.util.ArrayList;
import java.util.Scanner;

public class BankProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Vid Bank");
    loop1:  while (true) {
            UserMenuDetails.starterMenu();
            int userOptions = scanner.nextInt();
            switch (userOptions) {
                case 1:
                    long startTime = System.nanoTime();
                    UserDetails.users.insertBulk(UserDetails.userIds, UserDetails.userNames);
                    UserDetails.users.printAll();
                    long endTime = System.nanoTime();
                    System.out.println("Time taken - " + (endTime - startTime));
                    break;
                case 2:
                loop2:  while (true) {
                        UserMenuDetails.balanceMenu();
                        userOptions = scanner.nextInt();
                        switch (userOptions) {
                            case 1:
                                System.out.println("Enter the User ID");
                                long userId = scanner.nextLong();
                                scanner.nextLine();
                                UsersBalance.foundIt(userId);
                                break;
                            case 2:
                                UsersBalance.loadAllDetails();
                                break;
                            case 0:
                                break loop2;
                            default:
                                System.out.println("\nProvide an valid input\n");

                        }
                    }
                    break;
                case 3:
                loop3:  while (true) {
                        System.out.println("Enter the User-ID");
                        long userId = scanner.nextLong();
                        scanner.nextLine();
                        boolean haveLoan = UsersLoan.foundUserLoan(userId);
                        if (haveLoan) {
                        loop4:  while (true) {
                                UserMenuDetails.LoanMenu();
                                userOptions = scanner.nextInt();
                                switch (userOptions) {
                                    case 1:
                                        startTime = System.nanoTime();
                                        UsersLoan.foundLoanName(userId);
                                        endTime = System.nanoTime();
                                        System.out.println("Time taken - " + (endTime - startTime));
                                        break;
                                    case 2:
                                        UsersLoan.foundLoanAmount(userId);
                                        break;
                                    case 3:
                                        UsersLoan.foundDueAmount(userId);
                                        break;
                                    case 4:
                                        UsersLoan.foundLoanStartDate(userId);
                                        break;
                                    case 5:
                                        UsersLoan.foundLoanEndDate(userId);
                                        break;
                                    case 6:
                                        startTime = System.nanoTime();
                                        UsersLoan.foundCompleteLoanInfo(userId);
                                        endTime = System.nanoTime();
                                        System.out.println("Time taken - " + (endTime - startTime));
                                        break;
                                    case 0:
                                        break loop3;
                                    default:
                                        System.out.println("\nProvide an valid input\n");
                                }
                            }
                        }
                        break loop3;
                }
                    break;
                case 0:
                    break loop1;
                default:
                    System.out.println("\nProvide an valid input\n");
            }
        }
    }
}