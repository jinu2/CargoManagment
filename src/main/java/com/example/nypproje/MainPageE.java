package com.example.nypproje;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainPageE implements Initializable {

    @FXML
    public AnchorPane ap;

    @FXML
    public Pane main;
    Statement s;
    ResultSet rs;

    public static int userID;


    @FXML
    private TextField acc_adres;

    @FXML
    private Label acc_error;

    @FXML
    private TextField acc_city;

    @FXML
    private TextField acc_country;

    @FXML
    private TextField acc_dob;

    @FXML
    private TextField acc_id;

    @FXML
    private TextField acc_name;

    @FXML
    private TextField acc_newpass;

    @FXML
    private TextField acc_oldpass;

    @FXML
    private TextField acc_phone;

    @FXML
    private TextField acc_pos;

    @FXML
    private TextField acc_postalcode;

    @FXML
    private Pane account;


    @FXML
    private Pane image;

    @FXML
    private GridPane products;

    @FXML
    private Pane rescus;

    @FXML
    private Pane resorders;

    @FXML
    private Pane shippers;


    public TableView<Order> table;
    public TableColumn<Order, String> col1;
    public TableColumn<Order, String> col2;
    public TableColumn<Order, String> col3;
    public TableColumn<Order, String> col4;
    public TableColumn<Order, String> col5;

    public TableView<ResponsibleCusto> tablec;
    public TableColumn<ResponsibleCusto, String> col1c;
    public TableColumn<ResponsibleCusto, String> col2c;
    public TableColumn<ResponsibleCusto, String> col3c;
    public TableColumn<ResponsibleCusto, String> col4c;
    public TableColumn<ResponsibleCusto, String> col5c;

    public TableView<Product> tablep;
    public TableColumn<Product, String> col1p;
    public TableColumn<Product, String> col2p;
    public TableColumn<Product, String> col3p;
    public TableColumn<Product, String> col4p;


    @FXML
    private ImageView photo;

    @FXML
    private TextField paymentamount;

    @FXML
    private TextField totalproduct;


    @FXML
    private ComboBox<String> shipper;

    @FXML
    private TextField totalorders;

    @FXML
    private TextField totalcustomer;



    @FXML
    void Account() throws SQLException {

        System.out.println(getUserID());

        //main.setVisible(false);
        account.setVisible(true);
        account.setOpacity(1);
        products.setVisible(false);
        rescus.setVisible(false);
        resorders.setVisible(false);

        Employee e = getEmployee().get(userID-1);


        String s=e.photo.get().toString();
        //System.out.println(s);

        Image image = new Image(s);
        photo.setFitHeight(150); //726
        photo.setFitWidth(150); //500
        photo.setImage(image);

        acc_city.setText(e.city.get().toString());
        acc_adres.setText(e.adres.get().toString());
        acc_dob.setText(e.dob.get().toString());
        acc_id.setText(e.id.get().toString());
        acc_country.setText(e.country.get().toString());
        acc_name.setText(e.fname.get().toString()+" "+e.lname.get().toString());
        acc_phone.setText(e.phone.get().toString());
        acc_pos.setText(e.position.get().toString());
        acc_postalcode.setText(e.postalcode.get().toString());


    }

    @FXML
    void Customers(ActionEvent event) throws SQLException {
        //main.setVisible(false);
        account.setVisible(false);
        products.setVisible(false);
        resorders.setVisible(false);
        rescus.setOpacity(1);
        rescus.setVisible(true);


        col1c.setCellValueFactory(new PropertyValueFactory<>("id"));
        col2c.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
        col3c.setCellValueFactory(new PropertyValueFactory<>("numberoforder"));
        col4c.setCellValueFactory(new PropertyValueFactory<>("Payment"));
        col5c.setCellValueFactory(new PropertyValueFactory<>("address"));

        try {
            tablec.setItems(getCustomers());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        tablec.setEditable(true);
        col1c.setCellFactory(TextFieldTableCell.forTableColumn());
        col2c.setCellFactory(TextFieldTableCell.forTableColumn());
        col3c.setCellFactory(TextFieldTableCell.forTableColumn());
        col4c.setCellFactory(TextFieldTableCell.forTableColumn());
        col5c.setCellFactory(TextFieldTableCell.forTableColumn());

        totalcustomer.setText(String.valueOf(getCustomers().size()));



    }

    @FXML
    void Products(ActionEvent event) throws SQLException {
        //main.setVisible(false);
        account.setVisible(false);
        products.setVisible(true);
        products.setOpacity(1);
        resorders.setVisible(false);
        rescus.setVisible(false);

        col1p.setCellValueFactory(new PropertyValueFactory<>("id"));
        col2p.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        col3p.setCellValueFactory(new PropertyValueFactory<>("Price"));
        col4p.setCellValueFactory(new PropertyValueFactory<>("Amount"));

        try {
            tablep.setItems(getProduct());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        tablep.setEditable(true);
        col1p.setCellFactory(TextFieldTableCell.forTableColumn());
        col2p.setCellFactory(TextFieldTableCell.forTableColumn());
        col3p.setCellFactory(TextFieldTableCell.forTableColumn());
        col4p.setCellFactory(TextFieldTableCell.forTableColumn());

        totalproduct.setText(String.valueOf(getProduct().size()));

    }



    @FXML
    void LogOut(ActionEvent event) throws SQLException, IOException {

        ap.getScene().getWindow().hide();
        LoginController mp = new LoginController();
        mp.createPage();

    }

    @FXML
    void Orders(ActionEvent event) throws SQLException {
        //main.setVisible(false);
        account.setVisible(false);
        products.setVisible(false);
        rescus.setVisible(false);
        resorders.setVisible(true);
        resorders.setOpacity(1);

        col1.setCellValueFactory(new PropertyValueFactory<Order, String>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<Order, String>("CustomerName"));
        col3.setCellValueFactory(new PropertyValueFactory<Order, String>("CompanyName"));
        col4.setCellValueFactory(new PropertyValueFactory<Order, String>("Payment"));
        col5.setCellValueFactory(new PropertyValueFactory<Order, String>("connect"));

        try {
            table.setItems(getOrders());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        table.setEditable(false);
        col1.setCellFactory(TextFieldTableCell.forTableColumn());
        col2.setCellFactory(TextFieldTableCell.forTableColumn());
        col3.setCellFactory(TextFieldTableCell.forTableColumn());
        col4.setCellFactory(TextFieldTableCell.forTableColumn());
        col5.setCellFactory(TextFieldTableCell.forTableColumn());




        //System.out.println(getOrders().size());
        try {
            totalorders.setText(String.valueOf(getOrders().size()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            shipper.setItems(getshippers());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        shipper.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            //System.out.println(newValue);

            String query = "SELECT ShipVia,sum(NakliyeUcreti) FROM Satislar\n" +
                "left join  Musteriler on Satislar.MusteriID = Musteriler.MusteriID\n" +
                "left join  Nakliyeciler on Satislar.ShipVia = Nakliyeciler.NakliyeciID\n" +
                "WHERE EXISTS (SELECT PersonelID FROM Personeller WHERE Personeller.PersonelID = Satislar.PersonelID AND PersonelID="+(userID+1)+" AND ShipVia= "+newValue+") group by ShipVia";

            try {
                rs = s.executeQuery(query);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                while(rs.next()) {
                    //System.out.println(rs.getString(2));
                    paymentamount.setText(rs.getString(2));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        });

        shipper.getSelectionModel().select(0);

        //System.out.println(shipper.getSelectionModel().getSelectedItem());


    }

    @FXML
    void change(ActionEvent event) throws SQLException {

        String oldPassword = acc_oldpass.getText();
        String newPassword = acc_newpass.getText();

        if(getEmployee().get(userID-1).getPassword().equals(oldPassword)){
            if(newPassword!="" && newPassword.length()>=5){
                acc_error.setText("Password successfully changed!");
                System.out.println("promjeni");
                String query = "UPDATE Personeller SET sifre=\'"+newPassword+"\' WHERE PersonelID=" +(userID+1);
                s.executeUpdate(query);
                acc_oldpass.setText("");
                acc_newpass.setText("");
            }
            else {
                acc_error.setText("** New password must contain at least 5 characters!");
            }
        }
        else {
            acc_error.setText("*Incorrect old password!");
        }


    }



    public MainPageE() throws SQLException {
        String connectionUrl = "jdbc:sqlserver://localhost;encrypt=true;database=Northwind;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        Connection con = DriverManager.getConnection(connectionUrl);

        s = con.createStatement();
    }

    public void createPage(String username) throws IOException, SQLException {
        setUserID(Integer.parseInt(username));
        //System.out.println(getUserID());
        Stage stage = new Stage();
        stage.getIcons().add(new Image("C:\\Users\\Nuceyma\\IdeaProjects\\NYPProje\\src\\main\\java\\com\\example\\nypproje\\cargo.png"));
        stage.setTitle("Cargo!");
        Parent root = (Parent) FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("MainPageE.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //System.out.println(userID);

    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @FXML
    public ObservableList<Employee> getEmployee() throws SQLException {

        String query = "SELECT * FROM Personeller";
        rs = s.executeQuery(query);

        ObservableList<Employee> employees = FXCollections.observableArrayList();


        while (rs.next()){

            String fname = rs.getString(3);
            String lname= rs.getString(2);
            String position = rs.getString(4);
            String dob = rs.getString(6);
            String dateofjob = rs.getString(7);
            String adres = rs.getString(8);
            String city = rs.getString(9);
            String postalcode= rs.getString(11);
            String  id = rs.getString(1);
            String  phone = rs.getString(13);
            String  photo = rs.getString(18);
            String  degree= rs.getString(16);
            String  password= rs.getString(19);
            String  country= rs.getString(12);

            employees.add(new Employee(fname,lname,position,dob,dateofjob,country,adres,city,postalcode,phone,id,photo,password,degree));
        }
        //System.out.println(farmers1);
        return employees;

    }
    @FXML
    public ObservableList<String> getshippers() throws SQLException {


        ObservableList<String> shippers = FXCollections.observableArrayList();

        shippers.add("1");
        shippers.add("2");
        shippers.add("3");

        return shippers;

    }

    @FXML
    public ObservableList<Order> getOrders() throws SQLException {



        String query = "SELECT * FROM Satislar\n" +
                "left join  Musteriler on Satislar.MusteriID = Musteriler.MusteriID\n" +
                "left join  Nakliyeciler on Satislar.ShipVia = Nakliyeciler.NakliyeciID\n" +
                "WHERE EXISTS (SELECT PersonelID FROM Personeller WHERE Personeller.PersonelID = Satislar.PersonelID AND PersonelID="+(userID)+")";
        rs = s.executeQuery(query);

        ObservableList<Order> customers = FXCollections.observableArrayList();
        int count=1;

        while (rs.next()){

            String id = String.valueOf(count);
            String CustomerName= rs.getString(17);
            String CompanyName = rs.getString(28);
            String Payment = rs.getString(8);
            String address = rs.getString(9);
            String country = rs.getString(13);
            String city = rs.getString(10);
            String postalcode= rs.getString(12);

            customers.add(new Order( id,  CustomerName,  CompanyName,  Payment,  address,  country
                    ,  city,  postalcode));
            count++;
        }
        return customers;

    }

    @FXML
    public ObservableList<ResponsibleCusto> getCustomers() throws SQLException {

        String query = "SELECT Musteriler.MusteriID,count(MusteriAdi) as num,MusteriAdi,sum(NakliyeUcreti),Adres FROM Satislar\n" +
                "   left join  Musteriler on Satislar.MusteriID = Musteriler.MusteriID\n" +
                "   left join  Nakliyeciler on Satislar.ShipVia = Nakliyeciler.NakliyeciID\n" +
                "   WHERE EXISTS (SELECT PersonelID FROM Personeller WHERE Personeller.PersonelID = Satislar.PersonelID AND PersonelID="+(userID)+") group by Musteriler.MusteriID,MusteriAdi,Adres order by MusteriAdi";

        rs = s.executeQuery(query);

        ObservableList<ResponsibleCusto> customers = FXCollections.observableArrayList();


        while (rs.next()){

            String CustomerName= rs.getString(3);
            String id = rs.getString(1);
            String Payment = rs.getString(4);
            String address = rs.getString(5);
            String num = rs.getString(2);

            customers.add(new ResponsibleCusto( id,CustomerName,num,Payment,address));

        }
        return customers;

    }

    @FXML
    public ObservableList<Product> getProduct() throws SQLException {

        String query = " Select UrunID,UrunAdi,BirimdekiMiktar,BirimFiyati,HedefStokDuzeyi  from Urunler";

        rs = s.executeQuery(query);

        ObservableList<Product> products = FXCollections.observableArrayList();

        while (rs.next()){

            String name= rs.getString(2);
            String amount = rs.getString(3);
            String id = rs.getString(1);
            String price = rs.getString(4);
            String stok = rs.getString(5);

            products.add(new Product( id,name,price,amount,stok));
        }
        return products;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Account();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
