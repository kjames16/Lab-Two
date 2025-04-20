import javax.swing.*;
import java.time.LocalDateTime;

public class Deadline extends Event implements Completable, Labels{


    public Deadline(String name, LocalDateTime deadline) {
            super(name,deadline);
       //this.setName(name);
       //this.setDateTime(deadline);
    }

    private boolean completed;



    public void complete() {
        completed = true;
    }
    public boolean isComplete() {
        return completed;
    }

    public JTextField[] getTextFields() {
        JTextField[] textFields = new JTextField[]{new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField(),new JTextField()};
        return textFields;
    }

    public JLabel[] getLabels() {
        JLabel[] labels = new JLabel[] {new JLabel("Name"), new JLabel("Year"),
                new JLabel("Month"), new JLabel("Day"), new JLabel("Hour"), new JLabel("Minute")};
        return labels;
    }



}
