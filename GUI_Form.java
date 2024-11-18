import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

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

    public GUI_Form () {

        setContentPane(mainPanel);
        setTitle("Simple Library Management Software");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 350);
        setLocationRelativeTo(null);
        setVisible(true);

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

        displayDBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayDatabaseWindow();
            }
        });

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

        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookOut = checkOutText.getText();
                library.checkOutBook(bookOut);

                JOptionPane.showMessageDialog(GUI_Form.this,bookOut + " is checked out.\n");

            }
        });

        checkInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookIn = checkInText.getText();
                library.checkInBook(bookIn);

                JOptionPane.showMessageDialog(GUI_Form.this,bookIn + " is checked in. \n");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

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

    public static void main(String[] args) {
        new GUI_Form();

        JFrame frame = new JFrame("Library Books Database");
        frame.setContentPane(new GUI_Form());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
