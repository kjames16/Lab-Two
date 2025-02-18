import javax.swing.*;
import java.time.LocalDateTime;

public class EventPlanner {

    static LocalDateTime deadline = LocalDateTime.of(2024, 12, 7, 17, 0);
    static String lastDeadlineName = "Last Deadline";
    static Deadline lastDeadline = new Deadline(lastDeadlineName, deadline );

    static EventListPanel eventListPanel = new EventListPanel();

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        LocalDateTime startTime = LocalDateTime.now();
        frame.getContentPane().add(eventListPanel);



        frame.setVisible(true);

    }

     public static void addDefaultEvents(EventListPanel events) {
        events.add(new EventPanel(lastDeadline));


    }
}
