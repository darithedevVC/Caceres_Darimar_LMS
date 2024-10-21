/* 
    Darimar Caceres
    Software Development I - CEN 3024C - 14320
    10.06.24

    The class name is 'Book' and the function of this class is to create book objects
    with strings for Barcode ID, title, and author, and a String for checkOut that is either null
    or has the due date. The Book class has a public object method that assigns the barcode id,
    title, author, and check out. The following functions three return their corresponding
    barcode ID, title, and author name. While the String getCheckOut function returns null or
    due date corresponding to the checkOut (due date) and checkIn (null) functions.

    The overall program objective is to manage a simple console based library 
    management system where the end user(s) can add, remove, and see their 
    collection of books by importing the collection of books in txt files.
*/

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Book {

    private String barcodeID;
    private String title;
    private String author;
    private String checkOut;

    // This object method gets the barcodeID, book title, and book author name
    // then returns the barcode ID, title, and author, while also returning 
    // String for book check out status as null or local due date.
    public Book(String barcodeID, String title, String author) {
        
        this.barcodeID = barcodeID;
        this.title = title;
        this.author = author;
        this.checkOut = null;
    }

    public String getBarcodeID() {
        return barcodeID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public String checkOut() {

        LocalDate dueDate = LocalDate.now().plus(4, ChronoUnit.WEEKS);

        return checkOut = dueDate.toString();
    }

    public String checkIn() {

        return checkOut = null;
    }
}