import java.time.LocalDateTime;

public class Event implements Comparable<Event> {

    private String name;
    private LocalDateTime dateTime;
    private boolean filterd = false;

    public Event(String event, LocalDateTime dateTime) {
        this.name = event;
        this.dateTime = dateTime;
    }

    public String getName() {
        return this.name;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    // compares the date of this Event of the incoming event and returns an int.
    // positive if this event comes later
    // negative if this event comes before
    // 0 if they have the same date
    public int compareTo(Event e) {
        return this.dateTime.compareTo(e.dateTime);
    }

    public boolean isFiltered() {return filterd;}
    public void filter() {this.filterd = true;}
    public void unfilter() {this.filterd = false;}

}
