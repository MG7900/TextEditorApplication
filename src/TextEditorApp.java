import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class TextEditorApp implements ActionListener {
    private JFrame mainFrame;
    private JPanel controlPanel;
    public JTextArea ta;
    public JTextArea ta2;
    private int WIDTH = 800;
    private int HEIGHT = 700;
    public String currenttext;


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
        mainFrame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2,2,2,2);
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 800;
        c.ipady = 10;
        ta = new JTextArea();
        mainFrame.add(ta, c);

        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 10;
        c.ipady = 10;
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainFrame.add(controlPanel,c);

        c.gridx = 0;
        c.gridy = 2;
        c.ipadx = 800;
        c.ipady = 100;
        ta2 = new JTextArea();
        mainFrame.add(ta2,c);

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

        submitButton.setActionCommand("Submit");
        resetButton.setActionCommand("Reset");

        submitButton.addActionListener(new ButtonClickListener());
        resetButton.addActionListener(new ButtonClickListener());

        controlPanel.add(submitButton);
        controlPanel.add(resetButton);

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
            } else if (command.equals("Reset")) {
                ta.setText("");
                ta2.setText("");
            }
        }
    }
}

