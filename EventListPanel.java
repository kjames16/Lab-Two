import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EventListPanel extends JPanel {

    private ArrayList<Event> events;
    private JPanel controlPanel = new JPanel();
    private JPanel displayPanel = new JPanel();
    private JComboBox sortDropDown = new JComboBox();
    private JCheckBox filterDisplay;
    private JButton addEventButton = new JButton("Add Event");
    public EventListPanel() {

        addEventButton.addActionListener(e -> {
            AddEventModal addEventModal = new AddEventModal();
            addEventModal.setVisible(true);

            displayPanel.add(new EventPanel(addEventModal.getEvent()));

            repaint();
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


        this.add(displayPanel);




    }


}
