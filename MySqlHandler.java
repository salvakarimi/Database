/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foofle;

import java.sql.*;

public class MySqlHandler {

    public static void getAllNews() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "root", "");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("{call get_news() }");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "  " + rs.getInt(2) + "  " + rs.getString(3));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void addAccount(String[] splittedAccountInfo) {
        //firstname lastname username pass birthdate address mobile
        String firstName = splittedAccountInfo[0];
        String lastName = splittedAccountInfo[1];
        String nickName = splittedAccountInfo[2];
        String username = splittedAccountInfo[3];
        String pass = splittedAccountInfo[4];
        //String birthdate = splittedAccountInfo[5];
        String address = splittedAccountInfo[5];
        String mobile = splittedAccountInfo[6];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "root", "");
            String query = "{call add_account(?,?,?,?,?,?,?,?) }";
            CallableStatement stmt = con.prepareCall(query);
            stmt.setString(1, address);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.setString(4, nickName);
            stmt.setString(5, username);
            stmt.setString(6, pass);
            stmt.setString(7, mobile);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void updateAccount(String[] splittedAccountInfo) {
        //firstname lastname username pass birthdate address mobile
        String firstName = splittedAccountInfo[0];
        String lastName = splittedAccountInfo[1];
        String nickName = splittedAccountInfo[2];
        String username = splittedAccountInfo[3];
        String pass = splittedAccountInfo[4];
        //String birthdate = splittedAccountInfo[5];
        String address = splittedAccountInfo[5];
        String mobile = splittedAccountInfo[6];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "root", "");
            String query = "{call update_account(?,?,?,?,?,?,?) }";
            CallableStatement stmt = con.prepareCall(query);
            stmt.setString(1, address);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.setString(4, nickName);
            stmt.setString(5, username);
            stmt.setString(6, pass);
            stmt.setString(7, mobile);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void login(String[] splittedAccountInfo) {
        //username pass
        String username = splittedAccountInfo[0];
        String pass = splittedAccountInfo[1];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "root", "");
            String query = "{call add_login(?,?,?) }";
            CallableStatement stmt = con.prepareCall(query);
            stmt.setString(1, username);
            stmt.setString(2, pass);
            stmt.setString(3, "Welcome to Foofle");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteAccount() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/projectdb", "root", "");
            String query = "{call delete_account() }";
            CallableStatement stmt = con.prepareCall(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
