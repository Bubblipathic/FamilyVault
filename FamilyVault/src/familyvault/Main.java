/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package familyvault;

/**
 *
 * @author Jay
 */

import java.sql.*;
import javax.swing.JOptionPane;

public class Main {
    
    public static void connect() {
        //DB Variables


        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/pdbjay", "system", "Jmr#1203");
 
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public static void main(String args[]) {
        connect();
        new LogIn().setVisible(true); 
    }
}
