import java.util.ArrayList;

enum Options {
    X ("X"),
    O ("O"),
    BLANK ("_");

    private final String name;

    private Options(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        return name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }

}

public class Board {
    ArrayList<ArrayList<Options>> board;
    int size = 3;

    public Board() {
        board = new ArrayList<ArrayList<Options>>();

        for (int i = 0; i < size; i++) {
            board.add(new ArrayList<Options>());
            for (int j = 0; j < size; j++) {
                board.get(i).add(Options.BLANK);
            }
        }
    }

    public boolean put(int row, int col, Options option) {
        if (row < 0 || row > size) {
            return false;
        }
        else if (col < 0 || col > size) {
            return false;
        }
        else if (board.get(row).get(col) == Options.BLANK) {
            board.get(row).set(col, option);
            return true;
        }
        else {
            return false;
        }
    }


    public boolean finished() {
        // Check horizontals
        for (int i = 0; i < size; i++) {
            if (    board.get(i).get(0) == board.get(i).get(1) && board.get(i).get(1) == board.get(i).get(2)
                &&  board.get(i).get(0) != Options.BLANK) {
                return true;
            }
        }

        // Check verticals
        for (int i = 0; i < size; i++) {
            if (    board.get(0).get(i) == board.get(1).get(i) && board.get(1).get(i) == board.get(2).get(i)
                &&  board.get(0).get(i) != Options.BLANK) {
                return true;
            }
        }

        // Check diagonals
        if (    board.get(0).get(0) == board.get(1).get(1) && board.get(1).get(1) == board.get(2).get(2)
            &&  board.get(0).get(0) != Options.BLANK) {
            return true;
        }
        else if (   board.get(0).get(2) == board.get(1).get(1) && board.get(1).get(1) == board.get(2).get(0)
                 && board.get(0).get(2) != Options.BLANK) {
            return true;
        }

        return false;
    }


    @Override
    public String toString() {
        String result = "\t    1 2 3\n\t  +-------+\n";

        for (int i = 0; i < board.size(); i++) {
            var line = board.get(i);
            result += "\t" + (i+1) + " | ";

            for (var item: line) {
                result += item.toString() + " ";
            }
            result += "|\n";
        }

        result += "\t  +-------+\n";
        return result;
    }
}
