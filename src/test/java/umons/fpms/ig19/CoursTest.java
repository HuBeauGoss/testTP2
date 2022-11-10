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
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.Assert.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

/**
 *
 * @author noffa
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CoursTest {
    Cours cours;
    String intitule;
    String duree;
    int idprof;
    
    public CoursTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Cours.BeforeClass.setUptClass");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Cours.AfterClass.teardDownClass");
    }
    
    @Before
    public void setUp() {
        System.out.println("Cours.Before.setUp");
        cours = new Cours("Intégration continue", "2h", 1);
    }
    
    @After
    public void tearDown() {
        System.out.println("Cours.After.tearDown");
        cours = null;
    }

    /**
     * Test of getIntitule method, of class Cours.
     */
    @Test
    @Order(1)
    public void testGetIntitule() {
        System.out.println("Cours.Test.getIntitule");
        String result = "Developpement Java";
        String expResult = cours.getIntitule();
        assertNotEquals(expResult, result);
        
        result = "Intégration continue";
        assertEquals(expResult, result);
    }

    /**
     * Test of setIntitule method, of class Cours.
     */
    @Test
    @Order(2)
    public void testSetIntitule() {
        System.out.println("Cours.Test.setIntitule");
        String name = "Developpement Java";
        Cours instance = new Cours();
        instance.setIntitule(name);
        assertNotEquals(cours.getIntitule(), instance.getIntitule());
        
        name = "Intégration continue";
        instance.setIntitule(name);
        assertEquals(cours.getIntitule(), instance.getIntitule());
    }

    /**
     * Test of getDuree method, of class Cours.
     */
    @Test
    @Order(3)
    public void testGetDuree() {
        System.out.println("Cours.Test.getDuree");
        String result = "6h";
        String expResult = cours.getDuree();
        assertNotEquals(expResult, result);
        
        result = "2h";
        assertEquals(expResult, result);
    }

    /**
     * Test of setDuree method, of class Cours.
     */
    @Test
    @Order(4)
    public void testSetDuree() {
        System.out.println("Cours.Test.setDuree");
        String d = "4h";
        Cours instance = new Cours();
        instance.setDuree(d);
        assertNotEquals(instance.getDuree(), cours.getDuree());
        
        d = "2h";
        instance.setDuree(d);
        assertEquals(instance.getDuree(), cours.getDuree());
    }

    /**
     * Test of setProf method, of class Cours.
     */
    @Test
    @Order(6)
    public void testSetProf() {
        System.out.println("Cours.Test.setProf");
        int id = 4;
        Cours instance = new Cours();
        instance.setProf(id);
        assertNotEquals(String.valueOf(cours.getProf()), String.valueOf(instance.getProf()));
    }

    /**
     * Test of add method, of class Cours.
     */
    @Test
    @Order(7)
    public void testAdd() {
        System.out.println("Cours.Test.add");
        Cours instance = new Cours("Java", "2h", 2);
        
        cours.add(); // id = 1
        
        instance.add(); // id = 2 
        instance = new Cours("IA", "3h", 1);
        instance.add();  // id = 3
        
        instance = new Cours("C/C++", "3h", 2);
        instance.add(); // id = 4
        
        instance = new Cours("Projet Encadrement", "3h", 3);
        instance.add();  // 5
        
        instance = new Cours("BDD", "3h", 1);
        instance.add();  // 6
        
        instance = new Cours("Seminaire", "4h", 3);
        instance.add(); // 7
        
        System.out.println(Cours.select().toString());
    }

    /**
     * Test of update method, of class Cours.
     */
    @Test
    @Order(8)
    public void testUpdate() {
        System.out.println("Cours.Test.update");
        int id = 3;
        System.out.println("Before Updated");
        System.out.println(Cours.select(id).toString());
        cours.update(id);
        System.out.println("After Updated");
        System.out.println(Cours.select(id).toString());
    }

    /**
     * Test of delete method, of class Cours.
     */
    @Test
    @Order(9)
    public void testDelete() {
        System.out.println("Cours.Test.delete");
        int id = 7;
        System.out.println(Cours.select().toString());
        Cours.delete(id);
        System.out.println("After Delete");
        System.out.println(Cours.select().toString());
    }

    /**
     * Test of select method, of class Cours.
     */
    @Test
    @Order(10)
    public void testSelect_int() {
        System.out.println("Cours.Test.select_id");
        int id = 3;
        System.out.println(Cours.select(id).toString());
    }

    /**
     * Test of select method, of class Cours.
     */
    @Test
    @Order(11)
    public void testSelect_String() {
        System.out.println("Cours.Test.select_intitule");
        System.out.println(Cours.select(cours.getIntitule()).toString());
    }

    /**
     * Test of select method, of class Cours.
     */
    @Test
    @Order(12)
    public void testSelect_0args() {
        System.out.println("Cours.Test.select");
        System.out.println(Cours.select().toString());
    }

    /**
     * Test of getProf method, of class Cours.
     */
    @Test
    @Order(13)
    public void testGetProf() {
        System.out.println("Cours.Test.getProf");
        int expResult = cours.getProf();
        int idProf = 2;
        assertNotEquals(expResult, idProf);
        
        idProf = 1;
        expResult = cours.getProf();
        assertEquals(expResult, idProf);
    }
    
    /**
     * Test of toString method, of class Cours.
     */
    @Test
    @Order(14)
    public void testToString() {
        System.out.println("Cours.Test.toString");
        Cours instance = new Cours("Intégration continue", "2h", 1);
        String expResult = cours.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
        instance = new Cours("Java", "3h", 3);
        expResult = cours.toString();
        result = instance.toString();
        assertNotEquals(expResult, result);
    }
    
}
