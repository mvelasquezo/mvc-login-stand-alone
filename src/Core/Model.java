package Core;

import java.sql.Connection;
import java.sql.DriverManager;
import App.Config;

public class Model {
    
    private Connection con;
    
    public Connection getCon() {
        try{
            //Class.forName( "com.mysql.jdbc.Driver" );
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            
            con = DriverManager.getConnection( Config.URL, Config.DB_USR, Config.DB_PSS );
        } catch(Exception ex) {
            System.err.println(ex.toString());
        }
        return con;
    }
    
}
