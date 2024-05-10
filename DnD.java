public class DnD implements Cloneable{
    public static final int BOARD_X = 4;
    public static final int BOARD_Y = 4;
    public enum GameStatus {ONGOING, PLAYER_WON, PLAYER_LOST}
    private Monster[][] board;
    private Player player;
    private Monster monster;
    private GameStatus gameStatus;
    public DnD(){
        this.board = new Monster[BOARD_X][BOARD_Y];
        setMonsters();
    }

    public Monster[][] getBoard() {
        Monster[][] boardCopy = new Monster[BOARD_X][BOARD_Y];
        for (int i = 0; i < BOARD_X; i++)
            for (int j = 0; j < BOARD_Y; j++)
                if (this.board[i][j] != null)
                    boardCopy[i][j] = new Monster(this.board[i][j]);
        return boardCopy;
    }
    public GameStatus getGameStatus(){
        if(player.getHitPoints() == 0){
            return GameStatus.PLAYER_LOST;
        } else if (monster.getHitPoints() == 0){
            return GameStatus.PLAYER_WON;
        }
        return GameStatus.ONGOING;
    }
    public boolean isGameOver() {
        return this.gameStatus != GameStatus.ONGOING;
    }
    public boolean isEmpty(Position p) {
        return this.board[p.getX()][p.getY()] == null;
    }

    public boolean performMove(Move m) {
        Position o = m.getOrigin();
        Position d = m.getDestination();
        Position reachable = o.reachableFrom(o);
        if(reachable.equals(d)){
            return true;
        }
        this.board[d.getX()][d.getY()] = this.board[o.getX()][o.getY()];
        this.board[o.getX()][o.getY()] = null;
        player.setPosition(d.getX(), d.getY());
        updateGameStatus();
        return true;
    }
    public boolean performMove1(Move m) {
        Position origin = m.getOrigin();
        Position destination = m.getDestination();

        Position reachablePosition = origin.reachableFrom(origin);
        if (reachablePosition != null && reachablePosition.equals(destination)) {
            player.setPosition(destination.getX(), destination.getY());
            updateGameStatus();
            return true;
        }
        return false;
    }

    private void updateGameStatus() {
        if(player.getHitPoints() != 0) {
            this.gameStatus = GameStatus.ONGOING;
                return;
        } else {
            this.gameStatus = GameStatus.PLAYER_LOST;
                return;
        }
    }

    public void setMonsters(){
        this.board[0][0] = new Beholder(0, 0);
        this.board[1][1] = new Giants(1, 1);
        this.board[2][0] = new MindFlayers(2, 0);
        this.board[2][2] = new Demon(2, 2);
        this.board[3][1] = new Dragon(3, 1);
    }

}
