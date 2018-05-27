import java.util.Random;

public abstract class Plants {

    protected String[] names = new String[]{
            "Mountain Roadweed", "Pudina Cinnamon",
            "Bolean Wake Robin", "Mosquito Barbara",
            "Silky Poke", "Prickly Greater",
            "Man's Mustard", "Sword Goodding Plant",
            "Bur Swamp Strawberry", "Hay Rambler Haldi",
            "Bulbous Bolean Beech)", "Pigeon Redbud",
            "Brown-Eyed Eytelia", "Buffalo Paintbrush",
            "Poison Quercitron", "Green Honey",
            "Swallow-Wort", "Bitter Poorland Trillium",
            "Silverleaf Waybread", "Yellow Polecat Tassel",
            "Spiny Trailing Rye", "Goodding Butterfly",
            "Hogweed"
    };

    protected String name;
    protected int nutritions;

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        if (this.nutritions <= 0) {
            return false;
        }
        return true;
    }

    public abstract void nutritionCounter(Radiation rad);

    public abstract RadiationNeed nextRadiation();

}