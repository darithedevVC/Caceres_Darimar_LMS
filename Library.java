import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

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

        System.out.println("Barcode ID: Book Title, Author, Due Date\n" +
                            "-----------------------------------------");
            
        for (int i = 0; i < books.size(); i++) {

            Book book = books.get(i);
   
            System.out.println(book.getBarcodeID() + ": " + book.getTitle() + ", " + book.getAuthor() + ", " + book.getCheckOut() + "\n");
        }
    }

    // Removes chosen book from library "database" using book barcode
    public void removeBookBarcode(String barcodeID) {

        Iterator<Book> it = books.iterator();

        while (it.hasNext()) {

            Book book = it.next();

            if (book.getBarcodeID().equals(barcodeID)) {
                    
                it.remove();

                System.out.println("Book with barcode #" + barcodeID + " has been removed.\n");

                printDatabase();

                return;

            }
        }

        System.out.println("Error! Book barcode #" + barcodeID + " is not found.\n");
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

                return;

            }
        }

        System.out.println("Error! " + title + " is not found.\n");
    }
    // Checks chosen book out from library "database"
    public void checkOutBook(String title) {

        for (int i = 0; i < books.size(); i++) {

            Book book = books.get(i);

            if (book.getTitle().equalsIgnoreCase(title)) {

                if (book.getCheckOut() == null) {

                    String due = book.checkOut();

                    System.out.println(title + " is checked out. Due date: " + due + "\n");

                } else {

                    String due = book.checkOut();

                    System.out.println("Error! " + title + " cannot be checked out or is already checked out. Due date: " + due + "\n");
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

                if (book.getCheckOut() != null) {

                    String due = book.checkIn();

                    System.out.println(title + " is checked in. Due date: " + due + "\n");

                } else {

                    String due = book.checkIn();

                    System.out.println("Error! " + title + " cannot be checked in or is already checked in. Due date: " + due + "\n");
                }
            }
        }

        printDatabase();
    }

    // Added getter for unit testing
    public String getBook(String barcodeID, String title) {

        for (int i = 0; i < books.size(); i++) {

            if ((barcodeID == null) && books.get(i).getTitle().equals(title)) {

                return books.get(i).getTitle();
            } else if ((title == null) && books.get(i).getBarcodeID().equals(barcodeID)) {

                return books.get(i).getBarcodeID();
            }
        }
        return ""; // Returns "" string because error is thrown when null
    }
}