import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Map extends JFrame {
    private DnD game;
    private boolean playerCreated = false;
    private Player player;
    private Board[][] buttonReferences;
    private ArrayList<Position> gatheredClicks;

    private char[][] board;
    private int clickCounter = 0;

    public Map() {
        game = null;
        try {
            game = new DnD();
        } catch (Exception e) {
            //does not reach here hopefully
        }
        buttonReferences = new Board[DnD.BOARD_X][DnD.BOARD_Y];
        gatheredClicks = new ArrayList<>();
        this.setSize(800, 800);
        this.setTitle("Dungeons and Dragons");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        JPanel board = new JPanel();
        board.setLayout(new GridLayout(DnD.BOARD_X, DnD.BOARD_X));
        board.setSize(800, 800);


        for (int i = 0; i < DnD.BOARD_X; i++) {
            for (int j = 0; j < DnD.BOARD_Y; j++) {
                Board sq = new Board(
                        (i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1),
                        j * 200, i * 200
                );
                sq.setPreferredSize(new Dimension(200, 200));
                sq.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Board source = (Board) e.getSource();
                        int[] boardCoords = source.getSquareCoords();

                        int[] gridCoordinates = new int[]{boardCoords[1] / 200, boardCoords[0] / 200};

                        boardClicked(gridCoordinates);
                    }
                });

                buttonReferences[i][j] = sq;
                board.add(sq);
            }
        }

        buttonReferences[3][1].setMonster(new Beholder(3, 1));
        buttonReferences[2][2].setMonster(new Giants(2, 2));
        buttonReferences[1][0].setMonster(new MindFlayers(1, 0));
        buttonReferences[0][2].setMonster(new Dragon(0, 2));
        buttonReferences[1][3].setMonster(new Demon(1, 3));
        buttonReferences[0][3].setVictoryIcon();
        buttonReferences[3][3].setStart();

        this.add(board);
        this.setVisible(true);
    }
    private void boardClicked(int[] coords) {
        if (!playerCreated && coords[0] == 3 && coords[1] == 3) {
            if (player == null) {
                player = new Player();
            }
            BuildYourCharacter.implement(this);
            Position playerPosition = player.getPosition();
            buttonReferences[playerPosition.getX()][playerPosition.getY()].setHighlight(true);
            playerCreated = true;
            setVisible(true);
        } else if (playerCreated) {
            Position clickedPosition = Position.generateFromXAndY(coords[0], coords[1]);
            Position playerPosition = player.getPosition();
            if (gatheredClicks.isEmpty()) {
                if (playerPosition.equals(clickedPosition)) {
                    buttonReferences[playerPosition.getX()][playerPosition.getY()].setHighlight(false);
                    buttonReferences[playerPosition.getX()][playerPosition.getY()].setHighlight(true);
                    Position reachablePosition = playerPosition.reachableFrom(playerPosition);
                    if (reachablePosition != null) {
                        buttonReferences[reachablePosition.getX()][reachablePosition.getY()].setHighlight(true);
                        gatheredClicks.add(reachablePosition);
                    }
                }
            } else {
                if (gatheredClicks.contains(clickedPosition)) {
                    if (player.getLevel() == 1) {
                        DefeatBeholder.implement(player, new Beholder(3, 1));
                        player.levelUp();
                        clearHighlights();
                        buttonReferences[3][0].setHighlight(true);
                        gatheredClicks.clear();
                    } else if (player.getLevel() == 2){
                        DefeatGiants.implement(player, new Giants(2, 2));
                        player.levelUp();
                        clearHighlights();
                        buttonReferences[3][2].setHighlight(true);
                        gatheredClicks.clear();
                    } else if (player.getLevel() == 3) {
                        DefeatDemon.implement(player, new Demon(3, 1));
                        player.levelUp();
                        clearHighlights();
                        buttonReferences[2][1].setHighlight(true);
                        gatheredClicks.clear();
                    } else if (player.getLevel() == 4) {
                        DefeatMindFlayer.implement(player, new MindFlayers(0, 1));
                        player.levelUp();
                        clearHighlights();
                        buttonReferences[0][0].setHighlight(true);
                        gatheredClicks.clear();
                    } else if (player.getLevel() == 5) {
                        DefeatDragon.implement(player, new Dragon(2, 0));
                        player.levelUp();
                        clearHighlights();
                        buttonReferences[3][0].setHighlight(true);
                        gatheredClicks.clear();
                    }  else if (player.getLevel() == 6) {
                        Win.implement();
                        player.levelUp();
                        clearHighlights();
                        gatheredClicks.clear();
                    }
                } else {
                    Position lastClickedPosition = gatheredClicks.get(gatheredClicks.size() - 1);
                    Position reachablePosition = clickedPosition.reachableFrom(lastClickedPosition);
                    if (reachablePosition != null && reachablePosition.equals(clickedPosition)) {
                        game.performMove(new Move(lastClickedPosition, clickedPosition));
                        buttonReferences[lastClickedPosition.getX()][lastClickedPosition.getY()].setHighlight(false);
                        buttonReferences[clickedPosition.getX()][clickedPosition.getY()].setHighlight(false);
                        gatheredClicks.clear();
                    }
                }
            }
        }
    }
    private void clearHighlights() {
        for (int i = 0; i < DnD.BOARD_X; i++) {
            for (int j = 0; j < DnD.BOARD_Y; j++) {
                buttonReferences[i][j].setHighlight(false);
            }
        }
    }

    public void setPlayer(Player player){
        this.player = player;
    }
}