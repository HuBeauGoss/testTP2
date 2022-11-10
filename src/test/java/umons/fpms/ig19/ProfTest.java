/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umons.fpms.ig19;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;

/**
 *
 * @author noffa
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProfTest {
    private String name;
        String firstname;
        String dateNaiss;
        String lieuNaiss;
    Prof prof;

    public ProfTest() { 
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Prof.BeforeClass.setUpClass");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Prof.AfterClass.tearDownClass");
    }
    
    @Before
    public void setUp() {
        System.out.println("Prof.Before.setUp");
        prof = new Prof("NOFFABEL", "Dadday", "12/07/1989", "Yamoussoukro"); 
    }
    
    @After
    public void tearDown() {
        System.out.println("Prof.After.tearDown");
        prof = null;
    }

    /**
     * Test of getName method, of class Prof.
     */
    @Test
    @Order(1)
    public void testGetName() {
        System.out.println("Prof.Test.getName");
        String expResult = prof.getName();
        String result = "PROF1";
        assertNotEquals(expResult, result);
        
        result = "NOFFABEL";
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Prof.
     */
    @Test
    @Order(2)
    public void testSetName() {
        System.out.println("Prof.Test.setname");
        String lName = "PROF1";
        Prof instance = new Prof();
        instance.setName(lName);
        assertNotEquals(prof.getName(), instance.getName());
        
        lName = "NOFFABEL";
        instance.setName(lName);
        assertEquals(prof.getName(), instance.getName());
    }

    /**
     * Test of getFirstname method, of class Prof.
     */
    @Test
    @Order(3)
    public void testGetFirstname() {
        System.out.println("Prof.Test.getFirstname");
        Prof instance = new Prof(null, "Prof1", null, null);
        String expResult = prof.getFirstname();
        String result = instance.getFirstname();
        assertNotEquals(expResult, result);
        
        instance = new Prof(null, "Dadday", null, null);
        assertEquals(expResult, instance.getFirstname());
    }

    /**
     * Test of setFirstname method, of class Prof.
     */
    @Test
    @Order(4)
    public void testSetFirstname() {
        System.out.println("Prof.Test.setFirstname");
        String lFirstname = "Prof1";
        Prof instance = new Prof();
        instance.setFirstname(lFirstname);
        assertNotEquals(prof.getFirstname(), instance.getFirstname());
        
        lFirstname = "Dadday";
        instance.setFirstname(lFirstname);
        System.out.println(instance.toString());
        assertEquals(prof.getFirstname(), instance.getFirstname());
    }

    /**
     * Test of getDateNaiss method, of class Prof.
     */
    @Test
    @Order(5)
    public void testGetDateNaiss() {
        System.out.println("Prof.Test.getDateNaiss");
        String expResult = prof.getDateNaiss();
        String result = "10/12/1987";
        assertNotEquals(expResult, result);
        
        assertEquals(expResult, "12/07/1989");
    }

    /**
     * Test of setDateNaiss method, of class Prof.
     */
    @Test
    @Order(6)
    public void testSetDateNaiss() {
        System.out.println("Prof.Test.setDateNaiss");
        String lDateNaiss = "10/12/1987";
        Prof instance = new Prof();
        instance.setDateNaiss(lDateNaiss);
        assertNotEquals(prof.getDateNaiss(), instance.getDateNaiss());
        
        lDateNaiss = "12/07/1989";
        instance.setDateNaiss(lDateNaiss);
        assertEquals(prof.getDateNaiss(), instance.getDateNaiss());
    }

    /**
     * Test of getLieuNaiss method, of class Prof.
     */
    @Test
    @Order(7)
    public void testGetLieuNaiss() {
        System.out.println("Prof.Test.getLieuNaiss");
        String expResult = prof.getLieuNaiss();
        Prof instance = new Prof();
        instance.setLieuNaiss("Geneve");
        String result = instance.getLieuNaiss();
        assertNotEquals(expResult, result);
        
        result = "Yamoussoukro";
        assertEquals(expResult, result);
    }

    /**
     * Test of setLieuNaiss method, of class Prof.
     */
    @Test
    @Order(8)
    public void testSetLieuNaiss() {
        System.out.println("Prof.Test.setLieuNaiss");
        String result = "Tokyo";
        Prof instance = new Prof();
        instance.setLieuNaiss(result);
        assertNotEquals(prof.getLieuNaiss(), instance.getLieuNaiss());
        
        instance.setLieuNaiss("Yamoussoukro");
        assertEquals(prof.getLieuNaiss(), instance.getLieuNaiss());
    }

    /**
     * Test of add method, of class Prof.
     */
    @Test
    @Order(9)
    public void testAdd() {
        System.out.println("Prof.Test.add");
        Prof p = new Prof("TJM_PROF0", "TJM_Prof0", "", "");    // The both last can be NULL.
        Prof instance = new Prof("TJM_PROF1", "TJM_Prof1", "10/05/1984", "Louvain");
        
        prof.add();         // This is the first insertion. So id == 1
        instance.add();     
        p.add();
        
        instance = new Prof("TJM_PROF2", "TJM_Prof2", "10/10/1984", "Charleroi");
        instance.add();
        
        instance = new Prof("TJM_PROF3", "TJM_Prof3", "10/10/1987", "Paris");
        instance.add();
        
        System.out.println(Prof.select().toString());
    }

    /**
     * Test of update method, of class Prof.
     */
    @Test
    @Order(10)
    public void testUpdate() {
        System.out.println("Prof.Test.update");
        int id = 3;
        System.out.println("Before Updated the prof number " + String.valueOf(id));
        System.out.println(Prof.select().toString());
        Prof instance = new Prof("TJM_PROF9", "TJM_Prof9", "12/12/1985", "Mons");
        instance.update(id);
        System.out.println("After Updated the prof id = " + String.valueOf(id));
        System.out.println(Prof.select().toString());
    }

    /**
     * Test of delete method, of class Prof.
     */
    @Test
    @Order(11)
    public void testDelete() {
        System.out.println("Prof.Test.delete");
        int id = 5;
        System.out.println("Before Deleted the prof number " + String.valueOf(id));
        Prof.delete(id);
        System.out.println("After Deleted the prof number " + String.valueOf(id));
    }

    /**
     * Test of select method, of class Prof.
     */
    @Test
    @Order(12)
    public void testSelect_int() {
        System.out.println("Prof.Test.select_id");
        int id = 1;
        System.out.println(Prof.select(id).toString());
    }

    /**
     * Test of select method, of class Prof.
     */
    @Test
    @Order(13)
    public void testSelect_String() {
        System.out.println("Prof.Test.select_name");
        String n = "NOFFABEL";
        System.out.println(Prof.select(n).toString());
    }

    /**
     * Test of getListCours method, of class Prof.
     */
    @Test
    @Order(14)
    public void testGetListCours() {
        System.out.println("Prof.Test.getListCours");
        System.out.println("Liste des cours du Prof: " + prof.getName() + " " + prof.getFirstname());
        System.out.println(prof.getListCours().toString());
    }

    /**
     * Test of select method, of class Prof.
     */
    @Test
    @Order(15)
    public void testSelect_0args() {
        System.out.println("Prof.Test.select");
        System.out.println("Liste des profs...");
        System.out.println(Prof.select().toString());
    }

    /**
     * Test of toString method, of class Prof.
     * this will be ignore during test process.
     */
    @Test
    @Order(16)
    public void testToString() {
        System.out.println("Prof.Test.toString");
        Prof instance = new Prof("PROF1", "Prof1", "10/05/1986", "Bordeau");
        assertNotEquals(prof.toString(), instance.toString());
        
        instance = new Prof("NOFFABEL", "Dadday", "12/07/1989", "Yamoussoukro");
        assertEquals(prof.toString(), instance.toString());
    }
    
}
