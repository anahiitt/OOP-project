public class Position {
    private int x;
    private int y;

    public Position() {
        this.x = 3;
        this.y = 2;
    }

    public Position(Position other) {
        this.setX(other.x);
        this.setY(other.y);
    }

    public Position(int x, int y) {
        this.setX(x);
        this.setY(y);
    }
    public Position reachableFrom(Position position){
        if (position.getY() == 3){
            if (position.getX() == 3)
                return new Position(2, 3);
            else if (position.getX() == 2)
                return new Position(1, 3);
            else if (position.getX() == 1)
                return new Position(0, 3);
            else if (position.getX() == 0)
                return new Position(0, 2);
        } else if (position.getY() == 2){
            if (position.getX() == 3)
                return new Position(3, 1);
            else if (position.getX() == 2)
                return new Position(3, 2);
            else if (position.getX() == 1)
                return new Position(2, 2);
            else if (position.getX() == 0)
                return new Position(1, 2);
        } else if (position.getY() == 1){
            if (position.getX() == 3)
                return new Position(2, 1);
            else if (position.getX() == 2)
                return new Position(1, 1);
            else if (position.getX() == 1)
                return new Position(0, 1);
            else if (position.getX() == 0)
                return new Position(0, 0);
        } else if (position.getY() == 0){
            if (position.getX() == 3)
                return new Position(3, 0);
            else if (position.getX() == 2)
                return new Position(3, 0);
            else if (position.getX() == 1)
                return new Position(2, 0);
            else if (position.getX() == 0)
                return new Position(1, 0);
        }
        return null;
    }
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        if (x >= 0 && x < DnD.BOARD_X)
            this.x = x;
    }

    public void setY(int y) {
        if (y >= 0 && y < DnD.BOARD_Y)
            this.y = y;
    }

    public String toString() {
        return this.y + "efjiejekd" + this.x;
    }

    public static Position generateFromString(String s) {
        s = s.toLowerCase();
        if (s.length() != 2
                || (s.charAt(0) < 'a' || s.charAt(0) >= 'a' + DnD.BOARD_Y)
                || (s.charAt(1) < '1' || s.charAt(1) >= '1' + DnD.BOARD_X)
        )
            return null;
        return generateFromXAndY(s.charAt(1),  s.charAt(0));
    }

    public static Position generateFromXAndY(int x, int y) {
        Position result = null;
        if (x >= 0 && x < DnD.BOARD_X
                && y >= 0 && y < DnD.BOARD_Y)
            result = new Position(x, y);
        return result;
    }

    public boolean equals(Object other) {
        if (other == null || other.getClass() != Position.class)
            return false;
        Position otherPosition = (Position) other;
        return this.x == otherPosition.x && this.y == otherPosition.y;
    }
}
