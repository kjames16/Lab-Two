import javax.swing.*;
import java.time.LocalDateTime;

public class EventFactory {

    public static Event getMeeting(JTextField[] textFields) {
        Event  event = new Meeting("dummy", LocalDateTime.of(1,1,1,1,1),LocalDateTime.of(1,1,1,1,1),"dummy");
        event.setName(textFields[0].getText());
        event.setDateTime(LocalDateTime.of(Integer.parseInt(textFields[1].getText()),Integer.parseInt(textFields[2].getText()),Integer.parseInt(textFields[3].getText()),
                Integer.parseInt(textFields[4].getText()),Integer.parseInt(textFields[5].getText())));
        if(event instanceof Meeting meeting) {
            meeting.setEndDateTime(LocalDateTime.of(Integer.parseInt(textFields[6].getText()),Integer.parseInt(textFields[7].getText()),Integer.parseInt(textFields[8].getText()),
                    Integer.parseInt(textFields[9].getText()),Integer.parseInt(textFields[10].getText())));
            meeting.setLocation(textFields[11].getText());
        }
        return event;
    }

    public static Event getDeadline(JTextField[] textFields) {
        Event event = new Deadline("dummy", LocalDateTime.of(1,1,1,1,1));
        event.setName(textFields[0].getText());
        event.setDateTime(LocalDateTime.of(Integer.parseInt(textFields[1].getText()),Integer.parseInt(textFields[2].getText()),Integer.parseInt(textFields[3].getText()),
                Integer.parseInt(textFields[4].getText()),Integer.parseInt(textFields[5].getText())));

        return event;

    }
}
