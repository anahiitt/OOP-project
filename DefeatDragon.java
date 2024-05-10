import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefeatDragon extends JFrame implements ActionListener {
    private JTextArea conversation;
    private JButton roll;
    private JButton attack;
    private JButton close;

    private Player player;
    private Dragon dragon;
    private boolean diceRolled = false;
    private boolean playerTurn;

    public DefeatDragon(Player player, Dragon dragon) {
        this.player = player;
        this.dragon = dragon;

        setTitle("Defeat the Dragon");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        conversation = new JTextArea();
        conversation.setEditable(false);
        conversation.setFont(new Font("Arial", Font.PLAIN, 18));
        JScrollPane scrollPane = new JScrollPane(conversation);
        roll = new JButton("Roll Dice");
        attack = new JButton("Attack Dragon");
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
        addMessage("Welcome to Level 5! Yes, good job, I hope you wind this last round, too");
        addMessage("Now you are going to fight with a mighty Dragon!");
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
            if (player.isAlive() && dragon.isAlive()) {
                playerAttack();
                if (dragon.isAlive()) {
                    dragonAttack();
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
        int initialDragonHitPoints = dragon.getHitPoints();
        player.attack(dragon);
        int dragonDamage = initialDragonHitPoints - dragon.getHitPoints();
        addMessage("Good job, you attacked the Dragon!");
        addMessage("Dragon's hit points: " + dragon.getHitPoints());
        if (!dragon.isAlive()) {
            addMessage("Congratulations! You defeated the Dragon!");
            attack.setEnabled(false);
        } else {
            addMessage("Dragon retaliates...");
            addMessage("Dragon attacks back with " + dragonDamage + " damage!");
        }
    }

    private void dragonAttack() {
        int initialPlayerHitPoints = player.getHitPoints();
        dragon.attackWithFire(player);
        int playerDamage = initialPlayerHitPoints - player.getHitPoints();
        addMessage("Oh no, the Dragon breathes fire!");
        addMessage("Your hit points: " + player.getHitPoints());
        if (!player.isAlive()) {
            addMessage("Oh no! You were defeated by the Dragon! You lost");
            attack.setEnabled(false);
        } else {
            addMessage("You suffered " + playerDamage + " damage from the fire!");
        }
    }

    public static void implement(Player player, Dragon dragon) {
        SwingUtilities.invokeLater(() -> new DefeatDragon(player, dragon));
    }
}

