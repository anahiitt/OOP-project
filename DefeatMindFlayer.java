import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefeatMindFlayer extends JFrame implements ActionListener {
    private JTextArea conversation;
    private JButton roll;
    private JButton attack;
    private JButton close;

    private Player player;
    private MindFlayers mindFlayer;
    private boolean diceRolled = false;
    private boolean playerTurn;

    public DefeatMindFlayer(Player player, MindFlayers mindFlayer) {
        this.player = player;
        this.mindFlayer = mindFlayer;

        setTitle("Defeat the Mind Flayer");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        conversation = new JTextArea();
        conversation.setEditable(false);
        conversation.setFont(new Font("Arial", Font.PLAIN, 18));
        JScrollPane scrollPane = new JScrollPane(conversation);
        roll = new JButton("Roll Dice");
        attack = new JButton("Attack Mind Flayer");
        close = new JButton("Close");

        roll.addActionListener(this);
        attack.addActionListener(this);
        attack.setEnabled(false);
        close.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(roll);
        buttonPanel.add(attack);

        add(scrollPane, BorderLayout.CENTER);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(buttonPanel, BorderLayout.CENTER);
        inputPanel.add(close, BorderLayout.SOUTH);
        add(inputPanel, BorderLayout.SOUTH);
        setVisible(true);
        initiateConversation();
        playerTurn = true;
    }

    private void initiateConversation() {
        addMessage("Welcome to Level 4! This is the last torture before the final round.");
        addMessage("Now you are going to fight with a cunning Mind Flayer!");
        addMessage("Get ready to roll the dice and attack!");
    }

    private void addMessage(String message) {
        conversation.append(message + "\n\n");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == roll) {
            rollDice();
        } else if (e.getSource() == attack) {
            if (player.isAlive() && mindFlayer.isAlive()) {
                playerAttack();
                if (mindFlayer.isAlive()) {
                    mindFlayerAttack();
                }
            }
        }
    }

    private void rollDice() {
        int diceRoll = (int) (Math.random() * 6) + 1;
        int oldHitPoints = player.getHitPoints();
        int newHitPoints = oldHitPoints + diceRoll;
        player.setHitPoints(newHitPoints);

        addMessage("You rolled a " + diceRoll + "!");
        addMessage("Your hit points are now: " + newHitPoints);

        roll.setEnabled(false);
        attack.setEnabled(true);
    }

    private void playerAttack() {
        int initialMindFlayerHitPoints = mindFlayer.getHitPoints();
        player.attack(mindFlayer);
        int mindFlayerDamage = initialMindFlayerHitPoints - mindFlayer.getHitPoints();
        addMessage("Good job, you attacked the Mind Flayer!");
        addMessage("Mind Flayer's hit points: " + mindFlayer.getHitPoints());
        if (!mindFlayer.isAlive()) {
            addMessage("Congratulations! You defeated the Mind Flayer!");
            attack.setEnabled(false);
        } else {
            addMessage("Mind Flayer retaliates...");
            addMessage("Mind Flayer attacks back with " + mindFlayerDamage + " damage!");
        }
    }

    private void mindFlayerAttack() {
        int initialPlayerHitPoints = player.getHitPoints();
        mindFlayer.tentacleAttack(player);
        int playerDamage = initialPlayerHitPoints - player.getHitPoints();
        addMessage("Oh no, the Mind Flayer attacks with its tentacles!");
        addMessage("Your hit points: " + player.getHitPoints());
        if (!player.isAlive()) {
            addMessage("Oh no! You were defeated by the Mind Flayer! You lost");
            attack.setEnabled(false);
        } else {
            addMessage("You suffered " + playerDamage + " damage from the tentacles!");
        }
    }

    public static void implement(Player player, MindFlayers mindFlayer) {
        SwingUtilities.invokeLater(() -> new DefeatMindFlayer(player, mindFlayer));
    }
}

