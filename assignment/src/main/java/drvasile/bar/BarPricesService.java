package drvasile.bar;

import static drvasile.bar.models.Menu.BACARDI_SPECIAL;
import static drvasile.bar.models.Menu.GIN_TONIC;

import drvasile.bar.models.Drink;
import drvasile.bar.models.Ingredient;
import drvasile.bar.models.Menu;

public class BarPricesService
{
    public int getDrinkPrice(final Drink drink, final boolean isStudent, final int amount)
    {
        if (amount > 2 && (drink.getName().equals(GIN_TONIC.getName()) || drink.getName().equals(BACARDI_SPECIAL.getName())))
        {
            throw new RuntimeException("Too many drinks.");
        }

        if (Menu.findByName(drink.getName()).isEmpty())
        {
            throw new RuntimeException("No such drink exists.");
        }

        int price = drink.getPrice();

        if (isStudent && (drink.getName().equals(Ingredient.GRANS_CIDER.getName()) || drink.getName().equals(Ingredient.HANSA_BEER.getName()) ||
            drink.getName().equals(Ingredient.STRONG_BOW_CIDER.getName())))
        {
            price = price - price / 10;
        }

        return price * amount;
    }
}
