package drvasile.bar.models;

import java.util.Arrays;
import java.util.Optional;

public enum Menu
{
    BACARDI_SPECIAL("Bacardi Special"),
    GIN_TONIC("Gin Tonic"),
    HANSA_BEER("Hansa Beer"),
    GRANS_CIDER("Grans Cider"),
    STRONG_BOW_CIDER("Strong Bow Cider");

    private final String name;

    Menu(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public static Optional<Menu> findByName(final String name)
    {
        return Arrays.stream(values()).filter(item -> item.getName().equals(name)).findFirst();
    }
}
