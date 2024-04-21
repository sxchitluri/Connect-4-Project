package DomainObjects;
import java.util.ArrayList;
import DataObjects.BoardDataObject;
import Models.BoardModel;
import Models.GameModel;

public class BoardDomainObject {

    private int id;
    private int gameId;
    private String occupancy;
    private GameDomainObject game;

    public BoardDomainObject (int id, int gameId, String occupancy) {
        this.id = id;
        this.gameId = gameId;
        this.occupancy = occupancy;
    }

    public BoardDomainObject(BoardDataObject board) {
        this.id = board.id;
        this.gameId = board.gameId;
        this.occupancy = board.occupancy;
    }
    
    public static ArrayList<BoardDomainObject> MapList(ArrayList<BoardDataObject> boarddata) {
        ArrayList<BoardDomainObject> boardDomain = new ArrayList<BoardDomainObject>();
        for (BoardDataObject board : boarddata) {
            boardDomain.add(new BoardDomainObject(board));
        }
        return boardDomain;
    }
    
    public int GetId() {
        return this.id;
    }

    public int GetGameId() {
        return this.gameId;
    }

    public String GetOccupancy() {
        return this.occupancy;
    }

    public GameDomainObject GetGame() {
        if (this.game == null) {
            this.game = GameModel.GetGameById(gameId);
        }
        return this.game;
    }

    public void SetGame(int gameId) {
        this.gameId = gameId;
        BoardModel.Save(this);
    }

    public boolean checkForWinner() {
        final int COLUMNS = 7;
        final int ROWS = 6;
        final int WIN_COUNT = 4;  // Number of consecutive 'tokens' needed to win
        // Check horizontal, vertical, and diagonal
        return (checkLine(WIN_COUNT, COLUMNS, 1, ROWS, COLUMNS) || // Horizontal
                checkLine(WIN_COUNT, 1, COLUMNS, ROWS, COLUMNS) || // Vertical
                checkLine(WIN_COUNT, COLUMNS + 1, 1, ROWS, COLUMNS) || // Diagonal from left-bottom to right-top
                checkLine(WIN_COUNT, COLUMNS - 1, 1, ROWS, COLUMNS)); // Diagonal from left-top to right-bottom
    }

    private boolean checkLine(int count, int step, int stride, int rows, int columns) {
        int maxIndex = this.occupancy.length();
        for (int start = 0; start < maxIndex; start++) {
            char currentChar = this.occupancy.charAt(start);
            if (currentChar == ' ') continue;  // Skip empty slots

            // Calculate the last index for the current check direction within bounds
            int endIndex = start + (count - 1) * stride;
            if (endIndex >= maxIndex) continue;  // Ensure the last index is within the string bounds

            boolean validLine = true;
            for (int offset = 1; offset < count; offset++) {
                int currentIndex = start + offset * stride;
                if (currentIndex % columns >= columns || currentIndex / columns >= rows || this.occupancy.charAt(currentIndex) != currentChar) {
                    validLine = false;
                    break;
                }
            }

            if (validLine) return true;
        }
        return false;
    }

    public boolean isValidColumn(int column) {
        if (column < 0 || column >= 7) {
            return false; // Column index out of bounds
        }
        // Check if the top slot of the column is empty
        return occupancy.charAt(column) == ' ';
    }

    public void updateBoard(int column, int playerId) {
        // Determine player token based on playerId, could be extended to more players or different token rules
        char playerToken;
        if (playerId == 1) {
            playerToken = 'R';  // Assume player 1 is 'Red'
        } else if (playerId == 2) {
            playerToken = 'G';  // Assume player 2 is 'Green'
        } else {
            throw new IllegalArgumentException("Unknown player ID");
        }
    
        if (column < 0 || column >= 7) {
            throw new IllegalArgumentException("Column index out of bounds");
        }
    
        // Calculate the base index from the bottom of the column
        int baseIndex = (6 - 1) * 7 + column;  // Start from the bottom of the column
    
        // Traverse upwards in the column to find the first empty spot
        for (int i = 0; i < 6; i++) {  // There are 6 rows
            int index = baseIndex - i * 7;
            if (occupancy.charAt(index) == ' ') {  // Check if the spot is empty
                // Update the board string with the player's token
                occupancy = occupancy.substring(0, index) + playerToken + occupancy.substring(index + 1);
                return;
            }
        }
    }
}
