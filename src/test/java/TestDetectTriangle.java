import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;

public class TestDetectTriangle {

    @DataProvider(name="positiveDataProvider")
    public Object[][] getTriangle() {

        return new Object[][] {
                //Обычный
                {4,new Triangle(6.0, 3.0, 4.0)},
                //Равносторонний
                {3,new Triangle(4.0, 4.0, 4.0)},
                //Равнобедренный
                {2,new Triangle(3.0, 4.0, 4.0)},
                {2,new Triangle(4.0, 3.0, 4.0)},
                {2,new Triangle(4.0, 4.0, 3.0)},
                //Равнобедренный с переполнением
                {2,new Triangle(21474833647.0, 21474833647.0, 1.0)},
                {2,new Triangle(1.0, 21474833647.0, 21474833647.0)},
                {2,new Triangle(21474833647.0, 1.0, 21474833647.0)},
                //Прямоугольный
                {8,new Triangle(3.0, 4.0, 5.0)},
                {8,new Triangle(4.0, 3.0, 5.0)},
                {8,new Triangle(4.0, 5.0, 3.0)},


        };
    }

    @DataProvider(name="negativeDataProvider")
    public Object[][] getNegativeTriangle() {
        return new Object[][] {
                //Не существует
                //2 стороны в сумме равны третьей - граничные значения
                {new Triangle(1.0, 2.0, 3.0)},
                {new Triangle(10.0, 2.0, 8.0)},
                {new Triangle(320.0, 400.0, 80.0)},
                //2 стороны в сумме меньше третьей
                {new Triangle(15.0, 12.0, 30.0)},
                {new Triangle(4.0, 2.0, 1.0)},
                {new Triangle(50.0, 150.0, 100.0)},
                //Нулевые стороны
                {new Triangle(0.0, 0.0, 0.0)},
                {new Triangle(1.0, 0.0, 0.0)},
                {new Triangle(1.0, 2.0, 0.0)},
                {new Triangle(2.0, 0.0, 2.0)},
                //Отрицательная длина стороны (возможно - избыточное, т.к. не будут проходить по сумме 2 сторон)
                {new Triangle(6.0, 2.0, -4.0)},
        };
    }

    @Test(dataProvider="positiveDataProvider")
    public void testPositiveDetectTriangle(int excepted, Triangle tr)
    {
        Assert.assertEquals(tr.detectTriangle(),excepted);
    }

    @Test(dataProvider="negativeDataProvider", dependsOnMethods = "testPositiveDetectTriangle" ,expectedExceptions = Exception.class)
    public void testNegativeDetectTriangle(Triangle tr2)
    {
        tr2.detectTriangle();
    }
}
