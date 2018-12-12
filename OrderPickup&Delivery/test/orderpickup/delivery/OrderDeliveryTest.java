/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderpickup.delivery;

import org.junit.After;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderpickup.delivery;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS
 */
public class OrderDeliveryTest {
    
    public OrderDeliveryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("* OrderDelivery: @BeforeClass method");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("* OrderDelivery: @AfterClass method");
    }
    
    @Before
    public void setUp() {
        System.out.println("* OrderDelivery: @Before method");
    }
    
    @After
    public void tearDown() {
        System.out.println("* OrderDelivery: @After method");
    }

    /**
     * Test of main method, of class OrderDelivery.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        OrderDelivery.main(args);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS
 */
public class OrderDeliveryTest {
    
    public OrderDeliveryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class OrderDelivery.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        OrderDelivery.main(args);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
