/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umons.fpms.ig19;

import java.sql.Connection;
import java.sql.Statement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author noffa
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({DataAccessTest.class, ProfTest.class, CoursTest.class})
public class Ig19Suite {

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Suite.BeforeCLass.setUpClass");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("Suite.AfterClass.tearDownClass");
        try (Connection con = DataAccess.connect()) {
            try (Statement stm = con.createStatement()) {
                if(stm.execute("DROP SCHEMA " + DataAccess.DBNAME + ";")) {
                    System.out.println("SCHEMA '" + DataAccess.DBNAME + "' was DELETED.");
                }
            }
        }
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Suite.Before.setUp");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Suite.After.tearDown");
    }
}
