package com.example.nypproje;


import java.sql.*;
import java.util.Random;


public class nn {
    public static void main(String[] args) throws SQLException {
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost;encrypt=true;database=Northwind;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        Connection con = DriverManager.getConnection(connectionUrl);

        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM Personeller");


        while (rs.next()) {

            String id = rs.getString(1);



            String sifre = generatePassword();
            System.out.println("UPDATE Musteriler SET Musteri =\'"+"C:\\Users\\Nuceyma\\IdeaProjects\\NYPProje\\src\\main\\java\\com\\example\\nypproje\\Personeller photo\\1.jpg"+"\' WHERE PersonelID = \'"+id+"\'");

        }




        System.out.println("tamam");
    }

    public static String generatePassword() {
        int length = 5;
        String symbol = "-/.^&*_!@%=+>)";
        String cap_letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small_letter = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";


        String finalString = cap_letter + small_letter +
                numbers ;

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
