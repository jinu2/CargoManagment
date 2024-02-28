package com.example.nypproje;

import javafx.beans.property.SimpleStringProperty;

public class Customer {
    SimpleStringProperty name ;
    SimpleStringProperty lname;
    SimpleStringProperty adres ;
    SimpleStringProperty phon ;
    SimpleStringProperty cod ;

    int index;
    SimpleStringProperty st ;
    SimpleStringProperty coun ;
    SimpleStringProperty pass;
    SimpleStringProperty  id ;

    public String getCod() {
        return cod.get();
    }

    public String getAdres() {
        return adres.get();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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

    public String getSt() {
        return st.get();
    }

    public SimpleStringProperty stProperty() {
        return st;
    }

    public void setSt(String st) {
        this.st.set(st);
    }

    public SimpleStringProperty adresProperty() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres.set(adres);
    }

    public String getPhon() {
        return phon.get();
    }

    public SimpleStringProperty phonProperty() {
        return phon;
    }

    public void setPhon(String phon) {
        this.phon.set(phon);
    }

    public String getCoun() {
        return coun.get();
    }

    public String getPass() {
        return pass.get();
    }

    public SimpleStringProperty passProperty() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass.set(pass);
    }

    public SimpleStringProperty counProperty() {
        return coun;
    }

    public void setCoun(String coun) {
        this.coun.set(coun);
    }

    public SimpleStringProperty codProperty() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod.set(cod);
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

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }


    public void setName(String fname) {
        this.name.set(fname);
    }

    public Customer(String fname,  String adres, String phon, String cod
    , String st, String coun, String pass, String id){
        this.name = new SimpleStringProperty(fname);
        this.adres = new SimpleStringProperty(adres);
        this.phon  = new SimpleStringProperty(phon);
        this.cod   = new SimpleStringProperty(cod);
        this.coun  = new SimpleStringProperty(coun);
        this.pass  = new SimpleStringProperty(pass);
        this.id    = new SimpleStringProperty(id);
        this.st    = new SimpleStringProperty(st);
    }
}
