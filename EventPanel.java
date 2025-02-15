import javax.swing.*;

import java.awt.*;

import static java.awt.Color.BLUE;

public class EventPanel extends JPanel {

    private final Event event;

    public EventPanel(Event event) {
        this.event = event;

        this.setPreferredSize(new Dimension(100, 100));
        this.setBackground(BLUE);

        //Button that completes the event(sets complete variable to true)
        JButton completeButton = new JButton("Complete");
        this.add(completeButton);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(event.getName(),100,100);
        g.drawString(event.getDateTime().toString(),150,100);


    }
}
