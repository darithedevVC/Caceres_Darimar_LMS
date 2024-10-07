
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;
//
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
    Darimar Caceres
    Software Development I - CEN 3024C - 14320
    10.06.24

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

        Library library = new Library();
        Scanner scanFile = new Scanner (System.in);

        System.out.print("\nHello and welcome!\n\nWhat would you like to do: \n1");

        boolean exit = false;

        while (!exit) {

            System.out.print("\n***(To select one please enter the corresponding number i.e. 1,2,3 etc)***\n\n");
            System.out.print(   "1. Add new books to the collection using file name.\n" + // could this erase existing books / how to handle that 
                                "2. List all books currently in the collection\n" +
                                "   Remove book from the collection using:\n" +
                                "   3. BARCODE (book removal)\n" +
                                "   4. TITLE (book removal)\n" +
                                "5. Check-out book\n" +
                                "6. Check-in book\n" +
                                "Enter '0' to exit.\n\n" +
                                "Option: ");

            Scanner option = new Scanner(System.in);

            try {
                int choice = option.nextInt();

                // switch case that corresponds to end user choice
                switch (choice) {
                    // case 1 will ask user for file name and add books to the library collection
                    case 1:

                        System.out.print("What is the file name of books you are adding to the collection?\n");
                        
                        String file = scanFile.nextLine();

                        try (BufferedReader b = new BufferedReader(new FileReader(file))) {
                            
                            System.out.println("Adding books to the collection...\n");
                            
                            String line;

                            while ((line = b.readLine()) != null) {

                                String[] book = line.split(",");

                                // If statement checks for 3 elements (Book Barcode, Title, and Author) per line
                                if (book.length == 3) {

                                    String barcodeID = book[0];
                                    String title = book[1];
                                    String author = book[2];

                                    library.addBook(new Book(barcodeID, title, author));

                                } else {

                                    System.out.println("File has invalid book format (barcodeID, Book title, Book author). Try again!\n");
                                }
                            }

                        } catch (IOException e) {
                            
                            System.out.println("Error! Error message: " + e.getMessage() + "\n");
                        }
                        
                        library.printDatabase();

                        break;
                    // case 2 will list books from the library collection "database"
                    case 2: 
                    /*  MOVE ALL THIS TO LIBRARY
                        System.out.print("Enter the id of the book you want deleted.\n");

                        int id_choice = option.nextInt();

                        // iterates through the library collection of books
                        // book is removed if book index matches users option choice
                        for (int i = 0; i < books.size(); i++) {
                            int num = id_choice - 1;
                             if (Objects.equals(books.get(num), books.get(i))) {
                                 System.out.printf(books.get(num) + " was removed.\n");
                                 books.remove(num);
                             }
                        }*/
                        break;
                    //case 3 will remove books using barcode number from the library collection
                    case 3: 
                    /* MOVE ALL THIS TO LIBRARY CLASS
                    //THIS CASE REMOVES BOOK BASE ON BARCODE NUMBER
                        System.out.print("Books currently in your collection: \n");

                        int counter = 0;

                        while (counter < books.size() ) {

                            System.out.printf(books.get(counter) + "\n");
                            counter++;
                        }*/
                        break;
                    // case 4 will remove books using the title from the library collection
                    case 4: //THIS CASE REMOVES BOOK BASE ON TITLE

                        break;
                    // case 5 will check-out books using ? number from the library collection
                    case 5: 

                        break;
                    // case 6 will check-in books using ? number from the library collection
                    case 6: 

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