package com.example.nypproje;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class SingUp implements Initializable {
    @FXML
    public AnchorPane ap;
    Statement s;
    ResultSet rs;


    @FXML
    private TextField address;

    @FXML
    private ComboBox<String> country;

    @FXML
    private TextField email;

    @FXML
    private Label error;

    @FXML
    private TextField firstname;

    @FXML
    private TextField genID;

    @FXML
    private TextField lastname;

    @FXML
    private TextField password;

    @FXML
    private TextField phone;

    @FXML
    private TextField postalcode;

    @FXML
    private TextField state;

    @FXML
    void back(ActionEvent event) throws SQLException, IOException {
        ap.getScene().getWindow().hide();
        LoginController mp = new LoginController();
        mp.createPage();
    }



    @FXML
    void singup(ActionEvent event) throws SQLException, IOException {

        String fname = firstname.getText();
        String lname = lastname.getText();
        String name = fname + " "+ lname;
        String adres = address.getText();
        String phon = phone.getText();
        String cod = postalcode.getText();
        String st = state.getText();
        String coun = (String) country.getSelectionModel().getSelectedItem();
        String pass= password.getText();
        String  id = genid();
        String mail = email.getText();

        System.out.println(mail.matches("^(.+)@(.+)$"));

        if (fname != "" && lname!= "" && adres!= ""&& phon!= ""&& cod!= ""&& st!= ""&& coun!= ""&& pass!= "" && mail.matches("^(.+)@(.+)$") ){
            Customer c = new Customer(name,adres,phon,cod,st,coun,pass,id);
            String query = "INSERT INTO Musteriler (MusteriID, MusteriAdi, Adres, Sehir,PostaKodu,Ulke,Telefon,sifre) " +
                     "VALUES(\'"+id+"\', \'"+name+"\', \'"+adres+"\',\'"+st+"\',\'"+cod+"\',\'"+coun+"\',\'"+phon+"\',\'"+pass+"\')";

            System.out.println(query);
            s.executeUpdate(query);



            System.out.println(name+" "+id+" "+adres+" "+phon+" "+cod+" "+st+" "+coun+" "+pass+" ");
            ap.getScene().getWindow().hide();
            LoginController mp = new LoginController();
            mp.createPage();
        }
        else {
            error.setText("All fields must be filled!");
        }


    }


    public void initialize(URL url, ResourceBundle rb){

        genID.setText(genid());

        firstname.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\sa-zA-Z*")) {
                firstname.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
        });
        lastname.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\sa-zA-Z*")) {
                lastname.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
        });

        state.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\sa-zA-Z*")) {
                state.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
        });





        phone.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    phone.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        postalcode.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    postalcode.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        try {
            country.setItems(getCountry());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    public ObservableList<String> getCountry() throws SQLException {

        String[] countries = new String[]{"Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands", "Western Sahara", "Yemen",  "Zambia", "Zimbabwe", "Palestine"};

        ObservableList<String> OBScountries = FXCollections.observableArrayList();

        for (int i=0; i<countries.length; i++){

            String id = countries[i];
            OBScountries.add(id);
        }
        return OBScountries;

    }


    public SingUp() throws SQLException {
        String connectionUrl = "jdbc:sqlserver://localhost;encrypt=true;database=Northwind;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        Connection con = DriverManager.getConnection(connectionUrl);
        s = con.createStatement();
    }

    public void createPage() throws IOException, SQLException {
        Stage stage = new Stage();
        stage.getIcons().add(new Image("C:\\Users\\Nuceyma\\IdeaProjects\\NYPProje\\src\\main\\java\\com\\example\\nypproje\\cargo.png"));
        stage.setTitle("Cargo!");
        Parent root = (Parent) FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("SingUp.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public static String genid() {
        int length = 5;
        //String symbol = "-/.^&*_!@%=+>)";
        String cap_letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //String small_letter = "abcdefghijklmnopqrstuvwxyz";
        //String numbers = "0123456789";


        String finalString = cap_letter;

        Random random = new Random();

        char[] password = new char[length];

        String pass="";

        for (int i = 0; i < length; i++)
        {
            password[i] = finalString.charAt(random.nextInt(finalString.length()));
            pass += password[i];
        }
        return pass;
    }

}
