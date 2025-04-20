import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EventListPanel extends JPanel {

   LocalDateTime deadline = LocalDateTime.of(2024, 12, 7, 17, 0);
     String lastDeadlineName = "Last Deadline";
     Deadline lastDeadline = new Deadline(lastDeadlineName, deadline );
     String[] sort = {"Name", "Date", "ReverseName"};

    private ArrayList<Event> events = new ArrayList<>();
    private ArrayList<EventPanel> panels = new ArrayList<>();
    private JPanel controlPanel = new JPanel();
    private JPanel displayPanel = new JPanel();
    private JComboBox sortDropDown = new JComboBox(sort);
    private JCheckBox[] filterDisplay = new JCheckBox[] {new JCheckBox("Deadlines"), new JCheckBox("Meetings"), new JCheckBox("Completed")};
    private JButton addEventButton = new JButton("Add Event");
    public EventListPanel() {

        addEventButton.addActionListener(e -> {
            JFrame addEventModal = new AddEventModal(this);
            addEventModal.setVisible(true);

            //displayPanel.add(new EventPanel(addEventModal.getEvent()));

            revalidate();
            repaint();

        });

        //controlPanel.setBackground(Color.BLACK);
        controlPanel.setPreferredSize(new Dimension(600, 100));
        controlPanel.add(addEventButton);
        this.add(controlPanel);
        controlPanel.add(sortDropDown);
        for(JCheckBox filter : filterDisplay) {
            controlPanel.add(filter);
        }

        //displayPanel.setBackground(Color.BLUE);
        displayPanel.setPreferredSize(new Dimension(600, 600));
        displayPanel.setBorder(new LineBorder(Color.BLACK, 5));

        //default event
        EventPanel ep = new EventPanel(lastDeadline);
        displayPanel.add(ep);
        panels.add(ep);

        this.add(displayPanel);

        for(JCheckBox filters : filterDisplay) {
            filters.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(filterDisplay[0].isSelected()) {
                    for(Event event: events) {
                        if(event instanceof Deadline) {
                            event.filter();
                        }
                    }
                    updatePanels();
                }
                else {
                    for(Event event: events) {
                        if(event instanceof Deadline) {
                            event.unfilter();
                        }
                    }
                    updatePanels();
                }

                if(filterDisplay[1].isSelected()) {
                    for(Event event: events) {
                        if(event instanceof Meeting) {
                            event.filter();
                        }
                    }
                    updatePanels();
                }
                else {
                    for(Event event: events) {
                        if(event instanceof Meeting) {
                            event.unfilter();
                        }
                    }
                    updatePanels();
                }

                if(filterDisplay[2].isSelected()) {
                    for(Event event: events) {
                        if(event instanceof Deadline || event instanceof Meeting) {
                            if(((Completable) event).isComplete())
                                event.filter();
                        }
                    }
                    updatePanels();
                }
                else {
                    for(Event event: events) {
                        if(event instanceof Deadline || event instanceof Meeting) {
                            if(((Completable) event).isComplete())
                                event.unfilter();
                        }
                    }
                    updatePanels();
                }
            }
        });}




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
            if(sortDropDown.getSelectedIndex() == 0) {
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
            if (sortDropDown.getSelectedIndex() == 2) {
                for (int i = 0; i < events.size() - 1; i++) {
                    boolean swapped = false;

                    for (int j = 0; j < events.size() - i - 1; j++) {
                        if (events.get(j).compareTo(events.get(j + 1)) < 0) {
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

    public void updatePanels() {
        for (EventPanel eventPanels : panels)
        {
            displayPanel.remove(eventPanels);
            displayPanel.revalidate();
            displayPanel.repaint();
        }
        clearPanels();
        for(Event ev : events)
        {
            if(ev.isFiltered())
                continue;
            EventPanel eventPanel = new EventPanel(ev);
            panels.add(eventPanel);
            displayPanel.add(eventPanel);

        }

        displayPanel.revalidate();
        displayPanel.repaint();
    }


}
