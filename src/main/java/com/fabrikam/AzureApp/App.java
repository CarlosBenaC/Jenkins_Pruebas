package com.fabrikam.AzureApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
        	
            String hostName = "wittpruebaproyectoserver1.database.windows.net";
            String dbName = "wittPruebaProyectoBBDD1";
            String user = "wittCarlosBenaC@wittpruebaproyectoserver1";
            String password = "InTeNtIcUlA001";
            String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
             
            Connection connection = null;
            
            // connect to the database
            connection = DriverManager.getConnection(url);

            //String createTable = "CREATE TABLE CLOUD ( name varchar(255), code int);";
            //String insertValues = "INSERT INTO CLOUD (name, code ) VALUES ('Azure', 1);";
            
            String selectValues = "SELECT * FROM wittPruebaBBDDTabla1";
            
            //Statement createStatement = conn.createStatement();
            //createStatement.execute(createTable);
            //Statement insertStatement = conn.createStatement();
            //insertStatement.execute(insertValues);
            Statement selectStatement = connection.createStatement();
            ResultSet rst = selectStatement.executeQuery(selectValues);

            while (rst.next()) {
                System.out.println(rst.getString(1) + " "
                        + rst.getString(2));
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace().toString());
        }
        
        
        
        
        
        
        
    }
}
