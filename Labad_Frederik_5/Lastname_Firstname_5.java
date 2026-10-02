import javax.swing.*;
import java.awt.*;

public class EventRegistration {

    public static void main(String[] args) {

        JFrame frame =
                new JFrame("Campus Event Registration System");

        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10 ));

        JLabel lblName = new JLabel("Participant Name:");
        JTextField txtName = new JTextField(25);

        JLabel lblAge = new JLabel("Age:");
        JTextField txtAge = new JTextField(5);

        JLabel lblCollege = new JLabel("College/Department:");
        JTextField txtCollege = new JTextField(20);

        JLabel lblEvent = new JLabel("Event Category:");
        String[] events = {
            "Select Event", "Programming Competition", "Web Design Challenge", "Cybersecurity Seminar", "AI and Emerging Technologies", "IT Quiz Bowl"
        };
        JComboBox<String> cmbEvent = new JComboBox<>(events);

        JLabel lblAttendance = new JLabel("Attendance Type:");
        JRadioButton a = new JRadioButton("Student Participant");
        JRadioButton b = new JRadioButton("Student Audience");
        JRadioButton c = new JRadioButton("Faculty/Staff");

        ButtonGroup attendanceGroup = new ButtonGroup();
        attendanceGroup.add(a);
        attendanceGroup.add(b);
        attendanceGroup.add(c);

        JLabel lblWorkshop = new JLabel("Workshops to Attend:");
        JCheckBox V1 = new JCheckBox("Java Programming");

        JCheckBox V2 = new JCheckBox("Web Development");

        JCheckBox V3 = new JCheckBox("Cybersecurity");

        JCheckBox V4 = new JCheckBox("Artificial Intelligence");

        JCheckBox V5= new JCheckBox("Database Management");

        JLabel lblRequest = new JLabel("Special Request/Notes:");
        JTextArea txtRequest = new JTextArea(5, 30);

        txtRequest.setLineWrap(true);
        txtRequest.setWrapStyleWord(true);

        JButton btnRegister = new JButton("REGISTER");
        JButton btnClear = new JButton("CLEAR");


        frame.add(lblName);
        frame.add(txtName);

        frame.add(lblAge);
        frame.add(txtAge);

        frame.add(lblCollege);
        frame.add(txtCollege);

        frame.add(lblEvent);
        frame.add(cmbEvent);

        frame.add(lblAttendance);
        frame.add(a);
        frame.add(b);
        frame.add(c);

        frame.add(lblWorkshop);
        frame.add(V1);
        frame.add(V2);
        frame.add(V3);
        frame.add(V4);
        frame.add(V5);

        frame.add(lblRequest);
        frame.add(txtRequest);

        frame.add(btnRegister);
        frame.add(btnClear);

        btnRegister.addActionListener(e -> {

            String name = txtName.getText().trim();
            String ageText = txtAge.getText().trim();
            String college = txtCollege.getText().trim();
            String request = txtRequest.getText().trim();

            if (name.isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please enter the participant name.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (ageText.isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please enter the age.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int age;

            try {

                 age =
                        Integer.parseInt(ageText);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid whole number for age.", "Invalid Age", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (age <= 0) {
                JOptionPane.showMessageDialog(frame, "Age must be greater than zero.", "Invalid Age", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (college.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter the college/department.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (cmbEvent.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Please select an event category.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            String event = cmbEvent.getSelectedItem().toString();

            String attendance = "";
            if (a.isSelected()) {
                attendance = "Student Participant";
            }else if (b.isSelected()) {
                attendance = "Student Audience";
            }else if (c.isSelected()) {
                attendance = "Faculty/Staff";
            }else {
                JOptionPane.showMessageDialog(frame, "Please select an attendance type.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String workshops = "";
            if (V1.isSelected()) {
                workshops += "Java Programming\n";
            }
            if (V2.isSelected()) {
                workshops += "Web Development\n";
            }
            if (V3.isSelected()) {
                workshops += "Cybersecurity\n";
            }
            if (V4.isSelected()) {
                workshops += "Artificial Intelligence\n";
            }
            if (V5.isSelected()) {
                workshops += "Database Management\n";
            }
            
            if (workshops.isEmpty()) {
                workshops = "None";
            }

            if (request.isEmpty()) {
                request = "None";
            }

            String summary = "CAMPUS EVENT REGISTRATION\n\n" + "Participant Name: " + name + "\nAge: " + age + "\nCollege/Department: " + college + "\nEvent Category: " + event + "\nAttendance Type: " + attendance + "\n\nWorkshops:\n" + workshops + "\nSpecial Request/Notes:\n" + request;

            JOptionPane.showMessageDialog(frame, summary);
        });

        btnClear.addActionListener(e -> {

            txtName.setText("");
            txtAge.setText("");
            txtCollege.setText("");

            cmbEvent.setSelectedIndex(0);

            attendanceGroup.clearSelection();

            V1.setSelected(false);
            V2.setSelected(false);
            V3.setSelected(false);
            V4.setSelected(false);
            V5.setSelected(false);

            txtRequest.setText("");
        });

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}