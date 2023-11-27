package drvasile.bar.models;

import java.util.stream.Stream;

public class Drink
{
    private final String name;
    private final Ingredient[] ingredients;

    public Drink(String name, Ingredient[] ingredients)
    {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName()
    {
        return this.name;
    }

    public int getPrice()
    {
        return Stream.of(this.ingredients).mapToInt(Ingredient::getPrice).sum();
    }
}
