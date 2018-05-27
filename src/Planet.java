import java.util.ArrayList;

public class Planet {

    private static ArrayList<Plants> plants = new ArrayList<Plants>();
    private static int dayCounter = 0;
    private static Radiation radiation = Radiation.NEUTRAL;

    public static void main(String[] args) {

        plants.add(new Puff("Falank", 6));
        plants.add(new DeltaTree("Sudar", 5));
        plants.add(new ParaBush("Kopcos", 4));
        plants.add(new DeltaTree("Nyulank", 3));

        RadiationNeed myRadNeed;
        int myAlpha = 0;
        int myDelta = 0;

        while (dayCounter <= 10) {
            System.out.println("\nDay: " + dayCounter + " Napi Radiation: " + radiation);
            for (Plants myPlant : plants) {
                myPlant.nutritionCounter(radiation);
                myRadNeed = myPlant.nextRadiation();
                if (myRadNeed != null) {
                    switch (myRadNeed.radiation) {
                        case ALPHA:
                            myAlpha += myRadNeed.nutrition;
                            break;
                        case DELTA:
                            myDelta += myRadNeed.nutrition;
                            break;
                    }
                }
                System.out.println(myPlant.getName() + " " + myPlant.nutritions);
            }
            int radDiff = myAlpha-myDelta;
            if(radDiff >= 3) {
                radiation = Radiation.ALPHA;
            }
            else if(radDiff<= -3) {
                radiation = Radiation.DELTA;
            }
            else {
                radiation = Radiation.NEUTRAL;
            }
            dayCounter++;
        }
    }
}
/*A másnapi sugárzás alakulása: ha az alfa sugárzásra beérkezett
igények összege legalább hárommal meghaladja a delta sugárzás igényeinek
összegét, akkor alfa sugárzás lesz; ha a delta sugárzásra igaz ugyanez, akkor delta
sugárzás lesz; ha a két igény közti eltérés háromnál kisebb, akkor nincs sugárzás.
*/