
public class ParaBush extends Plants {

    ParaBush(String name, int nutritions) {
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
                case DELTA:
                    this.nutritions += 1;
                    break;
                case NEUTRAL:
                    this.nutritions -= 1;
                    break;
            }
        }
    }

    @Override
    public RadiationNeed nextRadiation() {
        return null;
    }
}
/*
Parabokor: Akár alfa, akár delta sugárzás hatására a tápanyag mennyisége
eggyel nő. Sugárzás nélküli napon a tápanyag eggyel csökken. A másnapi
sugárzást nem befolyásolja.
 */
