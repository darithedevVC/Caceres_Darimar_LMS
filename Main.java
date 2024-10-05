
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/*
    Darimar Caceres
    Software Development I - CEN 3024C - 14320
    09.08.24

    The class name is 'Main' and the function of this class is to prompt the user 
    with 3 choices in an endless while loop until the user chooses '0' to exit. 
    The three choices corresponds to maintaining and accessing this simple Library 
    Management Software.

    The overall program objective is to manage a simple console based library 
    management system where the end user(s) can add, remove, and see their 
    collection of books by importing the collection of books in txt files.
*/

public class Main {

    public static void main(String[] args) {

        System.out.print("Hello and welcome!\nWhat would you like to do: ");

        boolean exit = false;
        int count = 0;

        List<String> books = new ArrayList<String>();

        while (!exit) {

            System.out.print("\n***(To select one please enter the corresponding number i.e. 1,2,3 etc)***\n\n");
            System.out.print(   "1. Add new books to the collection.\n" +
                                "2. Remove book from the collection.\n" +
                                "3. List all books currently in the collection\n" +
                                "Enter '0' to exit.\n\n" +
                                "Option: ");

            Scanner input = new Scanner(System.in);

            try {
                int choice = input.nextInt();

                // switch case that corresponds to end user choice
                switch (choice) {
                    // case 1 will add books to the library collection
                    case 1:
                        System.out.print("Adding books to the collection...\n");

                        Scanner file = new Scanner (new File("/Users/DariTheDev/IdeaProjects/LMS/src/books.txt"));

                        while (file.hasNextLine()) {

                            String book = file.nextLine();
                            books.add(count, book);
                            System.out.printf("Added: " + books.get(count) + "\n");
                            count++;
                        }
                        break;
                    // case 2 will remove books from the library collection
                    case 2:
                        System.out.print("Enter the id of the book you want deleted.\n");

                        int id_choice = input.nextInt();

                        // iterates through the library collection of books
                        // book is removed if book index matches users input choice
                        for (int i = 0; i < books.size(); i++) {
                            int num = id_choice - 1;
                             if (Objects.equals(books.get(num), books.get(i))) {
                                 System.out.printf(books.get(num) + " was removed.\n");
                                 books.remove(num);
                             }
                        }
                        break;
                    // case 3 will list the books currently in the library collection
                    case 3:
                        System.out.print("Books currently in your collection: \n");

                        int counter = 0;

                        while (counter < books.size() ) {

                            System.out.printf(books.get(counter) + "\n");
                            counter++;
                        }
                        break;
                    // exits program
                    case 0:
                        System.out.print("Exiting.\n");
                        exit = true;
                        break;
                    default:
                        System.out.print("Error! Please choose a valid option.\n");
                }
            } catch (Exception e) {
                System.out.print("Error! not a valid option.\n");
            }
        }
    }
}