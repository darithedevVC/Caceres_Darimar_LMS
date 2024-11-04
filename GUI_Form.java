import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Form extends JFrame {

    private Library library;
    private Book book;
    private Main mainApp;

    private JTextField file;
    private JButton addFileButton;
    private JPanel MainPanel;
    private JButton exitButton;

    public GUI_Form () {

        setContentPane(MainPanel);
        setTitle("Simple Library Management Software");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        addFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Library library = new Library();

                String fileName = file.getText();
                Library theLibrary = library.addBooks(fileName);

                JOptionPane.showMessageDialog(GUI_Form.this, "Added Books to library.\n" + theLibrary);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new GUI_Form();
    }
}
