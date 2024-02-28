package com.example.nypproje;


import java.sql.*;
import java.util.Objects;

public class Test {

    Statement s;
    ResultSet rs;

    public Test() throws SQLException {
        String connectionUrl = "jdbc:sqlserver://localhost;encrypt=true;database=Northwind;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        Connection con = DriverManager.getConnection(connectionUrl);

        s = con.createStatement();
    }

    public boolean logInC(String username, String password) throws SQLException {
        boolean val = false;

        while (rs.next()) {
            if (Objects.equals(username, rs.getString("MusteriID"))) {
                if (Objects.equals(password, rs.getString("sifre"))) {
                    val = true;
                    break;
                }
            }
        }

        return val;
    }

    public boolean logInE(String username, String password) throws SQLException {
        boolean val = false;
        while (rs.next()) {
            if (Objects.equals(username, rs.getString("PersonelID"))) {
                if (Objects.equals(password, rs.getString("sifre"))) {
                    val = true;
                    break;
                }
            }
        }
        return val;
    }


    public void setLogInC() throws SQLException {
        rs = s.executeQuery("SELECT MusteriID, sifre FROM Musteriler");
    }
    public void setLogInE() throws SQLException {
        rs = s.executeQuery("SELECT PersonelID, sifre FROM Personeller");
    }
}