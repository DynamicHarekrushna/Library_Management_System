import java.sql.*;

public class DatabaseConnection 
{
    private static final String URL = "jdbc:oracle:thin:@localhost:1522:orcl"; // Database URL
    private static final String USER = "scott"; // Database User-name
    private static final String PASSWORD = "tiger"; // Database password

    public static Connection getConnection() 
    {
        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // Load Oracle JDBC Driver
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return null;
        }
    }
}

// FOR DATABASE TABLE
//=======================
/*
 -- Create Books Table
CREATE TABLE books (
    book_id NUMBER PRIMARY KEY,
    title VARCHAR2(255) NOT NULL,
    author VARCHAR2(255) NOT NULL,
    quantity NUMBER DEFAULT 0
);

-- Create Borrow Records Table
CREATE TABLE borrow_books (
    record_id NUMBER PRIMARY KEY,
    book_id NUMBER,
    borrower_name VARCHAR2(255) NOT NULL,
    borrow_date DATE DEFAULT SYSDATE,
    return_date DATE,
    FOREIGN KEY (book_id) REFERENCES books(book_id) ON DELETE CASCADE
);

-- Create a Sequence for Auto-Incrementing Record IDs
CREATE SEQUENCE borrow_books_seq
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
 */