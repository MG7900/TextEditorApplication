import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextEditorApp implements ActionListener {
    private JFrame mainFrame;
    private JPanel controlPanel;
    public JTextArea ta;
    public JTextArea ta2;
    private int WIDTH = 1000;
    private int HEIGHT = 800;
    public String currenttext;
    public String capitalizedtext;
    public String Loweredtext;


    public TextEditorApp() {
        prepareGUI();
    }

    public static void main(String[] args) {
        TextEditorApp swingControlDemo = new TextEditorApp();
        swingControlDemo.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java Interaction Page");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new BorderLayout());

        ta = new JTextArea();
        mainFrame.add(ta, BorderLayout.NORTH);

        controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        mainFrame.add(controlPanel, BorderLayout.CENTER);

        ta2 = new JTextArea();
        ta2.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(ta2);
        controlPanel.add(scrollPane);
        //found scrollPanel existed from online searching panel types

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        mainFrame.setVisible(true);
    }

    private void showEventDemo() {
        JButton submitButton = new JButton("Submit");
        JButton resetButton = new JButton("Reset");
        JButton capitalizeButton = new JButton("Capitalize");
        JButton lowercaseButton = new JButton("Lower Case");

        submitButton.setActionCommand("Submit");
        resetButton.setActionCommand("Reset");
        capitalizeButton.setActionCommand("Capitalize");
        lowercaseButton.setActionCommand("Lower Case");

        submitButton.addActionListener(new ButtonClickListener());
        resetButton.addActionListener(new ButtonClickListener());
        capitalizeButton.addActionListener(new ButtonClickListener());
        lowercaseButton.addActionListener(new ButtonClickListener());

        controlPanel.add(submitButton);
        controlPanel.add(resetButton);
        controlPanel.add(capitalizeButton);
        controlPanel.add(lowercaseButton);

        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    //    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == reset) {
//            ta.setText("");
//            ta2.setText("");
//        }
//        if(e.getSource() == submit) {
//            currenttext = ta.getText();
//            ta2.append("\n" + currenttext);
//        }
//    }
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            System.out.println("working");
            if (command.equals("Submit")) {
                currenttext = ta.getText();
                ta2.append("\n" + currenttext);
            }
            if (command.equals("Reset")) {
                ta.setText("");
                ta2.setText("");
            }
            if (command.equals("Capitalize")){
                currenttext = ta.getText();
                capitalizedtext = currenttext.toUpperCase();
                ta2.append("\n" + capitalizedtext);
            }
            if (command.equals("Lower Case")) {
                currenttext = ta.getText();
                System.out.println("It works lol");
                Loweredtext = currenttext.toLowerCase();
                ta2.append("\n" + Loweredtext);
            }
        }
    }
}

