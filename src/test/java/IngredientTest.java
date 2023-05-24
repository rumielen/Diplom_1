import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    //getPrice
    @Test
    public void getPriceReturnCorrectPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Cucumber", 10.0f);
        Assert.assertEquals(10.0f, ingredient.getPrice(), 0.0f);
    }

    //getName
    @Test
    public void getNameReturnCorrectName() {
        Ingredient ingredient = new Ingredient(SAUCE, "ketchup", 10.0f);
        String actualName = ingredient.getName();
        String expectedName = "ketchup";
        Assert.assertEquals(expectedName, actualName);

    }
    //getType
    @Test
    public void getTypeReturnCorrectType() {
        Ingredient ingredient = new Ingredient(SAUCE, "ketchup", 10.0f);
        IngredientType actualType = ingredient.getType();
        IngredientType expectedType = SAUCE;
        Assert.assertEquals(expectedType, actualType);
    }

}
