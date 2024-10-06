/* 
    Darimar Caceres
    Software Development I - CEN 3024C - 14320
    10.06.24

    The class name is 'Book' and the function of this class is to create book objects
    using ... COMPLETE THISSSS

    The overall program objective is to manage a simple console based library 
    management system where the end user(s) can add, remove, and see their 
    collection of books by importing the collection of books in txt files.
*/

public class Book {

    private String barcodeID;
    private String title;
    private String author;
    private boolean checkOut;

    public Book(String barcodeID, String title, String author) {
        
        this.barcodeID = barcodeId;
        this.title = title;
        this.author = author;
        this.checkOut = false;
    }

    public String getBarcodeID() {
        return barcodeId;
    }

    public String getTitle() {
        return title;
    }

    public String author() {
        return author;
    }

    public void checkOut() {
        return true;
    }

    public void checkIn() {
        return false;
    }
}