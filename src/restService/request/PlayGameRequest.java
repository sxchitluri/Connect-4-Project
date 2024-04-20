package restService.request;

import DataAccess.BoardDataAccess;
import DataObjects.BoardDataObject;

//story 4 play game request
public class PlayGameRequest {
    //inputs from controller
    private final int gameId;
    private final int playerId;
    private final int column;

    
    // playgame request when a player wants to make a move
    public PlayGameRequest(int gameId, int playerId, int column) {
        this.gameId = gameId;
        this.playerId = playerId;
        this.column = column;
    }

    public int GetGameId() {
        return this.gameId;
    }

    public int GetPlayerId() {
        return this.playerId;
    }
    
    public int GetColumn() {
        return this.column;
    }

}


/*
 *     public PlayGameRequest(int gameId, int gameTypeId, int player1Id, int player2Id, String status, int currentTurnPlayer, int winnerId, BoardDataObject board) {
        this.gameId = gameId;
        this.gameTypeId = gameTypeId; 
        this.player1Id = player1Id;
        this.player2Id = player2Id;
        this.currentTurnPlayer = player2Id; // Always Player 2's turn initially
        this.status ="Playing"; // Status is "Playing" when game starts
        this.winnerId = 0; // Default winner is 0 indicating no winner yet
        this.board = new BoardDataObject(board); //create new instance of board
    }

 */
