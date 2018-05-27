
public class DeltaTree extends Plants {

    DeltaTree(String name, int nutritions) {
        this.name = name;
        this.nutritions = nutritions;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void nutritionCounter(Radiation rad) {
        if (isAlive()) {
            switch (rad) {
                case ALPHA:
                    this.nutritions -= 3;
                    break;
                case DELTA:
                    this.nutritions += 4;
                    break;
                case NEUTRAL:
                    this.nutritions -= 1;
            }
        }
    }

    @Override
    public RadiationNeed nextRadiation() {
        if (!isAlive()) {
            return null;
        }
        RadiationNeed nextDay;
        if (nutritions < 5) {
            nextDay = new RadiationNeed(Radiation.DELTA, 4);
        } else if (nutritions < 10) {
            nextDay = new RadiationNeed(Radiation.DELTA, 1);
        } else {
            nextDay = new RadiationNeed(Radiation.DELTA, 0);
        }
        return nextDay;
    }
}
/*
Deltafa: Alfa sugárzás hatására a tápanyag mennyisége hárommal csökken,
sugárzás nélküli napon a tápanyag eggyel csökken, delta sugárzás hatására
a tápanyag néggyel nő. Ha a tápanyag mennyisége 5-nél kisebb, akkor 4
értékben növeli a delta sugárzás bekövetkezését, ha 5 és 10 közé esik,
akkor 1 értékben növeli a delta sugárzás bekövetkezését, ha 10-nél több,
akkor nem befolyásolja a másnapi sugárzást.
 */