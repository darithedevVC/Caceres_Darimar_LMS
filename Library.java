import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/* 
    Darimar Caceres
    Software Development I - CEN 3024C - 14320
    10.06.24

    The class name is 'Library' and the function of this class is to run the 
    activities of the library such as create new library "database," add books, 
    print the current books in the library "database," remove book by barcode ID
    or title, and check out or check in book. 

    The overall program objective is to manage a simple console based library 
    management system where the end user(s) can add, remove, and see their 
    collection of books by importing the collection of books in txt files.
*/

public class Library {

    // This list is the "database" holding the library book collection
    private List<Book> books;

    // Creates a new "database" for books in library collection
    public Library() {

        books = new ArrayList<>();
    }

    // Adds book object to library "database"
    public void addBook(Book book) {

        books.add(book);
    }

    // Prints the current library "database" to console
    public void printDatabase() {

        System.out.println("Barcode ID: Book Title, Author\n" +
                            "-----------------------------------------");
            
        for (int i = 0; i < books.size(); i++) {

            Book book = books.get(i);
   
            System.out.println(book.getBarcodeID() + ": " + book.getTitle() + ", " + book.getAuthor() + "\n");
        }
    }

    // Removes chosen book from library "database" using book barcode
    public void removeBookBarcode(String barcodeID) {

        Iterator<Book> it = books.iterator();

        while (it.hasNext()) {

            Book book = it.next();

            if (book.getBarcodeID().equals(barcodeID)) {
                    
                it.remove();

                System.out.println(barcodeID + " has been removed.\n");

                printDatabase();
            } else {

                System.out.println("Error! " + barcodeID + " is not found.\n");
            }
            return;
        }
    }
    // Removes chosen book from library "database" using book title
    public void removeBookTitle(String title) {

        Iterator<Book> it = books.iterator();

        while (it.hasNext()) {

            Book book = it.next();

            if (book.getTitle().equalsIgnoreCase(title)) {
                    
                it.remove();

                System.out.println(title + " has been removed.\n");

                printDatabase();
            } else {

                System.out.println("Error! " + title + " is not found.\n");
            }
            return;
        }
    }
    // Checks chosen book out from library "database"
    public void checkOutBook(String title) {

        for (int i = 0; i < books.size(); i++) {

            Book book = books.get(i);

            if (book.getTitle().equalsIgnoreCase(title)) {

                if (!book.getCheckOut()) {

                    book.checkOut();
                        
                    LocalDate dueDate = LocalDate.now().plus(4, ChronoUnit.WEEKS);

                    System.out.println(title + " is checked out. Due date: " + dueDate + "\n");

                } else {

                    System.out.println("Error! " + title + " cannot be checked out or is already checked out.\n");
                }
            }
        }

        printDatabase();
    }

    // Checks chosen book in from library "database"
    public void checkInBook(String title) {

        for (int i = 0; i < books.size(); i++) {

            Book book = books.get(i);

            if (book.getTitle().equalsIgnoreCase(title)) {

                if (book.getCheckOut()) {

                    book.checkIn();

                    System.out.println(title + " is checked in.\n");

                } else {

                    System.out.println("Error! " + title + " cannot be checked in or is already checked in.\n");
                }
            }
        }

        printDatabase();
    }
}