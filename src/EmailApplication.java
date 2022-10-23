import Model.Account;

import java.util.Scanner;

public class EmailApplication {


    public static Account[] account = new Account[1000];
    public static Scanner scanner;
    public static Account currentAccount = null;


    public static void main(String[] args) {

        account[0] = new Account("Anvar", "Olimov", "olimovanvar@gmail.com", "parol");
        account[1] = new Account("User", "Userov", "email", "parol");
        account[2] = new Account("User", "Userov", "1", "1");

        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("--------Email App----------");
            System.out.println("1.Login");
            System.out.println("2.Register");
            System.out.println("3.All Email");
            System.out.println("0.Exit");

            int choise = scanner.nextInt();

            switch (choise) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    showUserList();
                    break;
                case 4:
                    break;
                case 0:
                    System.out.println("------- Thank you! --------");
                    return;

            }

        }

    }

    private static void showUserList() {
        for (Account account1 : account) {
            if (account1 != null) {
                System.out.println(account1.toString());
            }
        }
    }

    private static void register() {
        System.out.print("Ismingiz:  ");
        String firstName = scanner.nextLine();
        System.out.print("Familiyangiz:  ");
        String lastName = scanner.next();
        System.out.print("Email:  ");
        String email = scanner.next();
        System.out.print("Parolingiz: ");
        String password = scanner.next();
        int cnt = 1;
        for (Account account : account) {
            cnt++;
            if (account == null) {
                break;
            }
        }
        account[cnt] = new Account(firstName, lastName, email, password);
    }

    private static void login() {
        scanner = new Scanner(System.in);

        System.out.print("email: ");
        String email = scanner.nextLine();
        System.out.print("password: ");
        String password = scanner.nextLine();

        if (chekEmail(email, password)) {
            initCurrentAccount(email);
            showDashboard();
        } else {
            System.out.println("Something went wrong!");
        }
    }

    private static void initCurrentAccount(String email) {
        for (Account account : account) {
            if (account != null && account.getEmail().equals(email)) {
                currentAccount = account;
                break;
            }
        }
    }


    private static boolean chekEmail(String email, String password) {
        for (Account account : account) {
            if (account != null) {
                if (account.getEmail().equals(email) && account.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }


    private static void showDashboard() {

        dashboard:
        System.out.println("\n\t" + currentAccount.getFirstName()
                + " " + currentAccount.getLastName() + "\t\t" + currentAccount.getEmail());
        System.out.println("1.New Message");
        System.out.println("2.Unread");
        System.out.println("3.Inbox");
        System.out.println("4.Outbox");
        System.out.println("5.Change password");
        System.out.println("6.Log out");
        System.out.println("0.Exit");

        int choise = scanner.nextInt();
        switch (choise) {
            case 1:
                newMessage();
                break;
            case 2:
                break;
            case 3:
                inboxMessage();
                break;
            case 4:
                break;
            case 5:
                changePassword();
                break;
            case 6:
                logOut();
                return;
            default:
                System.out.println("Biz boshqa amallarni keyingi versiyada qo`shamiz!");
        }
    }

    private static void inboxMessage() {
        for (Account account : account) {
            if (account != null && account.getEmail().equals(currentAccount.getEmail())) {
                for (account.getInbox()) ;

            }
        }
        showDashboard();
    }

    private static void newMessage() {
        scanner = new Scanner(System.in);
        for (Account account : account) {
            if (account != null) {
                System.out.println(account.getEmail());
            }
        }
        System.out.print("To: ");
        String receiver = scanner.next();
        Account receiverAccount = null;
        for (Account account : account) {
            if (account != null) {
                if (account.getEmail().equals(receiver)) {
                    receiverAccount = account;
                    break;
                }
            }
        }
        if (receiverAccount != null) {
            System.out.println("Title: ");
            scanner = new Scanner(System.in);
            String title = scanner.nextLine();

            System.out.println("Message: ");
            scanner = new Scanner(System.in);
            String message = scanner.nextLine();


            showDashboard();
        }

    }

    private static void logOut() {
        currentAccount = null;
    }

    private static void changePassword() {
        System.out.print("Eski parolni Kiriting: ");
        String oldPassword = scanner.next();
        if (currentAccount.getPassword().equals(oldPassword)) {
            System.out.print("Yangi parolni kiriting:  ");
            String newPassword = scanner.next();
            currentAccount.setPassword(newPassword);
            showDashboard();
        }
    }


}
