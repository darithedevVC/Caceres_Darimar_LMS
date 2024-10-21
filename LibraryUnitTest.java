import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LibraryUnitTest {

    // This object was created to test adding books to database
    Library library;

    // These objects were created to test create a new book
    Book book1, book2, book3, book4, book5;

    // setUp method creates the database and adds three books
    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        library = new Library();

        book1 = new Book("1", "To Kill a Mockingbird", "Harper Lee");
        book2 = new Book("2", "1984", "George Orwell");
        book3 = new Book("3", "The Great Gatsby", "F. Scott Fitzgerald");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
    }

    // This unit test verifies if books have been added to the database
    @org.junit.jupiter.api.Test
    @DisplayName("Add Books to Database Test")
    void libraryTest_addBook() {

        // Create new books two and three
        book4 = new Book("4", "The Alchemist", "Paulo Coelho");
        book5 = new Book("5", "Life of Pi", "Yann Martel");

        System.out.println("**TEST:Adding Books**\nAdding books " + book4.getTitle() + " and " + book5.getTitle() + " to test database");

        // Add books four and five to library database
        library.addBook(book4);
        library.addBook(book5);

        String book4Title = book4.getTitle();
        String book5Title = book5.getTitle();

        library.printDatabase();

        // Assures books four and five are added to database
        assertEquals(book4Title, library.getBook(null, book4Title), "ERROR book 4 not added!");
        assertEquals(book5Title, library.getBook(null, book5Title), "ERROR book 5 not added!");
    }

    // This method verifies if a book is absent from the database
    private void assertAbsent(String barcode, String title) {

        if(title == null) {

            if(library.getBook(barcode, title).contains(barcode)) {
                throw new AssertionError("Error! Book with barcode #" + barcode + " has not been removed.");
            }
        } else {

            if(library.getBook(barcode, title).contains(title)) {
                throw new AssertionError("Error! " +  title + " has not been removed.");
            }
        }
    }

    // This unit test verifies if a book is removed from the database
    @Test
    @DisplayName("Remove Book in Database Using Barcode or Title Test")
    void libraryRemoveBookTest() {

        String book2Barcode = book2.getBarcodeID();
        String book3Title = book3.getTitle();

        System.out.println("**TEST:Remove Book Barcode**\nRemoving book with barcode #" + book2.getBarcodeID() + " from test database");

        library.removeBookBarcode(book2Barcode);

        System.out.println("**TEST:Remove Book Title**\nRemoving book " + book3.getTitle() + " from test database");

        library.removeBookTitle(book3Title);

        assertAbsent(book2Barcode, null);
        assertAbsent(null, book3Title);
    }

    // This unit test verifies if a book is checked out from the database
    @Test
    void checkOutBookTest() {

        System.out.println("**TEST:Checkout Book**\nChecking book " + book2.getTitle() + " out from test database");

        library.checkOutBook(book2.getTitle());

        assertNotNull(book2.getCheckOut(), "ERROR! Book was not checked out.");
    }

    // This unit test verifies if a book is checked in from the database
    @Test
    void checkInBook() {

        System.out.println("***Testing book check in by first checking out book " + book1.getTitle() + "***\n");

        library.checkOutBook(book1.getTitle());

        System.out.println("**TEST:Checkin Book**\nChecking book " + book1.getTitle() + " in to test database");

        library.checkInBook(book1.getTitle());

        assertNull(book2.getCheckOut(), "ERROR! Book was not checked in.");
    }
}