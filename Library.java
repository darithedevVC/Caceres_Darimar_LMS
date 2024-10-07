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

        public Library() {

            books = new ArrayList<>();
        }

        public void addBook(Book book) {

            books.add(book);
        }

        public void printDatabase() {

            System.out.println("Loading books in Library database... \n");
            System.out.println("Books currently in Library database: \n");
            System.out.println("Barcode ID: Book Title, Author\n" +
                                "-----------------------------------------");
            
            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);
                //System.out.println(book + "\n");
                System.out.println(book.getBarcodeID() + ": " + book.getTitle() + ", " + book.getAuthor() + "\n");
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

}