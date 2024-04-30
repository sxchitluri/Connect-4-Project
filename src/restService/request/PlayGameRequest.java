package restService.request;


//story 4 play game request
public class PlayGameRequest {
    // inputs from controller
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
