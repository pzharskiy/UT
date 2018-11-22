import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;

public class TestCheckTriangle {

    @DataProvider(name = "positiveDataProvider")
    public Object[][] getTriangle() {

        return new Object[][]{

                {"c<=0", new Triangle(1.0, 2.0, 0.0)},
                {"a<=0", new Triangle(0.0, 2.0, 3.0)},
                {"b<=0", new Triangle(1.0, 0.0, 4.0)},
                {"a+b<=c",new Triangle(15.0, 12.0, 30.0)},
                {"a+c<=b",new Triangle(12.0, 30.0, 10.0)},
                {"b+c<=a",new Triangle(30.0, 12.0, 15.0)},
                {"",new Triangle(4.0, 6.0, 8.0)},
                {"",new Triangle(8.0, 6.0, 4.0)},
                {"",new Triangle(8.0, 4.0, 6.0)},
        };
    }

    @Test(dataProvider="positiveDataProvider" )
    public void TestCheckTriangle(String excepted, Triangle tr)
    {
        tr.checkTriangle();
        Assert.assertEquals(tr.getMessage(),excepted);

    }

}