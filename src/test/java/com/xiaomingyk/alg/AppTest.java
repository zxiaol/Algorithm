package com.xiaomingyk.alg;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testRemoveElemGreater(){

        System.out.println("testRemoveElemGreater");


        int[] array = {1,5,7,8,12,8,9,4};

        int newLength = ArrayAlgo.RemoveElemGreater(array,8);

        for(int i = 0; i < newLength; i++){

            System.out.println(array[i]);
        }

        assertEquals(newLength,6);


    }

    public void testRemoveDuplicateFromSortedArray(){

        System.out.println("testRemoveDuplicateFromSortedArray");

        int[] array= {1,1,1,1,1,3,3,4,4,4,5,6,7};

        int newLength = ArrayAlgo.RemoveDuplicateFromSortedArray(array);

        for(int i = 0; i < newLength; i++){

            System.out.println(array[i]);
        }

        assertEquals(6,newLength);

    }

    public void testGenerateTriangle(){

        System.out.println("testGenerateTriangle");


        ArrayAlgo.generatePascalTriangle(5);

    }

    public void testTraverseBinTreeByLevelOrder(){
        // input {3,9,20,#,#,15,7} return

        ArrayList<String> tree = new ArrayList<String>();
        tree.add("3");
        tree.add("9");
        tree.add("20");
        tree.add("#");
        tree.add("#");
        tree.add("15");
        tree.add("7");

        TreeAlgo.traverseBinTreeByLevelOrder(tree);
    }
}
