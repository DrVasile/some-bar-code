package drvasile.bar.models;

public enum Ingredient
{
    GRENADINE("Grenadine", 10),
    GIN("Gin", 85),
    GRANS_CIDER("Grans Cider", 103),
    GREEN_STUFF("Green Stuff", 10),
    HANSA_BEER("Hansa Beer", 74),
    LIME_JUICE("Lime Juice", 10),
    RUM("Rum", 65),
    STRONG_BOW_CIDER("Strong Bow Cider", 110),
    TONIC("Tonic", 20);

    private final String name;
    private final Integer price;

    Ingredient(String name, Integer price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public int getPrice()
    {
        return price;
    }
}
