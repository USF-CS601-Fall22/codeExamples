package designPatterns.mvc.simple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentView implements Observer  {

    private JFrame viewFrame;
    private JPanel viewPanel;

    private JLabel studentNameLabel;
    private JTextArea studentNewNameLabel;

    private JTextField studentNameTextField1;
    private JTextField studentNameTextField2;

    private JButton studentNameButton;

    private Controller controller = null;
    private Model model = null;

    public StudentView(Model model, Controller controller) {
        this.controller = controller;
        this.model = model;
        model.registerObserver(this);
    }

    public void createView() {
        viewFrame = new JFrame("Student Database");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(100, 80));
        viewPanel = new JPanel(new GridLayout(1, 2));

        studentNewNameLabel = new JTextArea(model.toString());

        studentNameTextField1 = new JTextField(2);
        studentNameTextField2 = new JTextField(2);

        studentNameLabel = new JLabel("Change name:", SwingConstants.RIGHT);
        studentNameButton = new JButton("Change name");
        StudentNameButtonListener listener = new StudentNameButtonListener();
        studentNameButton.addActionListener(listener);

        viewPanel.add(studentNewNameLabel);

        viewPanel.add(studentNameLabel);
        viewPanel.add(studentNameTextField1);
        viewPanel.add(studentNameTextField2);
        viewPanel.add(studentNameButton);


        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
        viewFrame.pack();
        viewFrame.setVisible(true);


    }

    @Override
    public void update() {
        studentNewNameLabel.setText(model.toString());

    }

    private class StudentNameButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println("Button clicked ");
            controller.changeStudentName(studentNameTextField1.getText(), studentNameTextField2.getText());
        }
    }


}