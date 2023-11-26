package drvasile.bar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Bar Test Specification")
public class BarPricesTest
{
    private BarPrices barPricesInstance;

    @BeforeEach
    public void setUp() throws Exception
    {
        barPricesInstance = new BarPrices();
    }

    @Test
    @DisplayName("When ordering one beer, the price should be 74.")
    public void oneBeerPriceTest()
    {
        int actualPrice = barPricesInstance.getDrinkPrice(BarPrices.HANSA_BEER, false, 1);
        assertEquals(74, actualPrice);
    }

    @Test
    @DisplayName("When ordering one Grans cider, the price should be 103.")
    public void gransCiderPriceTest() throws Exception
    {
        int actualPrice = barPricesInstance.getDrinkPrice(BarPrices.GRANS_CIDER, false, 1);
        assertEquals(103, actualPrice);
    }

    @Test
    @DisplayName("When ordering a Strong Bow cider, the price should be 110.")
    public void strongBowPriceTest() throws Exception
    {
        int actualPrice = barPricesInstance.getDrinkPrice(BarPrices.STRONG_BOW_CIDER, false, 1);
        assertEquals(110, actualPrice);
    }

    @Test
    @DisplayName("When ordering a gin and tonic, the price should be 115.")
    public void ginTonicPriceTest() throws Exception
    {
        int actualPrice = barPricesInstance.getDrinkPrice(BarPrices.GIN_TONIC, false, 1);
        assertEquals(115, actualPrice);
    }

    @Test
    @DisplayName("When ordering a bacardi special, the price should be 127.")
    public void testBacardiSpecial() throws Exception
    {
        int actualPrice = barPricesInstance.getDrinkPrice(BarPrices.BACARDI_SPECIAL, false, 1);
        assertEquals(127, actualPrice);
    }

    @Nested
    @DisplayName("Given a customer who is a student.")
    class Students
    {
        @Test
        @DisplayName("When they order a beer, then they get a discount.")
        public void testStudentsGetADiscountForBeer() throws Exception
        {
            int actualPrice = barPricesInstance.getDrinkPrice(BarPrices.HANSA_BEER, true, 1);
            assertEquals(67, actualPrice);
        }

        @Test
        @DisplayName("When they order multiple beers, they also get a discount.")
        public void testStudentsGetDiscountsWhenOrderingMoreThanOneBeer() throws Exception
        {
            int actualPrice = barPricesInstance.getDrinkPrice(BarPrices.HANSA_BEER, true, 2);
            assertEquals(67 * 2, actualPrice);
        }

        @Test
        @DisplayName("When they order a cocktail, they do not get a discount.")
        public void testStudentsDoNotGetDiscountsForCocktails() throws Exception
        {
            int actualPrice = barPricesInstance.getDrinkPrice(BarPrices.GIN_TONIC, true, 1);
            assertEquals(115, actualPrice);
        }
    }

    @Test
    @DisplayName("When they order a drink which is not on the menu, then they are refused.")
    public void testThatADrinkNotInTheSortimentGivesError() throws Exception
    {
        assertThrows(RuntimeException.class, () -> barPricesInstance.getDrinkPrice("sanfranciscosling", false, 1));
    }

    @Nested
    @DisplayName("When they order more than two drinks")
    class MultipleDrinks
    {
        @Test
        @DisplayName("and the order is for cocktails, then they are refused.")
        public void testCanBuyAtMostTwoDrinksInOneGo() throws Exception
        {
            assertThrows(RuntimeException.class, () -> barPricesInstance.getDrinkPrice(BarPrices.BACARDI_SPECIAL, false, 3));
        }

        @Test
        @DisplayName("and the order is for beers, then they are served.")
        public void testCanOrderMoreThanTwoBeers() throws Exception
        {
            barPricesInstance.getDrinkPrice(BarPrices.HANSA_BEER, false, 5);
        }
    }
}
