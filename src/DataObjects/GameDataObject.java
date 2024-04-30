package DataObjects;

import DomainObjects.BoardDomainObject;
import DomainObjects.GameDomainObject;

public class GameDataObject {

    public int id;
    public int player1Id;
    public int player2Id;
    public String status;
    public int currentTurnPlayer;
    public int winnerId;
    public BoardDomainObject board;

    public GameDataObject(int id, int player1Id, int player2Id, String status, int currentTurnPlayer, int winnerId) {
        this.id = id;
        this.player1Id = player1Id;
        this.player2Id = player2Id;
        this.status = status;
        this.currentTurnPlayer = currentTurnPlayer;
        this.winnerId = winnerId;
    }

    public GameDataObject(int id, int player1Id, int player2Id, String status, int currentTurnPlayer, int winnerId,
            BoardDomainObject board) {
        this.id = id;
        this.player1Id = player1Id;
        this.player2Id = player2Id;
        this.status = status;
        this.currentTurnPlayer = currentTurnPlayer;
        this.winnerId = winnerId;
        this.board = board;
    }

    // Copy Constructor
    public GameDataObject(GameDataObject game) {
        this.id = game.id;
        this.player1Id = game.player1Id;
        this.player2Id = game.player2Id;
        this.status = game.status;
        this.currentTurnPlayer = game.currentTurnPlayer;
        this.winnerId = game.winnerId;
        this.board = game.board;
    }

    public GameDataObject(GameDomainObject game) {
        this.id = game.GetGameId();
        this.player1Id = game.GetPlayer1Id();
        this.player2Id = game.GetPlayer2Id();
        this.status = game.GetStatus();
        this.currentTurnPlayer = game.GetCurrentTurnPlayer();
        this.winnerId = game.GetWinnerId();
        this.board = game.GetBoard();
    }
}
