
import java.time.LocalTime;
import java.time.ZoneId;

public class FitnessTracker {

    private String name;
    private int currrentTime;
    private  int heartbeat;
    private int activityLevel;
    private int activityTrend;
    private int energyLevel;
    private String info;


public FitnessTracker(String name,int currrentTime, int heartbeat, int  activityLevel, int activityTrend, int energyLevel, String info){

    this.name = name;
    this.currrentTime = currrentTime;
    this.heartbeat = heartbeat;
    this.activityLevel = activityLevel;
    this.activityTrend = activityTrend;
    this.energyLevel = energyLevel;
    this.info=info;

}
    public String getInfo(){
        System.out.println("Tracker" + name + ":" + currrentTime + "h" + heartbeat + activityLevel + "%" + energyLevel + "Watt");
        return info;
    }



    public String getName() {
        return name;
    }

        public void setName(String aName){
            if (aName != "") {
                this.name = aName;
            }
            else {
                this.name = name;
            }
        }

    public int getCurrrentTime() {
        return currrentTime;
    }

        public void setCurrrentTime(int currrentTime) {

            LocalTime rightNow = LocalTime.now(ZoneId.of("Europe/Berlin"));
            currrentTime = rightNow.getHour() + rightNow.getMinute();
            this.currrentTime = currrentTime;
        }

        public boolean isNightTime(boolean night,int time ){

    if ((time > 0 && time < 6) || time > 22 && time < 24){
        System.out.println(" Note : Currently Night Time !");
        return night;

            }
    else return false;
        }

    public int getHeartbeat() {
        return heartbeat;
    }

    public void setHeartbeat(int heartbeat) {
        if ((heartbeat < 0) || (heartbeat > 250)) {
            System.out.println("value is out of range");
        }

        else if (isNightTime(true,currrentTime)) {
        heartbeat = 45;
        heartbeat += (int) (20 * Math.random() - 11);
    }
    else {
        heartbeat = (int) (50 + activityLevel * 1.52);
    }
        this.heartbeat = heartbeat;
    }

     {
    }

    public int getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(int activityLevel) {
        if ((activityLevel < 0) || (activityLevel > 100)) {
            System.out.println("value is out of range");
        }

        else if (activityLevel < activityTrend){
            activityLevel += 5;
        }

        else if (activityLevel > activityTrend){
            activityLevel -= 4;
        }

        else if (activityLevel == activityTrend){
            setActivityTrend(activityLevel);
        }

        this.activityLevel = activityLevel;
    }

    public int getActivityTrend() {
        return activityTrend;
    }
    public void setActivityTrend(int activityTrend) {
        if ((activityTrend < 0) || (activityTrend > 100)) {
            System.out.println("value is out of range");
        }
        else {
            activityTrend += (int) (20 * Math.random() - 10);

            this.activityTrend = activityTrend;
        }
    }

    public int getEnergyLevel() {
        return energyLevel;
    }
    public void setEnergyLevel(int energyLevel) {
        if ((energyLevel < 0) || (energyLevel > 1000)) {
            System.out.println("value is out of range");
        }
        else {

            energyLevel = (int) (heartbeat * activityLevel / 32.1);


            this.energyLevel = energyLevel;
        }
    }



    public void goOn(){
    setActivityLevel(activityLevel);
    setHeartbeat(heartbeat);
    setEnergyLevel(energyLevel);
    }





}


