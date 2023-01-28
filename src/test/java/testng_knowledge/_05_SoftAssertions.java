package testng_knowledge;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _05_SoftAssertions {

    @Test
    public void hardAssertionExample() {


        /*
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(2 == 2);
        softAssert.assertEquals("Hello", "abc");
        System.out.println("Hello World");

        softAssert.assertAll();


         */
    }


@Test
    public void softAssertionExample() {

    // We need create an object of SoftAssert class

    SoftAssert softAssert = new SoftAssert();

    softAssert.assertTrue(2 == 2);
    System.out.println("Hello World");
}
}

