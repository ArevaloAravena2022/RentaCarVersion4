/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Aravena A
 */
public class tablaContrato {
 
    
    public String dataBase = "RentaCar";
    public String url = "jdbc:mysql://localhost/"+dataBase;
    public String user = "root";
    public String pass = "";

    public tablaContrato()
    {

    } 
    public Connection Conectar()
    {
        Connection link = null;
        try
        {
            //Se carga el driver de MySQL
            Class.forName("org.gjt.mm.mysql.Driver");
            //Se crea un enlace a la base de datos 
            link = DriverManager.getConnection(this.url, this.user, this.pass);
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return link;
    }
    
    public int CantidadRegistros() throws SQLException
    {
        int RegistroTotal;
        Connection link = DriverManager.getConnection(this.url, this.user, this.pass);
        Conectar();
        Statement stm = link.createStatement();
        ResultSet rs = stm.executeQuery("Select count(*) from Contrato");
        RegistroTotal = rs.getInt("count(*)");
        return RegistroTotal;
    }
}