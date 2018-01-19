package crud;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author JorgeDelgado
 */
public class conexion {
    
    private Connection conexion;
    private Statement statem;
    private TipoBaseDatos TipoBD;
    private Boolean AutoCommit;
            
    public void OpenConnection(){
       
        TipoBD = TipoBaseDatos.Mysql;
        AutoCommit = false;
        conexion = ConexionBD("localhost","root","","practica","3306");
        statem = CreateStatement();
    }
    
    public Boolean getConexion(){
        return conexion == null;
    }
    
    public ResultSet getQuery(String Query) throws SQLException{
        
        ResultSet rset = null;
        try{
             rset = getDataConnection(Query);
            
        }catch(Exception ex){
            throw new SQLException(ex.toString());
        }
        
        return rset;
    }
    
    public String executeQuery(String Query) throws SQLException{
        try {
            statem.executeUpdate(Query);
            
            return "1";
        } catch (SQLException ex) {
            throw new SQLException(ex.toString());
        }
    }
    
    public void Commit() throws SQLException{
        conexion.commit();
    }
    
    public void Rollback() throws SQLException{
        conexion.rollback();
    }
    
    private Connection ConexionBD(String URL, String User, String Pass, String DB, String Puerto){
        try{
            String BaseDeDatos = "";
            
            if(TipoBD == TipoBaseDatos.Oracle){
                Class.forName("oracle.jdbc.OracleDriver");
                BaseDeDatos = "jdbc:oracle:thin:@"+URL+":"+Puerto+":"+DB+"";
            }  
            
            if(TipoBD == TipoBaseDatos.Mysql){
                Class.forName("com.mysql.jdbc.Driver");
                BaseDeDatos = "jdbc:mysql://"+URL+":"+Puerto+"/"+DB;
            }
            
            if(TipoBD == TipoBaseDatos.Sql){
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                BaseDeDatos = "jdbc:sqlserver://"+URL+":"+Puerto+";databaseName="+DB; 
            }
            
            if(TipoBD == TipoBaseDatos.Postgresql){
                Class.forName("org.postgresql.Driver");
                BaseDeDatos = "jdbc:postgresql://"+URL+":"+Puerto+"/"+DB; 
            }
            
            Connection conexion = DriverManager.getConnection(BaseDeDatos,User, Pass);
            
            conexion.setAutoCommit(AutoCommit);
            
            return conexion;
            
        }catch(Exception ex){
            return null;
        }
    }
            
    private ResultSet getDataConnection(String Query) throws SQLException{
        
        ResultSet rset = null;
        
        if (conexion != null) 
            rset = executeQuery(conexion, Query);
        
        else 
            System.out.println("Conexion fallida!");
        
        return rset;
    }
    
    private ResultSet executeQuery(Connection conexion, String Query) throws SQLException{
        
        Statement stmt = conexion.createStatement();
        ResultSet rset = stmt.executeQuery(Query);
        
        return rset;
    }
    
    private Statement CreateStatement(){
        try{
            return conexion.createStatement();
            
        }catch(Exception ex){return null;}
    }
    
    public void CloseConnection() throws SQLException{
        statem.close();
        conexion.close();
    }
    
    public enum TipoBaseDatos{
        Oracle, Mysql, Sql, Postgresql;
    }
    
}
