import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FitnessTrackerTest {

    public static void main(String[] args) throws InterruptedException {

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String start = formatter.format(Calendar.getInstance().getTime());

        long delay = 3 * 1000; // We multiply by 1000 because time is always measured in milliseconds
        int howManyTimes = 10;
        FitnessTracker myTracker = new FitnessTracker();

        String message;
        int nightTimeCounter = 0;
        int greatCounter = 0; // more than 150 watts
        int lowCounter = 0; //less than 50 watts


        myTracker.setName("Annett");

        for (int x = 1; x <= howManyTimes; x++) {

            message = myTracker.getInfo();
            System.out.println(message);

            if (myTracker.isNightTime(myTracker.getCurrentHour())) {
                nightTimeCounter++;
            }

            int energyLevel = myTracker.getEnergyLevel();

            if (energyLevel > 150) {
                greatCounter++;
            } else if (energyLevel < 50) {
                lowCounter++;
            }

            Thread.sleep(delay);
            myTracker.goOn();

        }

        String end = formatter.format(Calendar.getInstance().getTime());

        System.out.println("Start: " + start + "\nEnd: " + end);
        System.out.println("NightTimeCounter: " + nightTimeCounter);
        System.out.println("GreatCounter: " + greatCounter);
        System.out.println("LowCounter: " + lowCounter);

    }

}
