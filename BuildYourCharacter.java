import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BuildYourCharacter extends JFrame implements ActionListener {
    private JTextArea conversation;
    private JTextField input;
    private JButton submit;
    private JButton close;

    private Player player;
    private Map map;

    public BuildYourCharacter(Map map) {
        this.map = map;
        setTitle("Build your DnD player");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        conversation = new JTextArea();
        conversation.setEditable(false);
        conversation.setFont(new Font("Arial", Font.PLAIN, 18));
        JScrollPane scrollPane = new JScrollPane(conversation);
        input = new JTextField();
        input.setFont(new Font("Arial", Font.PLAIN, 18));
        submit = new JButton("Submit");
        close = new JButton("Close");

        submit.addActionListener(this);
        close.addActionListener(this);

        add(scrollPane, BorderLayout.CENTER);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(input, BorderLayout.CENTER);
        inputPanel.add(submit, BorderLayout.EAST);
        inputPanel.add(close, BorderLayout.WEST);
        add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);

        initiateConversation();
    }

    private void initiateConversation() {
        addMessage("Hello, Adventurous Player. I am glad you decided to play this amazing and\n" +
                "interesting game. I am your Dungeon Master. Remember! I am not your enemy, I am your Friend\n" +
                "Let us begin this game. Let's build your character.");
        addMessage("What is your Player's name, my friend?");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String userInput = input.getText().trim();
            processUserInput(userInput);
            input.setText("");
        } else if (e.getSource() == close) {
            dispose();
        }
    }

    private void addMessage(String message) {
        conversation.append(message + "\n\n");
    }

    private void processUserInput(String userInput) {
        if (player == null) {
            player = new Player();
            if (player.getName() == null){
                String name = userInput;
                player.setName(name);
            }
            addMessage("Since you are just going to start the first level of Dungeons and Dragons\n" +
                    "your level will be 1.");
            player.setLevel(1);
            addMessage("Now let us talk about the hit points. These represent the life you have remaining.\n" +
                    "Now, I know you are a noble person who will choose their characteristics very wisely.\n" +
                    "However, I should remind you that as a first level player, you should choose your hit points\n" +
                    "no less than 6 and not more than 12. Let's see how up to a challenge person you are!");
            addMessage("Please enter your hit points:");
        } else if (player.getHitPoints() == 10) {
            try {
                int hitPoints = Integer.parseInt(userInput);
                player.setHitPoints(hitPoints);
                addMessage("Even though I am sure you do not lack strength and power, for your character,\n" +
                        "you need to choose a specific amount of strength. Note that the range should be from 10 to 12.");
                addMessage("Please enter your strength:");
            } catch (NumberFormatException ex) {
                addMessage("Invalid input!");
            }
        } else if (player.getStrength() == 10) {
            try {
                int strength = Integer.parseInt(userInput);
                player.setStrength(strength);
                addMessage("Last but not least, choose the level of your wisdom. Even though many of us would\n" +
                        "think that we are the smartest and wisest, however, it is also crucial to remain moderate.\n" +
                        "Again, choose a number to represent your wisdom from 11 or 12.");
                addMessage("Please enter your wisdom:");
            } catch (NumberFormatException ex) {
                addMessage("Invalid input!");
            }
        } else if (player.getWisdom() == 10) {
            try {
                int wisdom = Integer.parseInt(userInput);
                player.setWisdom(wisdom);
                addMessage("Congratulations, you are now an official player of Dungeons and Dragons.");
                addMessage("Here is your finalized information before you start your first level:");
                addMessage(player.toString());
                addMessage("I wish you good luck and a memorable win.");
            } catch (NumberFormatException ex) {
                addMessage("Invalid input!");
            }
        }
    }

    public static void implement(Map map) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BuildYourCharacter(map);
            }
        });
    }
}

