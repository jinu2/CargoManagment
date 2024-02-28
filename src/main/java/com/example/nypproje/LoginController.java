package com.example.nypproje;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;





public class LoginController {


    @FXML
    public AnchorPane ap;

    @FXML
    private Label Error;

    @FXML
    private TextField id;

    @FXML
    private TextField passwordfield;

    Statement s;
    ResultSet rs;


    @FXML
    void SingUp(ActionEvent event) throws SQLException, IOException {

        ap.getScene().getWindow().hide();
        SingUp mp = new SingUp();
        mp.createPage();

    }


    public LoginController() throws SQLException {
        String connectionUrl = "jdbc:sqlserver://localhost;encrypt=true;database=Northwind;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        Connection con = DriverManager.getConnection(connectionUrl);
        s = con.createStatement();
    }

    public void createPage() throws IOException, SQLException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Login.fxml"));
        stage.getIcons().add(new Image("C:\\Users\\Nuceyma\\IdeaProjects\\NYPProje\\src\\main\\java\\com\\example\\nypproje\\cargo.png"));
        stage.setTitle("Cargo!");
        Scene scene = new Scene(fxmlLoader.load(), 800, 800);
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    protected void Login() throws SQLException, IOException {
        Test deneme = new Test();

        deneme.setLogInC();
        String username = id.getText();
        String password = passwordfield.getText();

        if (deneme.logInC(username, password)) {
            Error.setText("Login Successful");
            ap.getScene().getWindow().hide();
            MainPageC mp = new MainPageC();
            mp.createPage(username);
        }

        deneme.setLogInE();

        if(deneme.logInE(username, password)){
            Error.setText("Login Successful");
            ap.getScene().getWindow().hide();
            MainPageE mp = new MainPageE();
            mp.createPage(username);
        }

        else if (!deneme.logInC(username, password) && !deneme.logInE(username, password)){
            Error.setText("Login Failed");
        }

    }

    @FXML
    public void onEnter(ActionEvent ae) throws SQLException, IOException {
         Login();
    }

}
