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
                {"Лакомка", 0},
        };
    }

    @Test
    public void getNameReturnCorrectName() {

        Bun bun = new Bun(name, price);
        String expectedName = name;
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }

    //getPrice()
    @Test
    public void getPriceReturnCorrectPrice() {

        Bun bun = new Bun(name, price);
        float expectedPrice = price;
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.0f);
    }
}
