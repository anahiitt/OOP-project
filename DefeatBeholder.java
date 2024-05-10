import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefeatBeholder extends JFrame implements ActionListener {
    private JTextArea conversation;
    private JButton roll;
    private JButton attack;
    private JButton close;

    private Player player;
    private Beholder beholder;
    private boolean diceRolled = false;
    private boolean playerTurn;

    public DefeatBeholder(Player player, Beholder beholder) {
        this.player = player;
        this.beholder = beholder;

        setTitle("Defeat the Beholder");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        conversation = new JTextArea();
        conversation.setEditable(false);
        conversation.setFont(new Font("Arial", Font.PLAIN, 18));
        JScrollPane scrollPane = new JScrollPane(conversation);
        roll = new JButton("Roll Dice");
        attack = new JButton("Attack Beholder");
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
        addMessage("Welcome to Level 1! I wish you good luck.");
        addMessage("Now you are going to fight with a fearsome Beholder!");
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
            if (player.isAlive() && beholder.isAlive()) {
                playerAttack();
                if (beholder.isAlive()) {
                    beholderAttack();
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
        int initialBeholderHitPoints = beholder.getHitPoints();
        player.attack(beholder);
        int beholderDamage = initialBeholderHitPoints - beholder.getHitPoints();
        addMessage("Good job, you attacked the Beholder!");
        addMessage("Beholder's hit points: " + beholder.getHitPoints());
        if (!beholder.isAlive()) {
            addMessage("Congratulations! You defeated the Beholder!");
            attack.setEnabled(false);
        } else {
            addMessage("Beholder climbs to attack...");
            addMessage("Beholder attacks back with " + beholderDamage + " damage!");
        }
    }

    private void beholderAttack() {
        int initialPlayerHitPoints = player.getHitPoints();
        beholder.attack(player);
        int playerDamage = initialPlayerHitPoints - player.getHitPoints();
        addMessage("Oh my God, beholder attacks!");
        addMessage("Your hit points: " + player.getHitPoints());
        if (!player.isAlive()) {
            addMessage("Oh no! You were defeated by the Beholder! You lost");
            attack.setEnabled(false);
        } else {
            addMessage("You suffered " + playerDamage + " damage!");
        }
    }
    public static void implement(Player player, Beholder beholder) {
        SwingUtilities.invokeLater(() -> new DefeatBeholder(player, beholder));
    }
}
