import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    //getName()
    private final String name;
    private final float price;
    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBuns() {
        return new Object[][] {
                {"Ржаная", 90},
                {"", 90},
                {null, 90},
                {"&*Ржаная", 90},
                {"РжанаяРжанаяРжанаяРжанаяРжанаяРжанаяРжанаяРжанаяРжанаяРжаная", 90},
                {"Ржаная", 0},
                {"Ржаная", -0.01f},
                {"Ржаная", 0.01f},
                {"Ржаная", 999999.99f},
        };
    }

    @Test
    public void getNameReturnCorrectName() {

        Bun bun = new Bun(name, price);
        String expectedName = name;
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }


    @Test
    public void getPriceReturnCorrectPrice() {

        Bun bun = new Bun(name, price);
        float expectedPrice = price;
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.0f);
    }
}
