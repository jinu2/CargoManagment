package com.example.nypproje;

import javafx.beans.property.SimpleStringProperty;

public class PastOrder {
    SimpleStringProperty name ;
    SimpleStringProperty price;
    SimpleStringProperty cargo ;

    public String getCargoprice() {
        return cargoprice.get();
    }

    public SimpleStringProperty cargopriceProperty() {
        return cargoprice;
    }

    public void setCargoprice(String cargoprice) {
        this.cargoprice.set(cargoprice);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCargo() {
        return cargo.get();
    }

    public SimpleStringProperty cargoProperty() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo.set(cargo);
    }

    SimpleStringProperty cargoprice;

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public PastOrder(String name, String price, String cargo, String cargoprice){
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleStringProperty(price);
        this.cargo  = new SimpleStringProperty(cargo);
        this.cargoprice   = new SimpleStringProperty(cargoprice);
    }

}
