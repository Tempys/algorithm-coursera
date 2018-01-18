package ua.dubovskyi.custom;

import org.junit.Assert;
import org.junit.Test;
import ua.dubovslyi.custom.ReverseString;

public class ReverseStringTest {

    @Test
    public void reverse1Test(){

       ReverseString reverseString = new ReverseString();

        Assert.assertEquals("tset",reverseString.myReverseAlgorithms("test"));
        Assert.assertEquals("jhgfdsa",reverseString.myReverseAlgorithms("asdfghj"));
    }
}

