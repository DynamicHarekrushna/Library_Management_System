import java.sql.*;

public class LibraryOperations 
{
    private Connection con;

    public LibraryOperations()
    {
        con = DatabaseConnection.getConnection();
    }

    // Method to [ Add a Book ]
    public void addBook(int bookId, String title, String author, int quantity) 
    {
        String sql = "INSERT INTO books (book_id, title, author, quantity) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) 
        {
            ps.setInt(1, bookId);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setInt(4, quantity);
            int rowsInserted = ps.executeUpdate();
            System.out.println(rowsInserted > 0 ? "Book Added Successfully!" : "Failed to Add Book.");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to [ View Books ]
    public void viewBooks() 
    {
        String sql = "SELECT * FROM books";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) 
        {
            while (rs.next()) 
            {
                System.out.println("Book ID: " + rs.getInt("book_id") + 
                                   ", Title: " + rs.getString("title") + 
                                   ", Author: " + rs.getString("author") + 
                                   ", Quantity: " + rs.getInt("quantity"));
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    // Method to Borrow or Return Book
    public void borrowBook(int bookId, String borrowerName) 
    {
        String sql = "INSERT INTO borrow_books (record_id, book_id, borrower_name, borrow_date) VALUES (borrow_books_seq.nextval, ?, ?, SYSDATE)";
        try (PreparedStatement ps = con.prepareStatement(sql)) 
        {
            ps.setInt(1, bookId);
            ps.setString(2, borrowerName);
            int rowsInserted = ps.executeUpdate();
            System.out.println(rowsInserted > 0 ? "Book Borrowed Successfully!" : "Failed to Borrow Book.");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
