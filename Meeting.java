import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class Meeting extends Event implements Completable {
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
}
