import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;

public class TestGetSquare {

    @DataProvider(name="positiveDataProvider")
    public Object[][] getTriangle() {

        return new Object[][] {

                {8,new Triangle(3.0, 4.0, 5.0)},
                {8,new Triangle(5.0, 3.0, 4.0)},
                {8,new Triangle(5.0, 4.0, 3.0)},
        };
    }

    @DataProvider(name="negativeDataProvider")
    public Object[][] getNegativeTriangle() {
        return new Object[][] {
                {new Triangle(0.0, 0.0, 0.0)},
                {new Triangle(1.0, 0.0, 0.0)},
                {new Triangle(1.0, 2.0, 0.0)},
                {new Triangle(2.0, 2.0, 0.0)},
                {new Triangle(-6.0, -2.0, -4.0)},
                {new Triangle(Double.MAX_VALUE, Double.MAX_VALUE, 5)},
        };
    }

    @Test(dataProvider="positiveDataProvider")
    public void testPositiveDetectTriangle(int excepted, Triangle tr)
    {

        Assert.assertEquals(tr.detectTriangle(),excepted);
    }

    @Test(dataProvider="negativeDataProvider", dependsOnMethods = "testPositiveDetectTriangle" ,expectedExceptions = Exception.class)
    public void testNegativeDetectTriangle(Triangle tr)
    {
        tr.detectTriangle();
    }

}
