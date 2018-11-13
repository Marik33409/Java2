import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Form {
    JTextArea chatArea;
    JTextField msg;
    private JButton sendButton;
    JPanel panel;

    public Form() {
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(msg.getText());
            }
        });
        msg.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage(msg.getText());
                }
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("JavaChat");
        frame.setContentPane(new Form().panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void sendMessage(String msg) {
        chatArea.setText(msg);
    }
}
