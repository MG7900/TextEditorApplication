import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextEditorApp implements ActionListener{
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JMenuBar mb;
    private JMenu file, edit, help;
    private JMenuItem cut, copy, paste, selectAll;
    private JTextArea ta;
    private int WIDTH=800;
    private int HEIGHT=700;

    public TextEditorApp() {
        prepareGUI();
    }

    public static void main(String[] args) {
        TextEditorApp swingControlDemo = new TextEditorApp();
        swingControlDemo.showEventDemo();
    }

    private void prepareGUI() {

    }

    private void showEventDemo() {

    }

    public void actionPerformed(ActionEvent e) {

    }

    private class ButtonClickListener implements ActionListener {

    }
}

