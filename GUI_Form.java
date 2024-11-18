import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/*
    Darimar Caceres
    Software Development I - CEN 3024C - 14320
    11.03.24

    The function of the 'GUI_Form' class is to create a GUI Form that the  user can
    interact with. There are seven choices the user can choose from. The seven choices
    corresponds to maintaining and accessing this simple Library Management Software.

    The overall program objective is to manage a simple console based library
    management system where the end user(s) can add, remove, and see their
    collection of books by importing the collection of books in txt files.
*/

public class GUI_Form extends JFrame {

    private Library library;
    private List<Book> books;

    private JTextField fileText;
    private JButton addFileButton;
    private JPanel mainPanel;
    private JButton exitButton;
    private JButton displayDBButton;
    private JButton removeBarcodeButton;
    private JTextField removeBarcodeText;
    private JTextField removeTitleText;
    private JTextField checkOutText;
    private JButton checkOutButton;
    private JTextField checkInText;
    private JButton checkInButton;
    private JButton removeTitleButton;

    // This form is the GUI the user will see
    public GUI_Form () {

        setContentPane(mainPanel);
        setTitle("Simple Library Management Software");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 350);
        setLocationRelativeTo(null);
        setVisible(true);

        // Adds the text file to the 'database' when button is clicked
        addFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                library = new Library();

                String fileName = fileText.getText();
                library = library.addBooks(fileName);

                if(!library.error) {
                    JOptionPane.showMessageDialog(GUI_Form.this, "Added Books to library.\n");
                } else {
                    JOptionPane.showMessageDialog(GUI_Form.this, "Error! No file was given. \n");
                }
            }
        });

        // Displays the books in the 'database' in a new window when button is clicked
        displayDBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayDatabaseWindow();
            }
        });

        // Removes a book from the 'database' using the barcode ID number when button is clicked
        removeBarcodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String barcodeNumber = removeBarcodeText.getText();
                library.removeBookBarcode(barcodeNumber);

                if(books.contains(barcodeNumber)) {
                    JOptionPane.showMessageDialog(GUI_Form.this,"Error! Book with barcode #" + barcodeNumber + " has not been removed.");
                } else {
                    JOptionPane.showMessageDialog(GUI_Form.this, "Book with barcode #" + barcodeNumber + " has been removed. \n");
                }
            }
        });

        // Removes a book from the 'database' using the book title when button is clicked
        removeTitleButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String title = removeTitleText.getText();
                library.removeBookTitle(title);

                if(books.contains(title)) {
                    JOptionPane.showMessageDialog(GUI_Form.this,"Error! Book with title: " + title + " has not been removed.");
                } else {
                    JOptionPane.showMessageDialog(GUI_Form.this, "Book with title: " + title + " has been removed. \n");
                }
            }
        });

        // Checks out a book from the 'database' using the book title when button is clicked
        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookOut = checkOutText.getText();
                library.checkOutBook(bookOut);

                JOptionPane.showMessageDialog(GUI_Form.this,bookOut + " is checked out.\n");

            }
        });

        // Checks in a book from the 'database' using the book title when button is clicked
        checkInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookIn = checkInText.getText();
                library.checkInBook(bookIn);

                JOptionPane.showMessageDialog(GUI_Form.this,bookIn + " is checked in. \n");
            }
        });

        // Exits from program when button is clicked
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    // Creates the new pop-up window when display database button is clicked
    private void displayDatabaseWindow() {
        books = library.booksGUIDisplay();

        JFrame frame = new JFrame("Library Books Database");

        JTextArea text = new JTextArea();
        text.setEditable(false);

        for (Book book : books) {
            text.append(book.getBarcodeID() + ": " + book.getTitle() + ", " + book.getAuthor() + ", " + book.getCheckOut() + "\n");
        }

        frame.add(new JScrollPane(text));

        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Main
    public static void main(String[] args) {
        new GUI_Form();

        JFrame frame = new JFrame("Library Books Database");
        frame.setContentPane(new GUI_Form());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
