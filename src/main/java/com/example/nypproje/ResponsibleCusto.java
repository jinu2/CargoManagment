package com.example.nypproje;

import javafx.beans.property.SimpleStringProperty;

public class ResponsibleCusto {

    SimpleStringProperty id ;
    SimpleStringProperty CustomerName;

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    SimpleStringProperty numberoforder;

    public String getCustomerName() {
        return CustomerName.get();
    }

    public SimpleStringProperty customerNameProperty() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        this.CustomerName.set(customerName);
    }

    public String getNumberoforder() {
        return numberoforder.get();
    }

    public SimpleStringProperty numberoforderProperty() {
        return numberoforder;
    }

    public void setNumberoforder(String numberoforder) {
        this.numberoforder.set(numberoforder);
    }

    SimpleStringProperty Payment;

    public String getPayment() {
        return Payment.get();
    }

    public SimpleStringProperty paymentProperty() {
        return Payment;
    }

    public void setPayment(String payment) {
        this.Payment.set(payment);
    }

    SimpleStringProperty address;

    public ResponsibleCusto(String id, String CustomerName, String number, String Payment, String address){
        this.id = new SimpleStringProperty(id);
        this.CustomerName = new SimpleStringProperty(CustomerName);
        this.numberoforder = new SimpleStringProperty(number);
        this.Payment  = new SimpleStringProperty(Payment);
        this.address   = new SimpleStringProperty(address);
    }
}
