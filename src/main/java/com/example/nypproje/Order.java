package com.example.nypproje;

import javafx.beans.property.SimpleStringProperty;

public class Order {
    SimpleStringProperty id ;
    SimpleStringProperty CustomerName;
    SimpleStringProperty CompanyName;
    SimpleStringProperty Payment;
    SimpleStringProperty address;
    SimpleStringProperty city;
    SimpleStringProperty postalcode;
    SimpleStringProperty country;

    SimpleStringProperty connect;

    public String getConnect() {
        return connect.get();
    }

    public SimpleStringProperty connectProperty() {
        return connect;
    }

    public void setConnect(String address,String city,String country,String code) {
        this.connect.set(address+", "+city+" "+code+ ", "+ country);
    }

    public String getCustomerName() {
        return CustomerName.get();
    }

    public SimpleStringProperty customerNameProperty() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        this.CustomerName.set(customerName);
    }

    public String getCity() {
        return city.get();
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getCompanyName() {
        return CompanyName.get();
    }

    public SimpleStringProperty companyNameProperty() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        this.CompanyName.set(companyName);
    }

    public String getCountry() {
        return country.get();
    }

    public SimpleStringProperty countryProperty() {
        return country;
    }

    public void setCountry(String country) {
        this.country.set(country);
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

    public String getPostalcode() {
        return postalcode.get();
    }

    public SimpleStringProperty postalcodeProperty() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode.set(postalcode);
    }

    public String getPayment() {
        return Payment.get();
    }

    public SimpleStringProperty paymentProperty() {
        return Payment;
    }

    public void setPayment(String payment) {
        this.Payment.set(payment);
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public Order(String id, String CustomerName, String CompanyName, String Payment, String address, String country
            , String city, String postalcode){

        this.id = new SimpleStringProperty(id);
        this.CustomerName = new SimpleStringProperty(CustomerName);
        this.CompanyName = new SimpleStringProperty(CompanyName);
        this.Payment  = new SimpleStringProperty(Payment);
        this.address   = new SimpleStringProperty(address);
        this.city  = new SimpleStringProperty(city);
        this.postalcode    = new SimpleStringProperty(postalcode);
        this.country    = new SimpleStringProperty(country);
        String s="";
        if(address!=null){s+=address;}
        if(city!=null){s=s+", "+city;}
        if(postalcode!=null){s=s+" "+postalcode;}
        if(country!=null){s=s+", "+country;}
        this.connect = new SimpleStringProperty(s);
    }

}
