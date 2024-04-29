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

    public BoardDomainObject(int id, int gameId, String occupancy) {
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
        final int WIN_COUNT = 4; // Number of consecutive 'tokens' needed to win
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
            if (currentChar == ' ')
                continue; // Skip empty slots

            // Calculate the last index for the current check direction within bounds
            int endIndex = start + (count - 1) * stride;
            if (endIndex >= maxIndex)
                continue; // Ensure the last index is within the string bounds

            boolean validLine = true;
            for (int offset = 1; offset < count; offset++) {
                int currentIndex = start + offset * stride;
                if (currentIndex % columns >= columns || currentIndex / columns >= rows
                        || this.occupancy.charAt(currentIndex) != currentChar) {
                    validLine = false;
                    break;
                }
            }

            if (validLine)
                return true;
        }
        return false;
    }

    /*public boolean isValidColumn(int column) {
        if (column < 0 || column >= 6) {
            return false; // Column index out of bounds
        }

        else {
            return true;
        }
    }*/

    public boolean isValidColumn(int column) {
        return column >= 0 && column < 7; // Columns should be 0 through 6 for a 7-column grid
    }

    // Check if the top slot of the column is empty
    /*public boolean hasSpaceAvailable(int column) {
        return occupancy.charAt(column) == ' ';
    }*/

    public boolean hasSpaceAvailable(int column) {
        int topRow = 0;  // Topmost row for a given column in a vertical game board
        int index = topRow * 7 + column;
        return occupancy.charAt(index) == ' '; // Ensure the top of the column is free
    }

    public String updateBoard(int column, int playerId) {
        // Determine the player's token based on the playerId
        char playerToken;
        if (playerId == 1) {
            playerToken = 'R'; // Assume player 1 is 'Red'
        } else if (playerId == 2) {
            playerToken = 'G'; // Assume player 2 is 'Green'
        } else {
            throw new IllegalArgumentException("Unknown player ID: " + playerId);
        }

        // Start from the bottom of the column and find the first empty spot
        for (int row = 5; row >= 0; row--) { // Rows are indexed from 0 to 5, bottom row is 5
            int index = row * 7 + column; // Calculate the index in the occupancy string
            if (occupancy.charAt(index) == ' ') { // Check if the spot is empty
                // Update the board string with the player's token
                occupancy = occupancy.substring(0, index) + playerToken + occupancy.substring(index + 1);
                return occupancy; // Exit after placing the token
            }
        }

        // If no empty spot is found, throw an exception
        throw new IllegalStateException("No available spaces in column: " + column);
    }

    @Override
public String toString() {
    String state = this.occupancy;
    return state;
}
}
