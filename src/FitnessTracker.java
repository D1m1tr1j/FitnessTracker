
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FitnessTracker {

    private String name;
    private Calendar currentTime;
    private int heartbeat;
    private int activityLevel;
    private int activityTrend;
    private int energyLevel;

    // The document mentioned, that you would need an empty constructor
    public FitnessTracker() {
    }

    public String getInfo() {
        return "Tracker " + name + ": It is " + new SimpleDateFormat("HH:mm").format(getCurrentTime().getTime()) + "h, current heartbeat is " + heartbeat + ", activity level is " + activityLevel + "%\n" +
                "Current energy level is " + energyLevel + " Watt." + getAdditionalInfo();
    }

    public String getAdditionalInfo() {
        String additionalInfo = "";

        if (isNightTime(getCurrentHour())) {
            additionalInfo = " Note: currently night time!";
        } else if (energyLevel > 150) {
            additionalInfo = " Note: currently high energy level!";
        } else if (energyLevel < 50) {
            additionalInfo = " Note: currently low energy level!";
        }

        return additionalInfo;
    }

    public String getName() {
        return name;
    }

    // Read closely - we need to trim the String so that leading and trailing whitespace is removed
    public void setName(String aName) {
        if (!aName.trim().equals("")) {
            this.name = aName.trim();
        }
    }

    public Calendar getCurrentTime() {
        currentTime = Calendar.getInstance();
        return currentTime;
    }

    public int getCurrentHour() {
        return currentTime.get(Calendar.HOUR_OF_DAY);
    }

    public boolean isNightTime(int time) {
        if (time <= 6 || time >= 22) {
            System.out.println(" Note : Currently Night Time !");
            return true;

        } else return false;
    }

    public int getHeartbeat() {
        return heartbeat;
    }

    public void setHeartbeat() {
        int currentHour = getCurrentHour();
        if (isNightTime(currentHour)) {
            heartbeat = (int) (45 + (20 * Math.random() - 10));
        } else {
            heartbeat = (int) (50 + activityLevel * 1.52);
        }
    }

    public int getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel() {
        if (activityLevel < activityTrend) {
            activityLevel += 5;
        } else if (activityLevel > activityTrend) {
            activityLevel -= 4;
        // This if statement can be removed and you can leave a simple else here
        // If neither of both statements above are true, both values must be identical
        } else if (activityLevel == activityTrend) {
            setActivityTrend();
        }
    }

    public int getActivityTrend() {
        return activityTrend;
    }

    // Watch closely - although this method is a 'set', it doesn't mean you must provide a parameter
    // The document states, that the function doesn't have a parameter
    public void setActivityTrend() {
        activityTrend += (int) (20 * Math.random() - 10);
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    // Same here
    public void setEnergyLevel() {
        energyLevel = (int) (heartbeat * activityLevel / 32.1);
    }

    public void goOn() {
        setActivityLevel();
        setHeartbeat();
        setEnergyLevel();
    }
}


