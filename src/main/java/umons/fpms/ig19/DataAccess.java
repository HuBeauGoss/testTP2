/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umons.fpms.ig19;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.ibatis.jdbc.ScriptRunner;

/**
 *
 * @author noffa
 */
public class DataAccess {

    private static final String DBUSER = "user01";
    private static final String DBPASS = "user01";
    public static final String DBNAME = DBUSER + "_test_java";
    private static final String DBHOST = "192.168.250.3";
    private static final String DBSERVER = "mysql";
    private static final String DBPORT = "3306";
    private static final String DSN = "jdbc:" + DBSERVER + "://" + DBHOST + ":" + DBPORT + "/" + "?useUnicode=true" +
        "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" +
        "serverTimezone=UTC";
    
    private static boolean online = false;
    public static Connection connect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // com.mysql.jdbc.Driver is drepracated.
            con = DriverManager.getConnection(DSN, DBUSER, DBPASS);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SHOW DATABASES LIKE '" + DBNAME + "';");  // Looking if the Schema is already created.
            if(!rs.next()) {
                try (Reader reader = new BufferedReader(new FileReader("./db.sql"))) {
                    System.out.println("Creating the Schema. '" + DBNAME + "'.");
                    ScriptRunner runner = new ScriptRunner(con);
                    runner.runScript(reader);
                }
            }
            con.setCatalog(DBNAME);  // Setting the DB of the used connection
            online = true;
        } catch(FileNotFoundException | ClassNotFoundException | SQLException  e) {
            System.out.println("exception: " + e.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException : " + ex);
        } finally {
            if(online) {
                System.out.println("Connection Established... ");
            } else {
                System.out.println("Connection Not Established");
            }
        }
        return con;
    }
}
