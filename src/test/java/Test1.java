import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Vector;

public class Test1 {
    @Test
    public void test1GetPhone() {
    }

    @Test(dataProvider = "Data-Provider-Function")
    public void parameterIntTest(Class clzz, String[] number) {
        System.out.println("Parameterized Number is : " + number[0]);
        System.out.println("Parameterized Number is : " + number[1]);
    }

    //This function will provide the patameter data
    @DataProvider(name = "Data-Provider-Function")
    public Object[][] parameterIntTestProvider() {
        return new Object[][] {
                {Vector.class, new String[] {"java.util.AbstractList", "java.util.AbstractCollection"}},
                {String.class, new String[] {"1", "2"}},
                {Integer.class, new String[] {"1", "2"}}
        };
    }
}
