import javax.swing.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class Meeting extends Event implements Completable, Labels{
    private LocalDateTime endDateTime;
    private String location;
    private boolean completed;



    public void complete() {
        completed = true;
    }
    public boolean isComplete() {
        return completed;
    }

    public Meeting(String name,  LocalDateTime start, LocalDateTime end, String location) {
        super(name,start);
        this.endDateTime = end;
        this.location = location;

    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public String getLocation() {
        return location;
    }

    public Duration getDuration() {
        return Duration.between(this.getDateTime(), endDateTime);
    }

    public void setEndDateTime(LocalDateTime end) {
        this.endDateTime = end;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public JTextField[] getTextFields() {
        JTextField[] textFields = new JTextField[]{new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField(),new JTextField(),
                new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField()};
        return textFields;
    };
    public JLabel[] getLabels() {
        JLabel[] labels = new JLabel[] {new JLabel("Name"), new JLabel("Year"),
                new JLabel("Month"), new JLabel("Day"), new JLabel("Hour"),
                new JLabel("Minute"), new JLabel("End_Year"), new JLabel("End_Month"),
                new JLabel("End_Day"), new JLabel("End_Hour"), new JLabel("End_Minute"),
                new JLabel("Location")};
        return labels;
    };

}
