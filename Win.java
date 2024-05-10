import javax.swing.*;
import java.awt.*;

public class Win extends JFrame {
    private JTextArea conversation;

    public Win() {
        setTitle("Congratulations!");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        conversation = new JTextArea();
        conversation.setEditable(false);
        conversation.setFont(new Font("Arial", Font.PLAIN, 18));
        JScrollPane scrollPane = new JScrollPane(conversation);

        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
        initiateConversation();
    }

    private void initiateConversation() {
        addMessage("Congratulations! You won!");
        addMessage("Thank you for playing this game, it was an honor\n" +
                "and delight to go through the adventurous levels of\n" +
                "Dungeons and Dragons with you. You showed your nobility,\n" +
                "strength, wisdom and honor during this game. I\n" +
                "hope you enjoyed it as much as I did. From now on,\n" +
                "you are a Dungeons and Dragons winner. Don't forget\n" +
                "your huge trophy\n");
    }

    private void addMessage(String message) {
        conversation.append(message + "\n\n");
    }

    public static void implement() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Win();
            }
        });
    }
}

