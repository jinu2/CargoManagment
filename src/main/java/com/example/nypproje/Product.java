package com.example.nypproje;

import javafx.beans.property.SimpleStringProperty;

public class Product {

    SimpleStringProperty id ;
    SimpleStringProperty ProductName;
    SimpleStringProperty Price;
    SimpleStringProperty Amount;
    SimpleStringProperty Stok;

    public String getStok() {
        return Stok.get();
    }

    public SimpleStringProperty stokProperty() {
        return Stok;
    }

    public void setStok(String stok) {
        this.Stok.set(stok);
    }

    public String getProductName() {
        return ProductName.get();
    }

    public SimpleStringProperty productNameProperty() {
        return ProductName;
    }

    public void setProductName(String productName) {
        this.ProductName.set(productName);
    }

    public String getAmount() {
        return Amount.get();
    }

    public SimpleStringProperty amountProperty() {
        return Amount;
    }

    public void setAmount(String amount) {
        this.Amount.set(amount);
    }

    public String getId() {
        return id.get();
    }

    public String getPrice() {
        return Price.get();
    }

    public SimpleStringProperty priceProperty() {
        return Price;
    }

    public void setPrice(String price) {
        this.Price.set(price);
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }


    public Product(String id, String ProductName, String Price, String Amount,String stok){

        this.id = new SimpleStringProperty(id);
        this.ProductName = new SimpleStringProperty(ProductName);
        this.Price = new SimpleStringProperty(Price);
        this.Amount  = new SimpleStringProperty(Amount);
        this.Stok  = new SimpleStringProperty(stok);

    }

}
