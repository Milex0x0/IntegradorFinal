/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cofig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ursula
 */
public class Conexion 
{
    public String driver = "com.mysql.cj.jdbc.Driver";
    public Connection getConnection ()
    {
        Connection conexion = null;
        try
        {
            Class.forName(driver);
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud2159","root","");
            
        }
        catch(ClassNotFoundException | SQLException e) 
        {
            System.out.println(e.toString());
        }
        return conexion;
    }
}

