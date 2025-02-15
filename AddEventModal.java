import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class AddEventModal extends JDialog {

    private Event event;
    private LocalDateTime start_date;
    private LocalDateTime end_date;

    public AddEventModal() {
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
            Scanner input = new Scanner(System.in);
            System.out.print("Name: ");
            String name = input.nextLine();
            System.out.println("Start date:");
            System.out.print("Year: ");
             int year = input.nextInt();
            System.out.print("Month: ");
            int month = input.nextInt();
            System.out.print("Day: ");
            int day = input.nextInt();
            System.out.print("Hour: ");
            int hour = input.nextInt();
            System.out.print("Minute: ");
            int minute = input.nextInt();
            start_date = LocalDateTime.of(year, month, day, hour, minute);

            System.out.println("End date:");
            System.out.print("Hour: ");
            hour = input.nextInt();
            System.out.print("Minute: ");
            minute = input.nextInt();
            start_date = LocalDateTime.of(year, month, day, hour, minute);

            System.out.print("Location: ");
            String location = input.nextLine();

            this.event = new Meeting(name, start_date, end_date, location);


        });

        deadlineButton.addActionListener(e -> {
            Scanner input = new Scanner(System.in);
            System.out.print("Name: ");
            String name = input.nextLine();
            System.out.println("Deadline:");
            System.out.print("Year: ");
            int year = input.nextInt();
            System.out.print("Month: ");
            int month = input.nextInt();
            System.out.print("Day: ");
            int day = input.nextInt();
            System.out.print("Hour: ");
            int hour = input.nextInt();
            System.out.print("Minute: ");
            int minute = input.nextInt();
            start_date = LocalDateTime.of(year, month, day, hour, minute);

            this.event = new Deadline(name, start_date);
        });
    }

    public Event getEvent() {
        return event;
    }
}
