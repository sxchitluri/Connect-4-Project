package restService.response;

import DomainObjects.BoardDomainObject;


// story 2's AND story 4's response definition 
public class GameResponse {

    private final boolean isValid;
    private final String errorMessage;
    private final int gameId;
    private final int gameTypeId;
    private final int player1Id;
    private final int player2Id;
    private final String status;
    private final int currentTurnPlayer;
    private final int winnerId;
    private final String board; 

    // this method is if request inputs are valid (which the game model tests)
    public GameResponse(int gameId, int gameTypeId, int player1Id, int player2Id, String status, int currentTurnPlayer,
            int winnerId, String board) {
        this.isValid = true;
        this.errorMessage = null;
        this.gameId = gameId;
        this.gameTypeId = gameTypeId;
        this.player1Id = player1Id;
        this.player2Id = player2Id;
        this.status = status;
        this.currentTurnPlayer = currentTurnPlayer;
        this.winnerId = winnerId;
        this.board = board;
    }

    public GameResponse(int gameId, int player1Id, int player2Id, String status, int currentTurnPlayer,
            int winnerId, BoardDomainObject board) {
        this.isValid = true;
        this.errorMessage = null;
        this.gameId = gameId;
        this.gameTypeId = 0;
        this.player1Id = player1Id;
        this.player2Id = player2Id;
        this.status = status;
        this.currentTurnPlayer = currentTurnPlayer;
        this.winnerId = winnerId;
        this.board = board.GetOccupancy();
    }

    // this method is if request inputs are not valid (which the game model tests)
    public GameResponse(String errorMessage) {
        this.isValid = false;
        this.errorMessage = errorMessage;
        this.gameId = -1;
        this.gameTypeId = -1;
        this.player1Id = -1;
        this.player2Id = -1;
        this.status = "";
        this.currentTurnPlayer = -1;
        this.winnerId = -1;
        this.board = "";
    }

    // GET methods

    public int GetGameId() {
        return this.gameId;
    }

    public int GetGameTypeId() {
        return this.gameTypeId;
    }

    public int GetPlayer1Id() {
        return this.player1Id;
    }

    public int GetPlayer2Id() {
        return this.player2Id;
    }

    public String GetStatus() {
        return this.status;
    }

    public int GetCurrentTurnPlayer() {
        return this.currentTurnPlayer;
    }

    public int GetWinnerId() {
        return this.winnerId;
    }

    public String GetBoard() {
        return this.board;
    }

    public boolean GetIsValid() {
        return this.isValid;
    }

    public String GetErrorMessage() {
        return this.errorMessage;
    }
}
