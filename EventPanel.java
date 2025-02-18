import javax.swing.*;

import java.awt.*;
import java.time.LocalDateTime;

import static java.awt.Color.BLUE;

public class EventPanel extends JPanel {

    private final Event event;

    public EventPanel(Event event) {

        this.event = event;

        this.setPreferredSize(new Dimension(125, 100));
        this.setBackground(BLUE);

        //Button that completes the event(sets complete variable to true)
        JButton completeButton = new JButton("Complete");

        this.add(completeButton);
        completeButton.addActionListener(e -> {
            if(event instanceof Meeting meeting) {
                meeting.complete();
                this.setBackground(Color.GREEN);
                revalidate();
                repaint();
            }
            if(event instanceof Deadline deadline) {
                deadline.complete();
                this.setBackground(Color.GREEN);
                revalidate();
                repaint();
            }
        });

        if(event instanceof Meeting meeting) {
            if(meeting.isComplete()) {
                this.setBackground(Color.GREEN);
                revalidate();
                repaint();
            }
        }
        if(event instanceof Deadline deadline) {
            if(deadline.isComplete()) {
                this.setBackground(Color.GREEN);
                revalidate();
                repaint();
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(event.getName(),1,50);
        g.drawString(event.getDateTime().toString(),1,75);
        if(event instanceof Meeting meeting){
            g.drawString(meeting.getEndDateTime().toString(),1,85);
            g.drawString(meeting.getLocation(),1,95);
        }



    }
}
