package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre
 */
public class DAOConexao {
    
    public Statement stm;
    public ResultSet rs;
    public Connection con;    
    private final String driver;
    private final String host;
    private final String user;
    private final String pass;
        
    public DAOConexao(){

        this.host = "jdbc:mysql://localhost:3306/bd_sistemapdv";
        this.driver = "com.mysql.jdbc.Driver";
        this.user = "root";
        this.pass = "";

    }
    
    public boolean Conecta(){

        try {
            System.setProperty("jdbc.Drivers", driver);
            con = DriverManager.getConnection(host, user, pass);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NA CONEXÃO", "AVISO", JOptionPane.OK_OPTION);
        }
        return false;
    }
    
    public void Desconecta(){
        
        try {
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NA DESCONEXÃO", "AVISO", JOptionPane.OK_OPTION);
        }
        
        
    }
    
    public void executaSQL(String sql){
        
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "ERRO NA EXECUÇÃO DA SQL", "AVISO", JOptionPane.OK_OPTION);
        }
                
        
    }
    
}
