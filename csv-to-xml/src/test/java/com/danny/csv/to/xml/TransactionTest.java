/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danny.csv.to.xml;

import static org.junit.Assert.*;

/**
 *
 * @author Danny
 */
public class TransactionTest {
    
    public TransactionTest() {
    }
    
    @org.junit.Test
    public void testConvertAmountCAD() {
        Transaction cadTest = new Transaction(1, "2017/2/8", "Johnny", 100, "CAD", "RBC");
        double expResult = 100;
        double result = cadTest.convertAmount();
        
        assertEquals(expResult, result, 0);
    }
    
    @org.junit.Test
    public void testConvertAmountEUR(){
        Transaction eurTest = new Transaction(1, "2017/1/9", "Daniel", 100, "EUR", "RBC");
        double expResult = 153;
        double result = eurTest.convertAmount();
        
        assertEquals(expResult, result, 0);
    }
    
    @org.junit.Test
    public void testConvertAmountUSD(){
        Transaction usdTest = new Transaction(1, "2017/1/9", "Daniel", 200, "USD", "RBC");
        double expResult = 248;
        double result = usdTest.convertAmount();
        
        assertEquals(expResult, result, 0);
    }
}
