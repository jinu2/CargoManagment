package com.example.nypproje;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class MainPageC implements Initializable {

    public static String userID;

    public static String getUserID() {
        return userID;
    }

    public static void setUserID(String userID) {
        MainPageC.userID = userID;
    }

    @FXML
    private Pane account;

    @FXML
    private AnchorPane ap;

    @FXML
    private Pane image;

    @FXML
    private Pane products;

    @FXML
    private Pane rescus;

    @FXML
    private Pane resorders;

    @FXML
    private Pane shippers;

    @FXML
    private Button up;

    @FXML
    private Button down;

    @FXML
    private Label quantity;

    @FXML
    private ComboBox<String> productID;


    @FXML
    private TextField acc_adres;

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
    private Label acc_error;

    @FXML
    private TextField acc_com;

    @FXML
    private TextField acc_postalcode;


    @FXML
    private TableColumn<PastOrder, String> col1;

    @FXML
    private TableColumn<Product, String> col1p;

    @FXML
    private TableColumn<PastOrder, String> col2;

    @FXML
    private TableColumn<Product, String> col2p;

    @FXML
    private TableColumn<PastOrder, String> col3;

    @FXML
    private TableColumn<Product, String> col3p;

    @FXML
    private TableColumn<PastOrder, String> col4;

    @FXML
    private TableColumn<Product, String> col4p;

    @FXML
    private ImageView photo;


    @FXML
    private TableView<PastOrder> table;

    @FXML
    private TableView<Product> tablep;

    @FXML
    private TextField totalprice;

    ArrayList<Product> takenproduct = new ArrayList<>();
    ArrayList<String> takencargo = new ArrayList<>();
    ArrayList<String> takencprice = new ArrayList<>();
    ArrayList<String> listcargo = new ArrayList<>();





    @FXML
    void LogOut(ActionEvent event) throws SQLException, IOException {

        ap.getScene().getWindow().hide();
        LoginController mp = new LoginController();
        mp.createPage();

    }

    @FXML
    void Account() throws SQLException {
        account.setVisible(true);
        account.setOpacity(1);
        products.setVisible(false);
        resorders.setVisible(false);

        int index = getCustomers1().indexOf(userID);
        Customer c = getCustomers().get(index);


        acc_id.setText(c.getId());
        acc_name.setText(c.getName());
        acc_adres.setText(c.getAdres());
        acc_city.setText(c.getSt());
        acc_country.setText(c.getCoun());
        acc_postalcode.setText(c.getCod());
        acc_phone.setText(c.getPhon());



    }
    ArrayList<Integer> listID = new ArrayList<>();
    @FXML
    void TakeOrder(ActionEvent event) throws SQLException {
        if(quantity.getText()!="") {
            int quan = Integer.parseInt(quantity.getText());
            String id = productID.getSelectionModel().getSelectedItem();

            String price = totalprice.getText();
            int index = getProductsID().indexOf(productID.getSelectionModel().getSelectedItem());
            int stok = Integer.parseInt(getProduct().get(index).getStok());
            int newstok = stok - quan;
            productID.setPromptText("Select product ID");
            quantity.setText("");
            totalprice.setText("");


        String query = "UPDATE Urunler SET HedefStokDuzeyi="+newstok+" WHERE UrunID=" +id;
        s.executeUpdate(query);

            String name = getProduct().get(index).getProductName();
            String pr_price = getProduct().get(index).getPrice();
            String  am = getProduct().get(index).getAmount();
            listcargo.add("Speedy Express");
            listcargo.add("United Package");
            listcargo.add("Federal Shipping");

            Random rand = new Random();
            int num = rand.nextInt(1000) + 1000;

            if (!listID.contains(num)) {
                listID.add(num);
            } else {
                num = rand.nextInt(1000) + 1000;
                listID.add(num);
            }

            System.out.println(listID);
            String cusid = getCustomers().get(0).getId();
            int cargo = rand.nextInt(30);
            String car=String.valueOf(cargo);

            int shipvia = rand.nextInt(3);
            String cargoname =  listcargo.get(shipvia);
            String address = getCustomers().get(0).getAdres();
            String city = getCustomers().get(0).getSt();
            String code = getCustomers().get(0).getCod();
            String country = getCustomers().get(0).getCoun();

            takenproduct.add(new Product(id,name,pr_price,am,String.valueOf(quan)));
            takencargo.add(cargoname);
            takencprice.add(car);


//        query = "INSERT INTO Satislar (MusteriID,PersonelID,NakliyeUcreti,ShipVia,SevkAdresi,SevkSehri,SevkUlkesi,SevkPostaKodu)\n" +
//                "VALUES (\'"+cusid+"\',4, "+car+", "+shipvia+", \'"+address+"\',\'"+city+"\',\'"+country+"\',\'"+code+"\')";
//            System.out.println(query);
//
//        s.executeUpdate(query);



        }
    }
    @FXML
    void Up(ActionEvent event) throws SQLException {
        if(quantity.getText()==""){

        }else {
           int index = getProductsID().indexOf(productID.getSelectionModel().getSelectedItem());
           int stok = Integer.parseInt(getProduct().get(index).getStok());

            double price = Double.parseDouble(getProduct().get(index).getPrice());
            int quan = Integer.parseInt(quantity.getText());
            if ((quan + 1) > stok) {

            } else {
                quan += 1;
                quantity.setText(String.valueOf(quan));
                double pr = price * quan;
                totalprice.setText(String.valueOf(pr));
            }
        }

    }
    @FXML
    void Down(ActionEvent event) throws SQLException {
        if(quantity.getText()==""){

        }else {
            int index = getProductsID().indexOf(productID.getSelectionModel().getSelectedItem());
            int stok = Integer.parseInt(getProduct().get(index).getStok());
            double price = Double.parseDouble(getProduct().get(index).getPrice());
            int quan = Integer.parseInt(quantity.getText());
            if ((quan - 1) <= 0) {

            } else {
                quan -= 1;
                quantity.setText(String.valueOf(quan));
                double pr = price * quan;
                totalprice.setText(String.valueOf(pr));
            }
        }

    }

    @FXML
    void Orders(ActionEvent event) {
        account.setVisible(false);
        products.setVisible(false);
        resorders.setVisible(true);
        resorders.setOpacity(1);


        col1.setCellValueFactory(new PropertyValueFactory<>("name"));
        col2.setCellValueFactory(new PropertyValueFactory<>("price"));
        col3.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        col4.setCellValueFactory(new PropertyValueFactory<>("cargoprice"));

        try {
            table.setItems(getPastOrders());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        table.setEditable(true);
        col1.setCellFactory(TextFieldTableCell.forTableColumn());
        col2.setCellFactory(TextFieldTableCell.forTableColumn());
        col3.setCellFactory(TextFieldTableCell.forTableColumn());
        col4.setCellFactory(TextFieldTableCell.forTableColumn());



    }

    @FXML
    void Product(ActionEvent event) throws SQLException {
        account.setVisible(false);
        products.setVisible(true);
        resorders.setVisible(false);
        products.setOpacity(1);

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

        productID.setItems(getProductsID());

        productID.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            System.out.println(newValue);
            quantity.setText("1");

            //int id = Integer.parseInt(productID.getSelectionModel().getSelectedItem());

            try {
                int index= getProductsID().indexOf(newValue);
                String price = getProduct().get(index).getPrice();
                totalprice.setText(price);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        });


    }

    @FXML
    void change(ActionEvent event) throws SQLException {


        String oldPassword = acc_oldpass.getText();
        String newPassword = acc_newpass.getText();
        getCustomers1().indexOf(userID);
        getCustomers().get(getCustomers1().indexOf(userID)).getPass().equals(newPassword);


        if(getCustomers().get(getCustomers1().indexOf(userID)).getPass().equals(oldPassword)){
            if(newPassword!="" && newPassword.length()>=5){
                acc_error.setText("Password successfully changed!");
                String query = "UPDATE Musteriler SET sifre=\'"+newPassword+"\' WHERE MusteriID=\'" +userID+"\'";
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



    Statement s;
    ResultSet rs;


    public void initialize(URL url, ResourceBundle rb) throws RuntimeException {

        try {
            Account();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public MainPageC() throws SQLException {
        String connectionUrl = "jdbc:sqlserver://localhost;encrypt=true;database=Northwind;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        Connection con = DriverManager.getConnection(connectionUrl);
        s = con.createStatement();
    }

    public void createPage(String username) throws IOException, SQLException {
        setUserID(username);
        Stage stage = new Stage();
        stage.getIcons().add(new Image("C:\\Users\\Nuceyma\\IdeaProjects\\NYPProje\\src\\main\\java\\com\\example\\nypproje\\cargo.png"));
        stage.setTitle("Cargo!");
        Parent root = (Parent) FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("MainPageC.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public ArrayList<String> getCustomers1() throws SQLException {

        String query = "SELECT MusteriID\n" +
                "      ,MusteriAdi\n" +
                "      ,Adres\n" +
                "      ,Sehir\n" +
                "      ,PostaKodu\n" +
                "      ,Ulke\n" +
                "      ,Telefon\n" +
                "      ,sifre\n" +
                "  FROM Musteriler where MusteriID = '"+userID+"'";

        rs = s.executeQuery(query);

        ArrayList<String> customers1 = new ArrayList<>();
        ObservableList<Customer> customers = FXCollections.observableArrayList();


        while (rs.next()){

            String id = rs.getString(1);
            String fname = rs.getString(2);
            String adres = rs.getString(3);
            String phon = rs.getString(7);
            String cod = rs.getString(5);
            String st = rs.getString(4);
            String coun = rs.getString(6);
            String pass = rs.getString(8);

            customers.add(new Customer(  fname,   adres,  phon,  cod
                    ,  st,  coun,  pass,  id));
//            customers1.add(new Customer(  fname,   adres,  phon,  cod
//                    ,  st,  coun,  pass,  id));
            customers1.add(id);

        }
        return customers1;

    }
    @FXML
    public ArrayList<Customer> getCustomers() throws SQLException {

        String query = "SELECT MusteriID\n" +
                "      ,MusteriAdi\n" +
                "      ,Adres\n" +
                "      ,Sehir\n" +
                "      ,PostaKodu\n" +
                "      ,Ulke\n" +
                "      ,Telefon\n" +
                "      ,sifre\n" +
                "  FROM Musteriler where MusteriID = '"+userID+"'";

        rs = s.executeQuery(query);

        ArrayList<Customer> customers = new ArrayList<>();


        while (rs.next()){

            String id = rs.getString(1);
            String fname = rs.getString(2);
            String adres = rs.getString(3);
            String phon = rs.getString(7);
            String cod = rs.getString(5);
            String st = rs.getString(4);
            String coun = rs.getString(6);
            String pass = rs.getString(8);

            customers.add(new Customer(  fname,   adres,  phon,  cod
                    ,  st,  coun,  pass,  id));


        }
        return customers;

    }

    @FXML
    public ObservableList<Product> getProduct() throws SQLException {

        String query = " Select UrunID,UrunAdi,BirimdekiMiktar,BirimFiyati,HedefStokDuzeyi from Urunler where HedefStokDuzeyi>0";

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

    @FXML
    public ObservableList<String> getProductsID() throws SQLException {


        ObservableList<String> ids = FXCollections.observableArrayList();
        for(int i=0; i<getProduct().size(); i++){
            ids.add(getProduct().get(i).getId());
        }


        return ids;

    }

    @FXML
    public ObservableList<PastOrder> getPastOrders() throws SQLException {

        String query = " SELECT UrunAdi,([Satis Detaylari].BirimFiyati*Miktar) as price,Satislar.NakliyeUcreti,Nakliyeciler.SirketAdi,SatisTarihi FROM Satislar\n" +
                "   left join  Musteriler on Satislar.MusteriID = Musteriler.MusteriID \n" +
                "   left join  [Satis Detaylari] on Satislar.SatisID = [Satis Detaylari].SatisID \n" +
                "   left join  Urunler on [Satis Detaylari].UrunID = Urunler.UrunID \n" +
                "   left join  Nakliyeciler on Satislar.ShipVia = Nakliyeciler.NakliyeciID \n" +
                "   where Musteriler.MusteriID =\'"+userID+"\'";

        rs = s.executeQuery(query);

        ObservableList<PastOrder> orders = FXCollections.observableArrayList();

        while (rs.next()){

            String name= rs.getString(1);
            String cargoprice = rs.getString(3);
            String cargo = rs.getString(4);
            String price = rs.getString(2);


            orders.add(new PastOrder( name,price,cargo,cargoprice));
        }
        if(!takenproduct.isEmpty()){
            for(int i=0;i<takenproduct.size();i++){
                Product p = takenproduct.get(i);
                orders.add(new PastOrder(p.getProductName(),p.getPrice(),takencargo.get(i),takencprice.get(i)));

            }
        }
        return orders;
    }




}
