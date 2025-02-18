import javax.swing.*;

import java.awt.*;
import java.time.LocalDateTime;

import static java.awt.Color.BLUE;

public class EventPanel extends JPanel {

    private final Event event;

    public EventPanel(Event event) {
       // if (ismeeting) {
             //Meeting meeting = new Event("dummy", LocalDateTime.of(1,1,1,1,1),LocalDateTime.of(1,1,1,1,1),"dummy");
             //event = meeting;




      //  }
       // else{
            this.event = event;
       // }


        this.setPreferredSize(new Dimension(125, 100));
        this.setBackground(BLUE);

        //Button that completes the event(sets complete variable to true)
        JButton completeButton = new JButton("Complete");

        this.add(completeButton);


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(event.getName(),1,50);
        g.drawString(event.getDateTime().toString(),1,75);
        //g.drawString(event.get)


    }
}
