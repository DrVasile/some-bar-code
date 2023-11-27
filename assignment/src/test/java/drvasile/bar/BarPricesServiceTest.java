package drvasile.bar;

import drvasile.bar.models.Drink;
import drvasile.bar.models.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static drvasile.bar.models.Menu.BACARDI_SPECIAL;
import static drvasile.bar.models.Menu.GIN_TONIC;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Bar Test Specification")
public class BarPricesServiceTest
{
    private BarPricesService barPricesInstance;

    @BeforeEach
    public void setUp()
    {
        barPricesInstance = new BarPricesService();
    }

    @Test
    @DisplayName("When ordering one beer, the price should be 74.")
    public void oneBeerPriceTest()
    {
        final Drink hansaBeer = new Drink(Ingredient.HANSA_BEER.getName(), new Ingredient[] { Ingredient.HANSA_BEER });
        int actualPrice = barPricesInstance.getDrinkPrice(hansaBeer, false, 1);
        assertEquals(74, actualPrice);
    }

    @Test
    @DisplayName("When ordering one Grans cider, the price should be 103.")
    public void gransCiderPriceTest()
    {
        final Drink gransCider = new Drink(Ingredient.GRANS_CIDER.getName(), new Ingredient[] { Ingredient.GRANS_CIDER });
        int actualPrice = barPricesInstance.getDrinkPrice(gransCider, false, 1);
        assertEquals(103, actualPrice);
    }

    @Test
    @DisplayName("When ordering a Strong Bow cider, the price should be 110.")
    public void strongBowPriceTest()
    {
        final Drink strongBowCider = new Drink(Ingredient.STRONG_BOW_CIDER.getName(), new Ingredient[] { Ingredient.STRONG_BOW_CIDER });
        int actualPrice = barPricesInstance.getDrinkPrice(strongBowCider, false, 1);
        assertEquals(110, actualPrice);
    }

    @Test
    @DisplayName("When ordering a gin and tonic, the price should be 115.")
    public void ginTonicPriceTest()
    {
        final Drink ginTonic = new Drink(GIN_TONIC.getName(), new Ingredient[] { Ingredient.GIN, Ingredient.GREEN_STUFF, Ingredient.TONIC });
        int actualPrice = barPricesInstance.getDrinkPrice(ginTonic, false, 1);
        assertEquals(115, actualPrice);
    }

    @Test
    @DisplayName("When ordering a bacardi special, the price should be 127.")
    public void bacardiSpecialPriceTest()
    {
        final Drink bacardiSpecial = new Drink(BACARDI_SPECIAL.getName(), new Ingredient[] { Ingredient.RUM, Ingredient.GRENADINE,
            Ingredient.LIME_JUICE, Ingredient.GIN });
        int actualPrice = barPricesInstance.getDrinkPrice(bacardiSpecial, false, 1);
        assertEquals(170, actualPrice);
    }

    @Nested
    @DisplayName("Test drink prices for a customer that is a student.")
    class Students
    {
        @Test
        @DisplayName("When a student orders a Hansa beer, he/she gets a discount.")
        public void studentsGetADiscountForBeerTest()
        {
            final Drink hansaBeer = new Drink(Ingredient.HANSA_BEER.getName(), new Ingredient[] { Ingredient.HANSA_BEER });
            int actualPrice = barPricesInstance.getDrinkPrice(hansaBeer, true, 1);
            assertEquals(67, actualPrice);
        }

        @Test
        @DisplayName("When a student orders multiple Hansa beers, he/she also gets a discount.")
        public void studentsGetADiscountsWhenOrderingMoreThanOneBeerTest()
        {
            final Drink hansaBeer = new Drink(Ingredient.HANSA_BEER.getName(), new Ingredient[] { Ingredient.HANSA_BEER });
            int actualPrice = barPricesInstance.getDrinkPrice(hansaBeer, true, 2);
            assertEquals(67 * 2, actualPrice);
        }

        @Test
        @DisplayName("When a student orders a cocktail, he/she does not get a discount.")
        public void testStudentsDoNotGetDiscountsForCocktails()
        {
            final Drink ginTonic = new Drink(GIN_TONIC.getName(), new Ingredient[] { Ingredient.GIN, Ingredient.GREEN_STUFF, Ingredient.TONIC });
            int actualPrice = barPricesInstance.getDrinkPrice(ginTonic, true, 1);
            assertEquals(115, actualPrice);
        }
    }

    @Test
    @DisplayName("When ordering a drink which is not on the menu, an exception is thrown.")
    public void orderingADrinkNotInTheMenuTrowsAnExceptionTest()
    {
        final Drink unknownDrink = new Drink("Abcdefg", new Ingredient[] {});
        assertThrows(RuntimeException.class, () -> barPricesInstance.getDrinkPrice(unknownDrink, false, 1));
    }

    @Nested
    @DisplayName("When ordering more than two drinks.")
    class MultipleDrinks
    {
        @Test
        @DisplayName("Ordering two cocktails throws an exception.")
        public void canBuyAtMostTwoDrinksInOneGoTest()
        {
            final Drink bacardiSpecial = new Drink(BACARDI_SPECIAL.getName(), new Ingredient[] { Ingredient.RUM, Ingredient.RUM, Ingredient.GRENADINE,
                Ingredient.LIME_JUICE });
            assertThrows(RuntimeException.class, () -> barPricesInstance.getDrinkPrice(bacardiSpecial, false, 3));
        }

        @Test
        @DisplayName("Ordering two or more beers doesn't throw an exception.")
        public void testCanOrderMoreThanTwoBeers()
        {
            final Drink hansaBeer = new Drink(Ingredient.HANSA_BEER.getName(), new Ingredient[] { Ingredient.HANSA_BEER });
            barPricesInstance.getDrinkPrice(hansaBeer, false, 5);
        }
    }
}
