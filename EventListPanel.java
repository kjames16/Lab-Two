import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EventListPanel extends JPanel {

   LocalDateTime deadline = LocalDateTime.of(2024, 12, 7, 17, 0);
     String lastDeadlineName = "Last Deadline";
     Deadline lastDeadline = new Deadline(lastDeadlineName, deadline );
     String[] sort = {"Name", "Date"};

    private ArrayList<Event> events = new ArrayList<>();
    private ArrayList<EventPanel> panels = new ArrayList<>();
    private JPanel controlPanel = new JPanel();
    private JPanel displayPanel = new JPanel();
    private JComboBox sortDropDown = new JComboBox(sort);
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
        EventPanel ep = new EventPanel(lastDeadline);
        displayPanel.add(ep);
        panels.add(ep);

        this.add(displayPanel);






        sortDropDown.setSelectedIndex(0);
        sortDropDown.addActionListener(e -> {
            if (sortDropDown.getSelectedIndex() == 1) {
                for (int i = 0; i < events.size() - 1; i++) {
                    boolean swapped = false;

                    for (int j = 0; j < events.size() - i - 1; j++) {
                        if (events.get(j).compareTo(events.get(j + 1)) > 0) {
                            Event temp = events.get(j);
                            events.set(j, events.get(j + 1));
                            events.set(j + 1, temp);
                            swapped = true;
                        }
                    }
                    if (!swapped) {
                        break;
                    }
                }

                for (EventPanel eventPanels : panels)
                {
                    displayPanel.remove(eventPanels);
                    displayPanel.revalidate();
                    displayPanel.repaint();
                }
                clearPanels();
                for(Event ev : events)
                {
                    EventPanel eventPanel = new EventPanel(ev);
                    panels.add(eventPanel);
                    displayPanel.add(eventPanel);

                }

                displayPanel.revalidate();
                displayPanel.repaint();

            }
            else{
                for (int i = 0; i < events.size() - 1; i++) {
                    boolean swapped = false;

                    for (int j = 0; j < events.size() - i - 1; j++) {
                        if (events.get(j).getName().compareTo(events.get(j + 1).getName()) > 0) {
                            Event temp = events.get(j);
                            events.set(j, events.get(j + 1));
                            events.set(j + 1, temp);
                            swapped = true;
                        }
                    }
                    if (!swapped) {
                        break;
                    }
                }

                for (EventPanel eventPanels : panels)
                {
                    displayPanel.remove(eventPanels);
                    displayPanel.revalidate();
                    displayPanel.repaint();
                }
                clearPanels();
                for(Event ev : events)
                {
                    EventPanel eventPanel = new EventPanel(ev);
                    panels.add(eventPanel);
                    displayPanel.add(eventPanel);

                }

                displayPanel.revalidate();
                displayPanel.repaint();
            }

        });



    }

    public JPanel getDisplayPanel() {
        return displayPanel;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public ArrayList<EventPanel> getPanels() {
        return panels;
    }

    public void clearPanels() {
        for (int i = 0; i < panels.size(); i++) {
            panels.remove(panels.get(i));
        }



    }


}
