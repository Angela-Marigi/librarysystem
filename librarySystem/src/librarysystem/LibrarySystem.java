/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.sql.*;
import java.time.LocalDate;
import javafx.scene.control.ChoiceBox;

/**
 *
 * @author Angieee
 */
public class LibrarySystem extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        //Logging in page- creating a form
        Text userName = new Text("Admin No");
        Text password = new Text("Password");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Your password");
        TextField Uname = new TextField();
        String st = ("Library Login System");

        Text blank = new Text(st);
        Text welcome = new Text("Library Management System");

        Button login = new Button("Login");
        AnchorPane anchor = new AnchorPane();

        Button btn = new Button();
        login.setMinSize(75, 30);
        BackgroundFill background_fill = new BackgroundFill(Color.TEAL,
                CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        BackgroundFill backgroundLogin = new BackgroundFill(Color.HONEYDEW,
                CornerRadii.EMPTY, Insets.EMPTY);
        Background loginback = new Background(backgroundLogin);
        login.setBackground(loginback);
        userName.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
        password.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
        welcome.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 21));
        userName.setFill(Color.WHITE);
        password.setFill(Color.WHITE);
        welcome.setFill(Color.WHITE);
        blank.setFill(Color.WHITE);
        blank.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
        
        //After Logging In
        Button RegBook = new Button("Register New Book");
        Button User = new Button("Register New Student");
        Button Return = new Button("Return Book");
        Button Borrow = new Button("Borrow Book");
        Button IssuedBooks = new Button("Issued Books");
        Button bookInfo = new Button("Book Info");
        Button studentInfo = new Button("Student Info");
        RegBook.setBackground(loginback);
        User.setBackground(loginback);
        Return.setBackground(loginback);
        Borrow.setBackground(loginback);
        IssuedBooks.setBackground(loginback);
        bookInfo.setBackground(loginback);
        studentInfo.setBackground(loginback);
        //welcome.setAlignment(Pos.CENTER);

        
        GridPane mygridpane = new GridPane();

        mygridpane.setMinSize(600, 400);
        mygridpane.setBackground(background);

        mygridpane.setVgap(20);//spaces between columns
        mygridpane.setHgap(5);//spaces between rows
        mygridpane.setPadding(new Insets(10, 10, 10, 10));//manages spaces around edges of gridPane
        mygridpane.setAlignment(Pos.CENTER);

        mygridpane.add(userName, 0, 1);
        mygridpane.add(Uname, 1, 1);
        mygridpane.add(password, 0, 2);
        mygridpane.add(passwordField, 1, 2);
        mygridpane.add(login, 1, 4);

        Scene scene = new Scene(mygridpane);

        primaryStage.setTitle("login");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.show();
        //making a button dispaly the text when user presses it
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                RegBook.setMinSize(400, 100);
                User.setMinSize(400, 100);
                Return.setMinSize(400, 100);
                Borrow.setMinSize(400, 100);
                IssuedBooks.setMinSize(400, 100);
                bookInfo.setMinSize(400, 100);
                studentInfo.setMinSize(400, 100);

                GridPane secondGridPane = new GridPane();
                secondGridPane.setMinSize(900, 600);
                secondGridPane.setBackground(background);
                secondGridPane.setVgap(1);
                secondGridPane.setHgap(5);
                secondGridPane.setAlignment(Pos.TOP_LEFT);
                secondGridPane.add(RegBook, 0, 0);
                secondGridPane.add(User, 0, 1);
                secondGridPane.add(Borrow, 0, 2);
                secondGridPane.add(Return, 0, 3);
                secondGridPane.add(bookInfo, 0, 4);
                secondGridPane.add(studentInfo, 0, 5);
                secondGridPane.add(IssuedBooks, 0, 6);

                Stage newWindow = new Stage();
                newWindow.setTitle("Library Dashboard");
                Scene scene_two = new Scene(secondGridPane);
                newWindow.setScene(scene_two);
                newWindow.show();

            }
        });
        
        //Register new book
        RegBook.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                Text Bookname = new Text("Book Name:");
                TextField bookField = new TextField();
                Text BookID = new Text("Book ID");
                TextField IDfield = new TextField();
                Button save = new Button("Save Details");
                Text Author = new Text("Author");
                TextField AuthorField = new TextField();
                Text Quantity = new Text("Book Quantity");
                TextField QuantityField = new TextField();
                Text txt1 = new Text();
                Bookname.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
                BookID.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
                Author.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
                Quantity.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
                save.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 11));
                txt1.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 11));
                Bookname.setFill(Color.WHITE);
                BookID.setFill(Color.WHITE);
                Author.setFill(Color.WHITE);
                Quantity.setFill(Color.WHITE);
                txt1.setFill(Color.WHITE);
                save.setBackground(loginback);

                GridPane thirdGridPane = new GridPane();
                thirdGridPane.setMinSize(600, 500);
                thirdGridPane.setBackground(background);
                thirdGridPane.setVgap(10);
                thirdGridPane.setHgap(10);
                thirdGridPane.setAlignment(Pos.CENTER);
                thirdGridPane.add(Bookname, 0, 0);
                thirdGridPane.add(bookField, 1, 0);
                thirdGridPane.add(BookID, 0, 1);
                thirdGridPane.add(IDfield, 1, 1);
                thirdGridPane.add(Author, 0, 2);
                thirdGridPane.add(AuthorField, 1, 2);
                thirdGridPane.add(Quantity, 0, 3);
                thirdGridPane.add(QuantityField, 1, 3);

                thirdGridPane.add(save, 1, 4);
                thirdGridPane.add(txt1, 1, 6);
                save.setOnMouseClicked((new EventHandler<javafx.scene.input.MouseEvent>() {
                    public void handle(javafx.scene.input.MouseEvent event) {
                        try {
                            final String BOOKID = IDfield.getText();
                            final String AuthorName = AuthorField.getText();
                            final String Quantity = QuantityField.getText();
                            final String BookJina = bookField.getText();
                            //registering the driver class using the forName() method
                            Class.forName("com.mysql.jdbc.Driver"); //step one                
                         
                            // Creating the connection object using the getConnection() method- establish connection with database
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root", "");  //step two
                           //Creating the statement object using createStatement()method- responsible to execute queries with database
                            Statement st = con.createStatement();   //step three                 
                            String sts = "INSERT INTO `bookregistry`(`BookID`,`BookName`,`Author`,`Quantity`) VALUES (" + "'" + BOOKID + "'" + "," + "'" + BookJina + "'" + "," + "'" + AuthorName + "'" + "," + "'" + Quantity + "'" + ")";
                            //String sts = "INSERT INTO `employee`(`title`,`name`) VALUES ("+"'"+title_option+"'"+","+"'"+employee_name+"'"+")";
                            //Execute the query 
                            st.executeUpdate(sts); //step four
                            txt1.setText("Book has been registred successfully");
                            //close the connection object using the close()method
                            con.close();//step five
                        } catch (Exception ee) {
                            System.out.println(ee);
                            txt1.setText("Not Inserted");
                        }

                    }
                }));

                Stage newWindow1 = new Stage();
                newWindow1.setTitle("Book Registry");
                Scene scene_three = new Scene(thirdGridPane);
                newWindow1.setScene(scene_three);
                newWindow1.show();

            }
        });
        
        //Registering new student
        User.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                Text FirstName = new Text("First Name");
                TextField FNameField = new TextField();
                Text LastName = new Text("Last Name");
                TextField LNameField = new TextField();
                Text studNo = new Text("Student No");
                TextField NoField = new TextField();
                Text txt1 = new Text();
                Button saveStudent = new Button("Save Student Details");

                FirstName.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
                LastName.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
                studNo.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
                txt1.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 13));

                txt1.setFill(Color.WHITE);

                saveStudent.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 11));
                FirstName.setFill(Color.WHITE);
                LastName.setFill(Color.WHITE);
                studNo.setFill(Color.WHITE);

                saveStudent.setBackground(loginback);

                GridPane fourthGridPane = new GridPane();
                fourthGridPane.setMinSize(600, 500);
                fourthGridPane.setBackground(background);
                fourthGridPane.setVgap(10);
                fourthGridPane.setHgap(10);
                fourthGridPane.setAlignment(Pos.CENTER);
                fourthGridPane.add(FirstName, 0, 0);
                fourthGridPane.add(FNameField, 1, 0);
                fourthGridPane.add(LastName, 0, 1);
                fourthGridPane.add(LNameField, 1, 1);
                fourthGridPane.add(studNo, 0, 2);
                fourthGridPane.add(NoField, 1, 2);
                fourthGridPane.add(saveStudent, 1, 3);
                fourthGridPane.add(txt1, 1, 5);
                saveStudent.setOnMouseClicked((new EventHandler<javafx.scene.input.MouseEvent>() {
                    public void handle(javafx.scene.input.MouseEvent event) {
                        try {
                            final String FName = FNameField.getText();
                            final String LName = LNameField.getText();
                            final String StNo = NoField.getText();

                            Class.forName("com.mysql.jdbc.Driver"); //step one                
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root", "");  //step two

                            Statement st = con.createStatement();   //step three                 
                            String sts = "INSERT INTO `studentregistry`(`StudentID`,`FirstName`,`LastName`) VALUES (" + "'" + StNo + "'" + "," + "'" + FName + "'" + "," + "'" + LName + "'" + ")";
                            //String sts = "INSERT INTO `employee`(`title`,`name`) VALUES ("+"'"+title_option+"'"+","+"'"+employee_name+"'"+")";

                            st.executeUpdate(sts); //step four
                            txt1.setText("Student Registration was Successful");

                            con.close();//step five
                        } catch (Exception ee) {
                            System.out.println(ee);
                            txt1.setText("Error Experienced in registration");
                        }

                    }
                }));

                Stage newWindow2 = new Stage();
                newWindow2.setTitle("Student Registry");
                Scene scene_four = new Scene(fourthGridPane);
                newWindow2.setScene(scene_four);
                newWindow2.show();

            }
        });
        
        //Borrow book
        Borrow.setOnAction((ActionEvent event) -> {
            Text StudentId = new Text("Student ID");
            TextField StudentNo = new TextField();
            Text BOOKID = new Text("BOOK ID");
            TextField IDBOOK = new TextField();
            Text DateBorrowed = new Text("Date Borrowed");
            Text ReturnDate = new Text("Return Date");
            Button IssueBk = new Button("Issue Book");
            DatePicker borrow = new DatePicker();
            DatePicker Return1 = new DatePicker();
            LocalDate value1 = borrow.getValue();
            LocalDate value2 = Return1.getValue();
            Text txt1 = new Text();
            StudentId.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
            DateBorrowed.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
            ReturnDate.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
            BOOKID.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
            txt1.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 13));
            IssueBk.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 11));
            StudentId.setFill(Color.WHITE);
            DateBorrowed.setFill(Color.WHITE);
            ReturnDate.setFill(Color.WHITE);
            BOOKID.setFill(Color.WHITE);
            txt1.setFill(Color.WHITE);
            IssueBk.setBackground(loginback);
            GridPane fifthGridPane = new GridPane();
            fifthGridPane.setMinSize(600, 500);
            fifthGridPane.setBackground(background);
            fifthGridPane.setVgap(15);
            fifthGridPane.setHgap(10);
            fifthGridPane.setAlignment(Pos.CENTER);
            fifthGridPane.add(BOOKID, 0, 0);
            fifthGridPane.add(IDBOOK, 1, 0);
            fifthGridPane.add(StudentId, 0, 1);
            fifthGridPane.add(StudentNo, 1, 1);
            fifthGridPane.add(DateBorrowed, 0, 2);
            fifthGridPane.add(borrow, 1, 2);
            fifthGridPane.add(ReturnDate, 0, 3);
            fifthGridPane.add(Return1, 1, 3);
            fifthGridPane.add(IssueBk, 1, 4);
            fifthGridPane.add(txt1, 1, 6);
            IssueBk.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
                public void handle(javafx.scene.input.MouseEvent event) {
                    try {
                        final String IDbk = IDBOOK.getText();
                        final String IDst = StudentNo.getText();
                        final LocalDate borrowedDate = borrow.getValue();
                        final LocalDate dateReturn = Return1.getValue();
                        Class.forName("com.mysql.jdbc.Driver"); //step one                
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root", "");  //step two
                        Statement st1 = con.createStatement(); //step three
                        String sts = "INSERT INTO `borrowedlist`(`StudentID`,`BookID`,`DateBorrowed`,`DateReturned`) VALUES (" + "'" + IDst + "'" + "," + "'" + IDbk + "'" + "," + "'" + borrowedDate + "'" + "," + "'" + dateReturn + "'" + ")";
                        //String sts = "INSERT INTO `employee`(`title`,`name`) VALUES ("+"'"+title_option+"'"+","+"'"+employee_name+"'"+")";
                        String sql = "UPDATE bookregistry " + " SET " + "Quantity=Quantity-1" + " WHERE " + "BookID " + "=" + " " + IDbk;
                        st1.executeUpdate(sts); //step four
                        st1.executeUpdate(sql);
                        txt1.setText("Book issue was successful");
                        con.close();//step five
                    }catch (Exception ee) {
                        System.out.println(ee);
                        txt1.setText("OOOPS,Seems student or book is not registered");
                    }
                }
            });
            Stage newWindow3 = new Stage();
            newWindow3.setTitle("Borrow Book");
            Scene scene_fifth = new Scene(fifthGridPane);
            newWindow3.setScene(scene_fifth);
            newWindow3.show();
        });
        
        //Return book
        Return.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Text StudentId = new Text("Student ID");
                TextField StudentNo = new TextField();
                Text BOOKID = new Text("BOOK ID");
                TextField IDBOOK = new TextField();
                Button bkReturn = new Button("Returned");

                StudentId.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 20));

                BOOKID.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 20));

                bkReturn.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 11));

                StudentId.setFill(Color.WHITE);

                BOOKID.setFill(Color.WHITE);
                Text txt1 = new Text();
                txt1.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 13));
                txt1.setFill(Color.WHITE);

                bkReturn.setBackground(loginback);

                GridPane sixthGridPane = new GridPane();
                sixthGridPane.setMinSize(600, 500);
                sixthGridPane.setBackground(background);
                sixthGridPane.setVgap(15);
                sixthGridPane.setHgap(10);
                sixthGridPane.setAlignment(Pos.CENTER);
                sixthGridPane.add(BOOKID, 0, 0);
                sixthGridPane.add(IDBOOK, 1, 0);
                sixthGridPane.add(StudentId, 0, 1);
                sixthGridPane.add(StudentNo, 1, 1);
                sixthGridPane.add(bkReturn, 1, 2);
                sixthGridPane.add(txt1, 1, 4);
                bkReturn.setOnMouseClicked((new EventHandler<javafx.scene.input.MouseEvent>() {
                    public void handle(javafx.scene.input.MouseEvent event) {
                        try {
                            final String theBkID = IDBOOK.getText();
                            final String theSTID = StudentNo.getText();

                            Class.forName("com.mysql.jdbc.Driver"); //step one                
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root", "");  //step two

                            Statement st = con.createStatement();   //step three  
                            // DELETE FROM `borrowedlist` WHERE 0

                            String sts = "delete from borrowedlist where BookID =" + theBkID + " and " + " StudentID " + "=" + theSTID;
                            String sql = "UPDATE bookregistry " + " SET " + "Quantity=Quantity+1" + " WHERE " + "BookID " + "=" + " " + theBkID;
                            st.executeUpdate(sts); //step four
                            st.executeUpdate(sql);
                            txt1.setText("Return was Successful");

                            con.close();//step five
                        } catch (Exception ee) {
                            System.out.println(ee);
                            txt1.setText("Seems to have experienced an error!");
                        }

                    }
                }));

                Stage newWindow4 = new Stage();
                newWindow4.setTitle("Return Book");
                Scene scene_sixth = new Scene(sixthGridPane);
                newWindow4.setScene(scene_sixth);
                newWindow4.show();

            }
        });
        
        //Book info.
        bookInfo.setOnAction((ActionEvent event) -> {
            Text BOOKID = new Text("BooK ID");
            TextField IDBOOK = new TextField();
            Button search = new Button("Search Book");
            Text bkid = new Text();
            Text setId = new Text();
            Text Name = new Text();
            Text setName = new Text();
            Text Authoor = new Text();
            Text setAuthoor = new Text();
            Text Quantitee = new Text();
            Text setQuantity = new Text();
            Text Issued = new Text();
            Text noIssued = new Text();
            
            BOOKID.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
            
            search.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 11));
            bkid.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
            setId.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
            Name.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
            setName.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
            Authoor.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
            setAuthoor.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
            Quantitee.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
            setQuantity.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
            Issued.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
            noIssued.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
            BOOKID.setFill(Color.WHITE);
            bkid.setFill(Color.WHITE);
            setId.setFill(Color.WHITE);
            Name.setFill(Color.WHITE);
            setName.setFill(Color.WHITE);
            Authoor.setFill(Color.WHITE);
            setAuthoor.setFill(Color.WHITE);
            Quantitee.setFill(Color.WHITE);
            setQuantity.setFill(Color.WHITE);
            Issued.setFill(Color.WHITE);
            noIssued.setFill(Color.WHITE);
            
            search.setBackground(loginback);
            
            GridPane sevGridPane = new GridPane();//SEV to mean seventh grid pane.
            sevGridPane.setMinSize(600, 500);
            sevGridPane.setBackground(background);
            sevGridPane.setVgap(15);
            sevGridPane.setHgap(10);
            sevGridPane.setAlignment(Pos.CENTER);
            sevGridPane.add(BOOKID, 0, 0);
            sevGridPane.add(IDBOOK, 1, 0);
            
            sevGridPane.add(search, 1, 1);
            sevGridPane.add(bkid, 0, 2);
            sevGridPane.add(setId, 1, 2);
            sevGridPane.add(Name, 0, 3);
            sevGridPane.add(setName, 1, 3);
            sevGridPane.add(Authoor, 0, 4);
            sevGridPane.add(setAuthoor, 1, 4);
            sevGridPane.add(Quantitee, 0, 5);
            sevGridPane.add(setQuantity, 1, 5);
            
            sevGridPane.add(Issued, 0, 6);
            sevGridPane.add(noIssued, 1, 6);
            
            search.setOnMouseClicked((new EventHandler<javafx.scene.input.MouseEvent>() {
                public void handle(javafx.scene.input.MouseEvent event) {
                    try {
                        final String theBkID = IDBOOK.getText();
                        
                        Class.forName("com.mysql.jdbc.Driver"); //step one
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root", "");  //step two
                        
                        Statement st = con.createStatement();   //step three
                        // DELETE FROM `borrowedlist` WHERE 0
                        
                        String sts = "select * from bookregistry where BookID" + "=" + "'" + theBkID + "'";
                        
                        ResultSet rs = st.executeQuery(sts);
                        
                        while (rs.next()) {
                            
                            String BookID = rs.getString("BookID");
                            String BookName = rs.getString("BookName");
                            String Author = rs.getString("Author");
                            String Quantity = rs.getString("Quantity");
                            bkid.setText("Book ID");
                            setId.setText(BookID);
                            Name.setText("Book Name");
                            setName.setText(BookName);
                            Authoor.setText("Author");
                            setAuthoor.setText(Author);
                            Quantitee.setText("Available Quantity");
                            setQuantity.setText(Quantity);
                            
                        }

                        con.close();//step five
                    } catch (Exception ee) {
                        Issued.setText("Wrong Book ID or Unregistred");
                        System.out.println(ee);
                        
                        //txt1.setText("Seems to have experienced an error!");
                    }
                    
                }
            }));
            
            Stage newWindow5 = new Stage();
            newWindow5.setTitle("Book Info");
            Scene scene_sev = new Scene(sevGridPane);
            newWindow5.setScene(scene_sev);
            newWindow5.show();
        });
        
        //Student info.
        studentInfo.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Text StudentId = new Text("Student ID");
                TextField StudentNo = new TextField();
                Button searchStud = new Button("Search Student");
                Text NameFirst = new Text();
                Text setFirst = new Text();
                Text NameLast = new Text();
                Text setLast = new Text();
                Text ID = new Text();
                Text setId = new Text();
                Text txt1 = new Text();

                NameFirst.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
                setFirst.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
                NameLast.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
                setLast.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
                ID.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
                setId.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
                txt1.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 15));

                NameFirst.setFill(Color.WHITE);
                setFirst.setFill(Color.WHITE);
                NameLast.setFill(Color.WHITE);
                setLast.setFill(Color.WHITE);
                ID.setFill(Color.WHITE);
                setId.setFill(Color.WHITE);
                txt1.setFill(Color.WHITE);

                StudentId.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 20));

                searchStud.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 11));

                StudentId.setFill(Color.WHITE);
                searchStud.setBackground(loginback);

                GridPane eigGridPane = new GridPane();
                eigGridPane.setMinSize(600, 500);
                eigGridPane.setBackground(background);
                eigGridPane.setVgap(15);
                eigGridPane.setHgap(10);
                eigGridPane.setAlignment(Pos.CENTER);
                eigGridPane.add(StudentId, 0, 0);
                eigGridPane.add(StudentNo, 1, 0);
                eigGridPane.add(NameFirst, 0, 3);
                eigGridPane.add(setFirst, 1, 3);
                eigGridPane.add(NameLast, 0, 4);
                eigGridPane.add(setLast, 1, 4);
                eigGridPane.add(ID, 0, 5);
                eigGridPane.add(setId, 1, 5);
                eigGridPane.add(txt1, 1, 8);

                eigGridPane.add(searchStud, 1, 1);
                searchStud.setOnMouseClicked((new EventHandler<javafx.scene.input.MouseEvent>() {
                    public void handle(javafx.scene.input.MouseEvent event) {
                        try {
                            //  final String theBkID = IDBOOK.getText();
                            // final String theSTID = StudentNo.getText();
                            // ListView list = new ListView(names);
                            final String theStId = StudentNo.getText();
                            int i = 0;
                            Class.forName("com.mysql.jdbc.Driver"); //step one                
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root", "");  //step two

                            Statement st = con.createStatement();   //step three  
                            String sts = "select * from studentregistry where StudentID" + "=" + "'" + theStId + "'";
                            //
                            ResultSet rs = st.executeQuery(sts);
                            // System.out.println("StudentID  BookID   DateBorrowed DateReturned ");
                            while (rs.next()) {
                                String StudentID = rs.getString("StudentID");
                                String Fname = rs.getString("FirstName");
                                String Lname = rs.getString("LastName");
                                NameFirst.setText("First Name");
                                setFirst.setText(Fname);
                                NameLast.setText("Last Name");
                                setLast.setText(Lname);
                                ID.setText("Searched ID");
                                setId.setText(StudentID);

                                //txt1.setText(StudentID+"   "+BookID+"    "+DateBorrowed+"  "+DateReturned);
                            }
                            txt1.setText("Student Details Have been retrieved");
                            con.close();//step five
                        } catch (Exception ee) {
                            System.out.println(ee);
                            txt1.setText("You are IN trouble");
                            System.out.println("YOU ARE SCREWED");
                            // txt1.setText("Not Inserted");
                        }

                    }
                }));

                Stage newWindow6 = new Stage();
                newWindow6.setTitle("Student Info");
                Scene scene_eig = new Scene(eigGridPane);
                newWindow6.setScene(scene_eig);
                newWindow6.show();

            }
        });
        
        //Issued books
        IssuedBooks.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Button show = new Button("Click to load issued books");
                Text txt1 = new Text();
                Text NoIssued = new Text();
                Text setNoIssued = new Text();
                txt1.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
                NoIssued.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
                setNoIssued.setFont(Font.font("sans-serif", FontWeight.MEDIUM, FontPosture.REGULAR, 15));
                NoIssued.setFill(Color.WHITE);
                setNoIssued.setFill(Color.WHITE);
                txt1.setFill(Color.WHITE);
                show.setMinSize(100, 50);
                ChoiceBox StudentsID = new ChoiceBox();
                ChoiceBox Booksid = new ChoiceBox();
                ChoiceBox dateborr = new ChoiceBox();//borrowed date
                ChoiceBox dateRet = new ChoiceBox();
                StudentsID.setMinSize(40, 30);
                Booksid.setMinSize(40, 30);
                StudentsID.setMinSize(40, 30);
                dateborr.setMinSize(40, 30);
                dateRet.setMinSize(40, 30);
                StudentsID.getItems().addAll("Student ID");
                Booksid.getItems().addAll("Book ID");
                dateborr.getItems().addAll("Date Borrowed");
                dateRet.getItems().addAll("Date Returned");

                StudentsID.getSelectionModel().selectFirst();
                Booksid.getSelectionModel().selectFirst();
                dateborr.getSelectionModel().selectFirst();
                dateRet.getSelectionModel().selectFirst();

                // NoIssued = new Text();
                //Text setNoIssued
                GridPane eigGridPane = new GridPane();
                eigGridPane.setMinSize(600, 500);
                eigGridPane.setBackground(background);
                eigGridPane.setVgap(15);
                eigGridPane.setHgap(1);
                eigGridPane.setAlignment(Pos.CENTER);
                eigGridPane.add(NoIssued, 0, 1);
                eigGridPane.add(setNoIssued, 1, 1);
                eigGridPane.add(txt1, 0, 0);
                eigGridPane.add(show, 0, 3);
                eigGridPane.add(StudentsID, 1, 5);
                eigGridPane.add(Booksid, 2, 5);
                eigGridPane.add(dateborr, 3, 5);
                eigGridPane.add(dateRet, 4, 5);

                //eigGridPane.add(names,2,3);
                // eigGridPane.add(list,3,0);
                show.setOnMouseClicked((new EventHandler<javafx.scene.input.MouseEvent>() {
                    public void handle(javafx.scene.input.MouseEvent event) {
                        try {
                            //  final String theBkID = IDBOOK.getText();
                            // final String theSTID = StudentNo.getText();
                            // ListView list = new ListView(names);
                            int i = 0;
                            Class.forName("com.mysql.jdbc.Driver"); //step one                
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root", "");  //step two

                            Statement st = con.createStatement();   //step three  
                            //
                            ResultSet rs = st.executeQuery("SELECT * FROM borrowedlist");
                            // System.out.println("StudentID  BookID   DateBorrowed DateReturned ");
                            while (rs.next()) {
                                String StudentID = rs.getString("StudentID");
                                String BookID = rs.getString("BookID");
                                Date DateBorrowed = rs.getDate("DateBorrowed");
                                Date DateReturned = rs.getDate("DateReturned");
                                StudentsID.getItems().addAll(StudentID);
                                Booksid.getItems().addAll(BookID);
                                dateborr.getItems().addAll(DateBorrowed);
                                dateRet.getItems().addAll(DateReturned);
                                i++;

                                //txt1.setText(StudentID+"   "+BookID+"    "+DateBorrowed+"  "+DateReturned);
                            }
                            String c = Integer.toString(i);
                            NoIssued.setText("No issued");
                            setNoIssued.setText(c);
                            txt1.setText("here is the issued data");
                            con.close();//step five
                        } catch (Exception ee) {
                            System.out.println(ee);
                            txt1.setText("You are IN trouble");
                            System.out.println("YOU ARE SCREWED");
                            // txt1.setText("Not Inserted");
                        }

                    }
                }));

                Stage newWindow7 = new Stage();
                newWindow7.setTitle("Issued Books Info");
                Scene scene_eig = new Scene(eigGridPane);
                newWindow7.setScene(scene_eig);
                newWindow7.show();

            }
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args); //Launching the method
    }

}
