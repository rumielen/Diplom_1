import org.junit.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import org.junit.Assert;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;




public class BurgerTest {

    @Test
    public void setBunsCorrectlySet() {
        Bun bun = Mockito.mock(Bun.class);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);

    }

    @Mock
    private Ingredient ingredient;


    @Test
    public void addIngredientCorrectlyAdd() {
        List<Ingredient> ingredients = new ArrayList<>();
        Burger burger = new Burger();
        burger.ingredients = ingredients;
        burger.addIngredient(ingredient);
        //что список содержит один элемент и первый элемент равен доб.ингридиенту
        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(ingredient, burger.ingredients.get(0));

    }

    @Test
    public void removeIngredientCorrectlyRemove() {

        Burger burger = new Burger();
        Ingredient ketchup = Mockito.mock(Ingredient.class);
        Ingredient ogurchik = Mockito.mock((Ingredient.class));
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ketchup);
        ingredients.add(ogurchik);
        burger.ingredients = ingredients;
        burger.removeIngredient(0); //удаляем огурец
        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(ogurchik, burger.ingredients.get(0));

    }

    @Test
    public void moveIngredientCorrectMove() {

        List<Ingredient> ingredients = new ArrayList<>();
        Burger burger = new Burger();
        Ingredient ketchup = Mockito.mock(Ingredient.class);
        Ingredient ogurchik = Mockito.mock(Ingredient.class);
        Ingredient salad = Mockito.mock(Ingredient.class);
        ingredients.add(ketchup);
        ingredients.add(ogurchik);
        ingredients.add(salad);
        burger.ingredients = ingredients;
        burger.moveIngredient(2,1);
        Assert.assertEquals(3, burger.ingredients.size()); //ингридиенты в нужном количесте
        Assert.assertEquals(salad, burger.ingredients.get(1));
        Assert.assertEquals(ogurchik, burger.ingredients.get(2));
        Assert.assertEquals(ketchup, burger.ingredients.get(0));
    }


    @Test
    public void getPriceCorrectGetting() {

        Burger burger = new Burger();
        Bun bun = Mockito.mock((Bun.class));
        Mockito.when(bun.getPrice()).thenReturn(10.0f);
        Ingredient ketchup = Mockito.mock(Ingredient.class);
        Mockito.when(ketchup.getPrice()).thenReturn(3.0f);
        Ingredient salad = Mockito.mock(Ingredient.class);
        Mockito.when(salad.getPrice()).thenReturn(3.0f);
        burger.setBuns(bun);
        burger.addIngredient(ketchup);
        burger.addIngredient(salad);
        Assert.assertEquals(26.0f, burger.getPrice(), 0.0f);


    }


    @Test
    public void getReceiptCorrectGetting() {
        Bun bun = Mockito.mock(Bun.class);
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("Rye bun fitness");
        Ingredient greenery = Mockito.mock((Ingredient.class));
        Mockito.when(greenery.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(greenery.getName()).thenReturn("romano salad");
        Mockito.when(greenery.getPrice()).thenReturn(20.0f);
        Ingredient meat = Mockito.mock((Ingredient.class));
        Mockito.when(meat.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(meat.getName()).thenReturn("turkey");
        Mockito.when(meat.getPrice()).thenReturn(50.0f);
        Ingredient sauce = Mockito.mock((Ingredient.class));
        Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(sauce.getName()).thenReturn("ketchup chili");
        Mockito.when(sauce.getPrice()).thenReturn(10.0f);

        burger.setBuns(bun);
        burger.addIngredient(greenery);
        burger.addIngredient(meat);
        burger.addIngredient(sauce);
        String expectedReceipt = "(==== Rye bun fitness ====)\r\n" +
                        "= filling romano salad =\r\n" +
                        "= filling turkey =\r\n" +
                        "= sauce ketchup chili =\r\n" +
                        "(==== Rye bun fitness ====)\r\n" +
                        "\r\n" +
                        "Price: 80,000000\r\n";

                Assert.assertEquals(expectedReceipt, burger.getReceipt());


    }


}
