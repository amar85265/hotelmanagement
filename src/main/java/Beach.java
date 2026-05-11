// CLASS
public class Beach {

    // Attributes (fields)
    private String activityName;
    private String location;
    private String timeOfDay;

    // Constructor
    public Beach(String activityName, String location, String timeOfDay) {
        this.activityName = activityName;
        this.location = location;
        this.timeOfDay = timeOfDay;
    }

    // Method
    public void doActivity() {
        System.out.println("At " + location + " beach, during " + timeOfDay + " → " + activityName);
    }

    // Getters & Setters
    public String getActivityName() { return activityName; }
    public String getLocation() { return location; }
    public String getTimeOfDay() { return timeOfDay; }


    public void setActivityName(String activityName) { this.activityName = activityName; }
    public void setLocation(String location) { this.location = location; }
    public void setTimeOfDay(String timeOfDay) { this.timeOfDay = timeOfDay; }
}

