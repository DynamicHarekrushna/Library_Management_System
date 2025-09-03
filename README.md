# 📚 Library Management System  

A simple **Library Management System** built using **Java (J2SE), Swing, AWT, Oracle SQL, and JDBC**.  
This project helps in **managing books, borrowers, and lending transactions** efficiently by automating library operations.  

---

## 🚀 Features  
- Add, view, borrow, and return books.  
- Track book availability in real-time.  
- User-friendly **GUI built with Swing & AWT**.  
- Oracle SQL database integration using **JDBC**.  
- Error handling for database connectivity and input validation.  

---

## 🛠️ Tech Stack  
- **Programming Language:** Java (J2SE)  
- **GUI:** Swing, AWT  
- **Database:** Oracle SQL  
- **Database Connectivity:** JDBC  
- **Version Control:** Git & GitHub  

---

## 📂 Project Structure  
```
Library-Management-System/
│── src/
│ ├── DatabaseConnection.java # Handles JDBC connection
│ ├── LibraryOperations.java # CRUD operations (add, borrow, return)
│ ├── FrontPage.java # Swing GUI main interface
│ ├── Main.java # Entry point of the project
│
│── database/
│ ├── schema.sql # SQL script for table creation
│
│── README.md # Project documentation
```

---

## ⚙️ Installation & Setup  

1. **Clone the Repository**  
   ```
   git clone https://github.com/your-username/library-management-system.git
   cd library-management-system
  
2. Set Up Database
- Open SQL*Plus or Oracle SQL Developer.
- Run the SQL script in database/schema.sql to create tables.

3. Configure Database in Code
- Update your database credentials in DatabaseConnection.java:
```
   private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
   private static final String USER = "your_username";
   private static final String PASSWORD = "your_password";
```
5. Run the Project
- Compile and run Main.java from your IDE (Eclipse/IntelliJ/VS Code).

---

##🔮 Future Enhancements
- Add user authentication (admin & student login).
- Implement fine management for late returns.
- Create a web-based version using Java EE or Spring Boot.
- Deploy database on cloud (AWS RDS / Oracle Cloud).

---

##🤝 Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
