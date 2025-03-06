import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LibraryFrontPage extends JFrame 
{
    private LibraryOperations libraryOps;

    public LibraryFrontPage()
    {
        libraryOps = new LibraryOperations();

        setTitle("Library Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(50, 115, 220));

        JLabel titleLabel = new JLabel("Library Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(120, 30, 400, 30);
        panel.add(titleLabel);

        JButton addBookBtn = new JButton("Add Book");
        addBookBtn.setBounds(200, 100, 200, 40);
        panel.add(addBookBtn);

        JButton viewBookBtn = new JButton("View Books");
        viewBookBtn.setBounds(200, 150, 200, 40);
        panel.add(viewBookBtn);

        JButton borrowReturnBtn = new JButton("Borrow/Return");
        borrowReturnBtn.setBounds(200, 200, 200, 40);
        panel.add(borrowReturnBtn);

        JButton exitBtn = new JButton("Exit");
        exitBtn.setBounds(200, 250, 200, 40);
        exitBtn.setBackground(Color.RED);
        exitBtn.setForeground(Color.WHITE);
        panel.add(exitBtn);

        // Add Action Listeners
        addBookBtn.addActionListener(e -> addBookForm());
        viewBookBtn.addActionListener(e -> libraryOps.viewBooks());
        borrowReturnBtn.addActionListener(e -> borrowBookForm());

        exitBtn.addActionListener(e -> System.exit(0));

        add(panel);
        setVisible(true);
    }

    // Form to Add a Book
    private void addBookForm() {
        JTextField idField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        JTextField quantityField = new JTextField();

        Object[] fields = {
            "Book ID:", idField,
            "Title:", titleField,
            "Author:", authorField,
            "Quantity:", quantityField
        };

        int option = JOptionPane.showConfirmDialog(this, fields, "Add Book", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            int bookId = Integer.parseInt(idField.getText());
            String title = titleField.getText();
            String author = authorField.getText();
            int quantity = Integer.parseInt(quantityField.getText());

            libraryOps.addBook(bookId, title, author, quantity);
        }
    }

    // Form to Borrow a Book
    private void borrowBookForm() {
        JTextField bookIdField = new JTextField();
        JTextField borrowerNameField = new JTextField();

        Object[] fields = {
            "Book ID:", bookIdField,
            "Borrower Name:", borrowerNameField
        };

        int option = JOptionPane.showConfirmDialog(this, fields, "Borrow Book", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            int bookId = Integer.parseInt(bookIdField.getText());
            String borrowerName = borrowerNameField.getText();

            libraryOps.borrowBook(bookId, borrowerName);
        }
    }
    
    // main call
    public static void main(String[] args) throws Exception
    {
        new LibraryFrontPage(); // Launch GUI
    }
}
