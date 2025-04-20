import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Scanner;



public class AddEventModal extends JFrame {

    private Event event;
    private LocalDateTime start_date;
    private LocalDateTime end_date;




    public AddEventModal(EventListPanel sourcePanel) {
        this.setTitle("Add Event");
        this.setPreferredSize(new Dimension(400, 300));
        this.setLayout(null);

        JButton meetingButton = new JButton("Meeting");
        meetingButton.setBounds(10, 10, 100, 30);

        JButton deadlineButton = new JButton("Deadline");
        deadlineButton.setBounds(150, 10, 100, 30);

        this.add(meetingButton);
        this.add(deadlineButton);





        meetingButton.addActionListener(e -> {


            JTextField[] textFields = new JTextField[]{new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField(),new JTextField(),
                                        new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField()};
            JLabel[] labels = new JLabel[] {new JLabel("Name"), new JLabel("Year"),
                    new JLabel("Month"), new JLabel("Day"), new JLabel("Hour"),
                    new JLabel("Minute"), new JLabel("End_Year"), new JLabel("End_Month"),
                    new JLabel("End_Day"), new JLabel("End_Hour"), new JLabel("End_Minute"),
            new JLabel("Location")};
            int T_x = 150;
            int T_y = 100;
            int L_x = 100;
            int L_y = 100;

            for (int i = 0; i < 12; i++) {
                textFields[i].setBounds(T_x, T_y, 100, 30);
                labels[i].setBounds(L_x, L_y, 100, 30);

                this.add(textFields[i]);
                this.add(labels[i]);

                T_y += 50;
                L_y += 50;

                revalidate();
                repaint();
            }

            JButton addButton = new JButton("Add");
            addButton.setBounds(350, 150, 100, 30);
            this.add(addButton);

            revalidate();
            repaint();

            addButton.addActionListener(l ->{
                event = EventFactory.getMeeting(textFields);


                for (EventPanel eventPanels : sourcePanel.getPanels())
                {
                    sourcePanel.getDisplayPanel().remove(eventPanels);
                    sourcePanel.revalidate();
                    sourcePanel.repaint();
                }



                sourcePanel.getEvents().add(event);

                sourcePanel.clearPanels();
                for(Event events : sourcePanel.getEvents())
                {
                    EventPanel eventPanel = new EventPanel(events);
                    sourcePanel.getPanels().add(eventPanel);
                    sourcePanel.getDisplayPanel().add(eventPanel);
                }

                sourcePanel.revalidate();
                sourcePanel.repaint();

            });


        });

        deadlineButton.addActionListener(e -> {




            JTextField[] textFields = new JTextField[]{new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField(),new JTextField()};
            JLabel[] labels = new JLabel[] {new JLabel("Name"), new JLabel("Year"),
                    new JLabel("Month"), new JLabel("Day"), new JLabel("Hour"), new JLabel("Minute")};
            int T_x = 150;
            int T_y = 100;
            int L_x = 100;
            int L_y = 100;

            for (int i = 0; i < 6; i++) {
                textFields[i].setBounds(T_x, T_y, 100, 30);
                labels[i].setBounds(L_x, L_y, 100, 30);

                this.add(textFields[i]);
                this.add(labels[i]);

                T_y += 50;
                L_y += 50;

                revalidate();
                repaint();
            }

            JButton addButton = new JButton("Add");
            addButton.setBounds(350, 150, 100, 30);
            this.add(addButton);

            revalidate();
            repaint();

            addButton.addActionListener(l ->{
                event = EventFactory.getDeadline(textFields);

                for (EventPanel eventPanels : sourcePanel.getPanels())
                {
                    sourcePanel.getDisplayPanel().remove(eventPanels);
                    sourcePanel.revalidate();
                    sourcePanel.repaint();
                }

                    //EventPanel eventPanel = new EventPanel(event);

                sourcePanel.getEvents().add(event);

                sourcePanel.clearPanels();
                for(Event events : sourcePanel.getEvents())
                {
                    EventPanel eventPanel = new EventPanel(events);
                    sourcePanel.getPanels().add(eventPanel);
                    sourcePanel.getDisplayPanel().add(eventPanel);
                }

                sourcePanel.revalidate();
                sourcePanel.repaint();

            });









        });




    }




}
