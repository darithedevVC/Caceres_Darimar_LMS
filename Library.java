import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/* 
    Darimar Caceres
    Software Development I - CEN 3024C - 14320
    10.06.24

    The class name is 'Library' and the function of this class is to ... COMPLETE THISSSS

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

        // Removes chosen book from library "database"
        public void removeBookBarcode(String barcodeID) {

            Iterator<Book> it = books.iterator();

            while (it.hasNext()) {

                Book book = it.next();

                System.out.println(book.getBarcodeID() + " == " + barcodeID); //TESTING
                if (book.getBarcodeID().equals(barcodeID)) {
                //if ((book.getBarcodeID() != null) && (book.getBarcodeID() == barcodeID)) {
                    
                    it.remove();

                    System.out.println(barcodeID + " has been removed.\n");
                } else {

                    System.out.println("Error! " + barcodeID + " is not found.\n");
                }
                return;
            }
        }

        public void removeBookTitle(String title) {

            Iterator<Book> it = books.iterator();

            while (it.hasNext()) {

                Book book = it.next();

                if (book.getTitle().equals(title)) {
                    
                    it.remove();

                    System.out.println(title + " has been removed.\n");
                } else {

                    System.out.println("Error! " + title + " is not found.\n");
                }
                return;
            }
        }

        /* 
        int count = 0;
        */ 

       /* THIS ALL WILL BE MOVED TO LIBRARY
                        new File("/Users/DariTheDev/IdeaProjects/LMS/src/books.txt")
                        //THIS IS SHORT MESSAGE THAT PRINTING IS TAKING PLACE
                        

                        while (file.hasNextLine()) {

                            String book = file.nextLine();
                            books.add(count, book);
                            System.out.printf("Added: " + books.get(count) + "\n");
                            count++;
                        }*/

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

/* MOVE ALL THIS TO LIBRARY CLASS
                    //THIS CASE REMOVES BOOK BASE ON BARCODE NUMBER
                        System.out.print("Books currently in your collection: \n");

                        int counter = 0;

                        while (counter < books.size() ) {

                            System.out.printf(books.get(counter) + "\n");
                            counter++;
                        }*/
}