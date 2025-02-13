import java.time.LocalDateTime;

public class Deadline extends Event implements Completable{


    public Deadline(String name, LocalDateTime deadline) {
            super(name,deadline);
       //this.setName(name);
       //this.setDateTime(deadline);
    }

    private boolean completed;


    public void complete() {
        completed = true;
    }
    public boolean isComplete() {
        return completed;
    }
}
