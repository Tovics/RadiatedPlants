import static jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType.ALPHA;

public class Puff extends Plants {

    private final int NUTRITIONMAX = 10;

    Puff(String name, int nutritions) {
        this.name = name;
        this.nutritions = nutritions;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public boolean isAlive() {
        if (this.nutritions <= 0 || this.nutritions > NUTRITIONMAX) {
            return false;
        }
        return true;
    }

    @Override
    public void nutritionCounter(Radiation rad) {
        if (isAlive()) {
            switch (rad) {
                case ALPHA:
                    this.nutritions += 2;
                    break;
                case DELTA:
                    this.nutritions -= 2;
                    break;
                case NEUTRAL:
                    this.nutritions -= 1;
            }
        }
    }

    @Override
    public RadiationNeed nextRadiation() {
        if (isAlive()) {
            RadiationNeed nextDay = new RadiationNeed(Radiation.ALPHA, NUTRITIONMAX - nutritions);
            return nextDay;
        }
        return null;
    }
}
/*
Puffancs: Alfa sugárzás hatására a tápanyag mennyisége kettővel nő,
sugárzás mentes napon a tápanyag eggyel csökken, delta sugárzás esetén
a tápanyag kettővel csökken. Minden esetben úgy befolyásolja a másnapi
sugárzást, hogy 10 - tápanyag értékben növeli az alfa sugárzás
bekövetkezését. Ez a fajta akkor is elpusztul, ha a tápanyag mennyisége 10
fölé emelkedik.
 */