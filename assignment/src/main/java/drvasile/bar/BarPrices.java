package drvasile.bar;

public class BarPrices
{
    public static final String HANSA_BEER = "hansa";
    public static final String GRANS_CIDER = "grans";
    public static final String STRONG_BOW_CIDER = "strong_bow";
    public static final String GIN_TONIC = "gin_tonic";
    public static final String BACARDI_SPECIAL = "bacardi_special";

    public int getDrinkPrice(final String typeOfDrink, final boolean isStudent, final int amount)
    {
        if (amount > 2 && (typeOfDrink == GIN_TONIC || typeOfDrink == BACARDI_SPECIAL))
        {
            throw new RuntimeException("Too many drinks, max 2.");
        }

        int price;

        if (typeOfDrink.equals(HANSA_BEER))
        {
            price = 74;
        } else if (typeOfDrink.equals(GRANS_CIDER))
        {
            price = 103;
        } else if (typeOfDrink.equals(STRONG_BOW_CIDER))
        {
            price = 110;
        } else if (typeOfDrink.equals(GIN_TONIC))
        {
            price = ginUnitPrice() + tonicWaterUnitPrice() + greenStuffUnitPrice();
        } else if (typeOfDrink.equals(BACARDI_SPECIAL))
        {
            price = ginUnitPrice() / 2 + rumUnitPrice() + grenadineUnitPrice() + limeJuiceUnitPrice();
        } else
        {
            throw new RuntimeException("No such drink exists.");
        }
        if (isStudent && (typeOfDrink == GRANS_CIDER || typeOfDrink == HANSA_BEER || typeOfDrink == STRONG_BOW_CIDER))
        {
            price = price - price / 10;
        }
        return price * amount;
    }

    private int rumUnitPrice()
    {
        return 65;
    }

    private int grenadineUnitPrice()
    {
        return 10;
    }

    private int limeJuiceUnitPrice()
    {
        return 10;
    }

    private int greenStuffUnitPrice()
    {
        return 10;
    }

    private int tonicWaterUnitPrice()
    {
        return 20;
    }

    private int ginUnitPrice()
    {
        return 85;
    }
}
