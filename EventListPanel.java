import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EventListPanel extends JPanel {

   LocalDateTime deadline = LocalDateTime.of(2024, 12, 7, 17, 0);
     String lastDeadlineName = "Last Deadline";
     Deadline lastDeadline = new Deadline(lastDeadlineName, deadline );

    private ArrayList<Event> events;
    private JPanel controlPanel = new JPanel();
    private JPanel displayPanel = new JPanel();
    private JComboBox sortDropDown = new JComboBox();
    private JCheckBox filterDisplay;
    private JButton addEventButton = new JButton("Add Event");
    public EventListPanel() {

        addEventButton.addActionListener(e -> {
            JFrame addEventModal = new AddEventModal(this);
            addEventModal.setVisible(true);

            //displayPanel.add(new EventPanel(addEventModal.getEvent()));

            revalidate();
            repaint();

        });

        controlPanel.setBackground(Color.BLACK);
        controlPanel.setPreferredSize(new Dimension(600, 100));
        controlPanel.add(addEventButton);
        this.add(controlPanel);

        //displayPanel.setBackground(Color.BLUE);
        displayPanel.setPreferredSize(new Dimension(600, 600));
        displayPanel.setBackground(Color.RED);
        displayPanel.add(sortDropDown);
        //default event
        displayPanel.add(new EventPanel(lastDeadline));

        this.add(displayPanel);

        //Create the array of events
        //have the button add to that array
        //make a function that updates the list panel
        //       -adds the events from the array then repaints




    }

    public JPanel getDisplayPanel() {
        return displayPanel;
    }
}
