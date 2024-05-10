import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefeatGiants extends JFrame implements ActionListener {
    private JTextArea conversation;
    private JButton roll;
    private JButton attack;
    private JButton close;

    private Player player;
    private Giants giant;
    private boolean diceRolled = false;
    private boolean playerTurn;

    public DefeatGiants(Player player, Giants giant) {
        this.player = player;
        this.giant = giant;

        setTitle("Defeat the Giant");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        conversation = new JTextArea();
        conversation.setEditable(false);
        conversation.setFont(new Font("Arial", Font.PLAIN, 18));
        JScrollPane scrollPane = new JScrollPane(conversation);
        roll = new JButton("Roll Dice");
        attack = new JButton("Attack Giant");
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
        addMessage("Welcome to Level 2! Congratulations on your first win once again");
        addMessage("Now you are going to fight with a formidable Giant!");
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
            if (player.isAlive() && giant.isAlive()) {
                playerAttack();
                if (giant.isAlive()) {
                    giantAttack();
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
        int initialGiantHitPoints = giant.getHitPoints();
        player.attack(giant);
        int giantDamage = initialGiantHitPoints - giant.getHitPoints();
        addMessage("Good job, you attacked the Giant!");
        addMessage("Giant's hit points: " + giant.getHitPoints());
        if (!giant.isAlive()) {
            addMessage("Congratulations! You defeated the Giant!");
            attack.setEnabled(false);
        } else {
            addMessage("Giant retaliates...");
            addMessage("Giant attacks back with " + giantDamage + " damage!");
        }
    }

    private void giantAttack() {
        int initialPlayerHitPoints = player.getHitPoints();
        giant.throwRock(player);
        int playerDamage = initialPlayerHitPoints - player.getHitPoints();
        addMessage("Oh no, the Giant attacks! Get ready...");
        addMessage("Your hit points: " + player.getHitPoints());
        if (!player.isAlive()) {
            addMessage("Oh no! You were defeated by the Giant! You lost");
            attack.setEnabled(false);
        } else {
            addMessage("You suffered " + playerDamage + " damage!");
        }
    }

    public static void implement(Player player, Giants giant) {
        SwingUtilities.invokeLater(() -> new DefeatGiants(player, giant));
    }
}

