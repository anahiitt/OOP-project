import javax.swing.*;
import java.awt.*;

public class Board extends JButton {
    private static Color road = new Color(213, 247, 168);
    private int boardX;
    private Monster monster;
    private int boardY;
    private Color originalColor;
    private Image giantImg = new ImageIcon(getClass().getClassLoader().getResource("icons/giants.png")).getImage();
    private Image demonImg = new ImageIcon(getClass().getClassLoader().getResource("icons/demon.png")).getImage();
    private Image dragonImg = new ImageIcon(getClass().getClassLoader().getResource("icons/dragon.png")).getImage();
    private Image mindFlayerImg = new ImageIcon(getClass().getClassLoader().getResource("icons/mindflayer.png")).getImage();
    private Image beholderImg = new ImageIcon(getClass().getClassLoader().getResource("icons/beholder.png")).getImage();
    private Image victoryCup = new ImageIcon(getClass().getClassLoader().getResource("icons/victory_cup.png")).getImage();
    private Image start = new ImageIcon(getClass().getClassLoader().getResource("icons/start.png")).getImage();



    public Board(boolean isWon, int boardX, int boardY) {
        super();
        originalColor = road;
        this.setBackground(originalColor);
        this.boardX = boardX;
        this.boardY = boardY;
    }

    public int getX(){
        return this.boardX;
    }

    public int getY(){
        return this.boardY;
    }

    public void setX(int newX){
        this.boardX = newX;
    }

    public void setY(int newY){
        this.boardY = newY;
    }

    public int[] getSquareCoords() {
        return new int[]{boardX,boardY};
    }

    public void setMonster() {
        this.setIcon(null);
    }
    public void setMonster(Monster monster) {
        this.monster = monster;
        if (monster != null) {
            switch (monster.toString()) {
                case "D":
                    this.setIcon(adjustedImage(dragonImg));
                    break;
                case "B":
                    this.setIcon(adjustedImage(beholderImg));
                    break;
                case "G":
                    this.setIcon(adjustedImage(giantImg));
                    break;
                case "M":
                    this.setIcon(adjustedImage(mindFlayerImg));
                    break;
                case "N":
                    this.setIcon(adjustedImage(demonImg));
                    break;
            }
        } else {
            this.setIcon(null);
        }
    }
    public void setVictoryIcon(){
        this.setIcon(adjustedImage(victoryCup));
    }
    public void setStart(){
        this.setIcon(adjustedImage(start));
    }

    public void setHighlight(boolean highlighted) {
        if (highlighted)
            this.setBackground(Color.BLUE);
        else
            this.setBackground(originalColor);
    }

    private ImageIcon adjustedImage(Image img){
        Image adjustedImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(adjustedImg);
        return icon;
    }
}
