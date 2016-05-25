package io.stevejamison;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by stevejaminson on 5/23/16.
 */
public class MyStringUtilsSpec {

    @Test
    public void arrayToStringTest(){
        MyStringUtils myStringUtils = new MyStringUtils();
        String[] test = new String[3];
        test[0] = "This";
        test[1] = "is";
        test[2] = "a";
        String expected = "This,is,a";
        String actual = myStringUtils.arrayToString(test);
        assertEquals(expected,actual);
    }

    @Test
    public void stringToArrayTest(){
        MyStringUtils myStringUtils = new MyStringUtils();
        String test = "This is a\ntest.";
        String expected = "This is a";
        String actual = myStringUtils.stringToArray(test)[0];
        assertEquals(expected,actual);
    }

    @Test
    public void reverseCapitalTest(){
        MyStringUtils myStringUtils = new MyStringUtils();
        String test = "This is a test.";
        String expected = "tHIS iS a tEST.";
        String actual = myStringUtils.reverseCapital(test);
        assertEquals(expected,actual);
    }

    @Test
    public void reverseWordTest(){
        MyStringUtils myStringUtils = new MyStringUtils();
        String test = "This is a test.";
        String expected = "sihT si a .tset";
        String actual = myStringUtils.reverseWord(test);
        assertEquals(expected,actual);
    }

    @Test
    public void removeWhitespaceTest(){
        MyStringUtils myStringUtils = new MyStringUtils();
        String test = "This is a test.";
        String expected = "This\nis\na\ntest.";
        String actual = myStringUtils.removeWhitespace(test);
        assertEquals(expected,actual);
    }

    @Test
    public void allSubstringsTest(){
        MyStringUtils myStringUtils = new MyStringUtils();
        String test = "test";
        String expected = "t te tes test e es est s st t ";
        String actual = myStringUtils.allSubstrings(test);
        assertEquals(expected,actual);
    }
}
