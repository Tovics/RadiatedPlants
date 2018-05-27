
public class RadiationNeed {

    protected Radiation radiation;
    protected int nutrition;

    RadiationNeed(Radiation radiation, int nutrition) {
        this.radiation = radiation;
        this.nutrition = nutrition;
    }

    @Override
    public String toString() {
        return (this.radiation.toString() + " " + this.nutrition);
    }
}
