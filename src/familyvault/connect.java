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
import java.lang.Exception;

public class connect {
 
    public static Connection Connect(){
        
        
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/pdbjay","system","Jmr#1203");
            return con;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
