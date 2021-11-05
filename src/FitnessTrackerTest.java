public class FitnessTrackerTest {

    public static void main(String[] args) throws InterruptedException
    {

        long delay = 10;
        int howManyTimes = 3;

        FitnessTracker myTracker = new FitnessTracker("Annett",1,45,40,30,50,"");


        int nightTimeCounter = 0;

        int greatCounter = 0; // more than 150 watts

        int lowCounter = 0; //less than 50 watts


        myTracker.setName("Annett");

        for (int x = 1; x<= howManyTimes; x++){

            myTracker.getInfo();



            myTracker.getCurrrentTime();

            myTracker.getEnergyLevel();

            Thread.sleep(delay);

            myTracker.goOn();


            }



        }


    }
