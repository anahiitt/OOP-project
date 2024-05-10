import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefeatDemon extends JFrame implements ActionListener {
    private JTextArea conversation;
    private JButton roll;
    private JButton attack;
    private JButton close;

    private Player player;
    private Demon demon;
    private boolean diceRolled = false;
    private boolean playerTurn;

    public DefeatDemon(Player player, Demon demon) {
        this.player = player;
        this.demon = demon;

        setTitle("Defeat the Demon");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        conversation = new JTextArea();
        conversation.setEditable(false);
        conversation.setFont(new Font("Arial", Font.PLAIN, 18));
        JScrollPane scrollPane = new JScrollPane(conversation);
        roll = new JButton("Roll Dice");
        attack = new JButton("Attack Demon");
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
        addMessage("Welcome to Level 3! Wow, congratulations on your defeating two monsters.");
        addMessage("Now you are going to fight with a scary Demon!");
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
            if (player.isAlive() && demon.isAlive()) {
                playerAttack();
                if (demon.isAlive()) {
                    demonAttack();
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
        int initialDemonHitPoints = demon.getHitPoints();
        player.attack(demon);
        int demonDamage = initialDemonHitPoints - demon.getHitPoints();
        addMessage("Good job, you attacked the Demon!");
        addMessage("Demon's hit points: " + demon.getHitPoints());
        if (!demon.isAlive()) {
            addMessage("Congratulations! You defeated the Demon!");
            attack.setEnabled(false);
        } else {
            addMessage("Demon retaliates...");
            addMessage("Demon attacks back with " + demonDamage + " damage!");
        }
    }

    private void demonAttack() {
        int initialPlayerHitPoints = player.getHitPoints();
        demon.attackWithDarkMagic(player);
        int playerDamage = initialPlayerHitPoints - player.getHitPoints();
        addMessage("Oh no, the Demon casts dark magic!");
        addMessage("Your hit points: " + player.getHitPoints());
        if (!player.isAlive()) {
            addMessage("Oh no! You were defeated by the Demon! You lost");
            attack.setEnabled(false);
        } else {
            addMessage("You suffered " + playerDamage + " damage!");
        }
    }

    public static void implement(Player player, Demon demon) {
        SwingUtilities.invokeLater(() -> new DefeatDemon(player, demon));
    }
}
