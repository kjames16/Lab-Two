import java.time.LocalDateTime;

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

    public Meeting(LocalDateTime end, String location, String name, LocalDateTime start) {

    }
}
