/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umons.fpms.ig19;

import umons.fpms.ig19.DataAccess;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author noffa
 */
public class DataAccessTest {
    
    private Connection conn;
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("DataAccess.BeforeClass.setUpClass");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("DataAccess.AfterClass.tearDownClass");
    }
    
    @Before
    public void setUp() {
        System.out.println("DataAccess.Before.setUp");
        conn = DataAccess.connect();
    }
    
    @After
    public void tearDown() {
        System.out.println("DataAccess.After.tearDown");
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            conn = null;
        }
    }

    /**
     * Test of connect method, of class DataAccess.
     */
    @Test
    public void testConnect() {
        System.out.println("DataAccess.Test.connect");
        Connection expResult = conn;
        Connection result = DataAccess.connect();
        assertNotEquals(expResult, result); // two connections are never ever the same.
        System.out.println("Connection test Valid");
    }
    
}
