package ui;
import model.Customer;

import java.util.Scanner;


public class BankStart {
    public static String[] args;


    // ready set go the ting.
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("What is your first name: ");
        String firstName = reader.nextLine();
        System.out.print("What is your last name: ");
        String lastName = reader.nextLine();
        System.out.print("What is your age: ");
        int age = reader.nextInt();

        if (age >= 19) {
            System.out.println("Hello " + firstName + " " + lastName + ", welcome to the CPSC210 Bank of UBC.");
            createCustomer(firstName + " " + lastName, age);

        } else {
            message();
        }
    }



    // REQUIRES: a name and age of the new customer
    // EFFECTS: creates a new customer with given age and name, allows for control of account
    private static void createCustomer(String name, int age) {
        Customer user = new Customer(name, age);
        user.userChoice();

    }


    // EFFECTS: displays error message
   private static void message() {
       System.out.println("Sorry, you seem to be under the age of majority in this province. " +
               "Please come back with your parent or guardian.");
   }



    public static String[] getArgs() {
      return args;
    }
}




