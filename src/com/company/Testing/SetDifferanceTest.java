package com.company.Testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


/**
 * David Kirovski 181176
 * Interface-based approach:
 * C1: set1 is not null
 * C2: set2 is not null
 * C3: set1 is not empty
 * C4: set2 is not empty
 * Functionality-base approach:
 * C5: Retruns NullPointerException
 * C6: Returns non-null object
 * C7: Returns null
 * C8: set1 is equal to set2(in size)
 */
class SetDifferanceTest {

    public Set<Integer> set1;
    public Set<Integer> set2;
    public Set<Integer> expected;//samo za Functionality-base go korsitam
    private Lab1 lab1;

    @BeforeEach
    public void init(){
        lab1 = new Lab1();
    }

    //5 Tests for Interface Based
    @Test
    public void testInterface_BaseCase() //C1=T, C2=T, C3=T, C4=T
    {
        set1 = new HashSet<>();
        set2 = new HashSet<>();
        set1.add(1);
        set2.add(2);
        assertEquals(set1,lab1.SetDifferance(set1,set2));
    }

    @Test
    public void testInterface_C3(){//C1=T, C2=T, C3=F, C4=T
        set1 = new HashSet<>();
        set2 = new HashSet<>();
        set2.add(1);
        assertEquals(null,lab1.SetDifferance(set1,set2));
    }

    @Test
    public void testInterface_C4(){//C1=T, C2=T, C3=T, C4=F
        set1 = new HashSet<>();
        set2 = new HashSet<>();
        set1.add(1);
        lab1.SetDifferance(set1,set2);
        assertEquals(set1,lab1.SetDifferance(set1,set2));
    }

    @Test
    public void testInterface_C1C3(){//C1=F, C2=T, C3=F, C4=T
        set1 = null;
        set2 = new HashSet<>();
        set2.add(1);
        assertThrows(NullPointerException.class, ()-> lab1.SetDifferance(set1,set2));
    }

    @Test
    public void testInterface_C2C4(){//C1=T, C2=F, C3=T, C4=F
        set1 = new HashSet<>();
        set2 = null;
        set1.add(1);
        assertThrows(NullPointerException.class, ()-> lab1.SetDifferance(set1,set2));
    }

    //5 Tests for Functionality based
    @Test
    public void testFunctionality_BaseCase() //C5=F, C6=T, C7=F, C8=F (non-null object)
    {
        set1 = new HashSet<>();
        set2 = new HashSet<>();
        set1.add(5);
        set2.add(6);
        expected = new HashSet<>();
        expected.add(5);
        assertEquals(expected,lab1.SetDifferance(set1,set2));
    }

    @Test
    public void testFunctionality_C5() //C5=T, C6=F, C7=F, C8=F (NullPointerException)
    {
        set1 = null;
        set2 = null;
        assertThrows(NullPointerException.class, ()-> lab1.SetDifferance(set1,set2));
    }


    @Test
    public void testFunctionality_C7() //C5=F, C6=F, C7=T, C8=F (null)
    {
        set1 = new HashSet<>();
        set2 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(1);
        set2.add(2);
        set2.add(3);
        assertEquals(null,lab1.SetDifferance(set1,set2));
    }

    @Test
    public void testFunctionality_C8() //C5=F, C6=T, C7=F, C8=T
    {
        set1 = new HashSet<>();
        set2 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(2);
        set2.add(6);
        set2.add(7);
        expected = new HashSet<>();
        expected.add(1);
        expected.add(3);
        assertTrue(set1.size()==set2.size());
        assertEquals(expected,lab1.SetDifferance(set1,set2));
    }

    @Test
    public void testFunctionality_C6C7C8() //C5=F, C6=F, C7=T, C8=T
    {
        set1 = new HashSet<>();
        set2 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        expected=null;
        assertTrue(set1.size()==set2.size());
        assertEquals(expected,lab1.SetDifferance(set1,set2));
    }




}