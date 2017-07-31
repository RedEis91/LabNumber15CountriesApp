import java.util.Scanner;
import java.io.*;

/**
 * Created by Jared on 7/26/17.
 */
public class CountriesApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int keepGoing;
        CountriesTextFile countries = new CountriesTextFile();
        File myFile = countries.myFile;
        System.out.println("Welcome to the Countries Maintenance Application!");
        System.out.println("What's your name?");
        String name = scan.nextLine();
        System.out.println("Hi " + name +"!");
        System.out.println("Please select option 1,2 or 3: ");
        do {
        keepGoing = menu(scan);
        if (keepGoing == 1) {
            countries.readFromFile(myFile);

        }
        if (keepGoing == 2) {
            System.out.print("Please enter a country: ");
            scan.nextLine();
            String input = scan.nextLine();
            System.out.println("You added " + input + " to the list. Thanks "+ name + "!");
            countries.writeToFile(input, myFile);

        }
        if (keepGoing < 1 || keepGoing > 3) {
            System.out.println("*Invalid selection*" + "\nPlease select 1, 2 or 3");
                keepGoing = menu(scan);
        }

        } while (keepGoing != 3);
        System.out.println("Thanks for stopping by, "+name+ "! \nSafe travels!");
    }

    private static int menu(Scanner scan) {
        int keepGoing;
        System.out.println("1. Display List of Countries ");
        System.out.println("2. Add A Country ");
        System.out.println("3. Exit");
        keepGoing = scan.nextInt();
        return keepGoing;
    }
}
