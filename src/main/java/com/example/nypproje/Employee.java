package com.example.nypproje;

import javafx.beans.property.SimpleStringProperty;

public class Employee {

    SimpleStringProperty fname ;
    SimpleStringProperty lname;
    SimpleStringProperty position ;
    SimpleStringProperty dob ;
    SimpleStringProperty dateofjob ;
    SimpleStringProperty adres ;
    SimpleStringProperty city ;
    SimpleStringProperty postalcode;
    SimpleStringProperty  id ;
    SimpleStringProperty  phone ;
    SimpleStringProperty  photo ;

    public String getPassword() {
        return password.get();
    }

    public String getAdres() {
        return adres.get();
    }

    public String getDegree() {
        return degree.get();
    }

    public String getFname() {
        return fname.get();
    }

    public SimpleStringProperty fnameProperty() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname.set(fname);
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

    public SimpleStringProperty degreeProperty() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree.set(degree);
    }

    public String getPhoto() {
        return photo.get();
    }

    public String getLname() {
        return lname.get();
    }

    public SimpleStringProperty lnameProperty() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname.set(lname);
    }

    public SimpleStringProperty photoProperty() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo.set(photo);
    }

    public String getPosition() {
        return position.get();
    }

    public SimpleStringProperty positionProperty() {
        return position;
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    public String getPhone() {
        return phone.get();
    }

    public String getDateofjob() {
        return dateofjob.get();
    }

    public SimpleStringProperty dateofjobProperty() {
        return dateofjob;
    }

    public void setDateofjob(String dateofjob) {
        this.dateofjob.set(dateofjob);
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getDob() {
        return dob.get();
    }

    public SimpleStringProperty dobProperty() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob.set(dob);
    }

    public SimpleStringProperty adresProperty() {
        return adres;
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

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public void setAdres(String adres) {
        this.adres.set(adres);
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    SimpleStringProperty  degree;
    SimpleStringProperty  password;

    public String getCountry() {
        return country.get();
    }

    public SimpleStringProperty countryProperty() {
        return country;
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    SimpleStringProperty  country;

    public Employee(String fname, String lname, String position, String dob, String dateofjob,String country
            , String adres, String city, String postalcode, String phone,String id,String photo,String password,String degree){

        this.fname = new SimpleStringProperty(fname);
        this.lname = new SimpleStringProperty(lname);
        this.adres = new SimpleStringProperty(adres);
        this.position  = new SimpleStringProperty(position);
        this.dob   = new SimpleStringProperty(dob);
        this.dateofjob  = new SimpleStringProperty(dateofjob);
        this.city  = new SimpleStringProperty(city);
        this.postalcode    = new SimpleStringProperty(postalcode);
        this.phone    = new SimpleStringProperty(phone);
        this.photo  = new SimpleStringProperty(photo);
        this.password  = new SimpleStringProperty(password);
        this.id    = new SimpleStringProperty(id);
        this.degree    = new SimpleStringProperty(degree);
        this.country    = new SimpleStringProperty(country);
    }


}
