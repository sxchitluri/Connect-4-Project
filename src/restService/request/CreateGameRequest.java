package restService.request;

// story 3's reqeust definition
public class CreateGameRequest {
    // inputs from controller
    private final int player1Id;
    private final int player2Id;
    private final int gameTypeId;

    // playgame request when a player wants to make a move
    public CreateGameRequest(int player1Id, int player2Id, int gameTypeId) {
        this.player1Id = player1Id;
        this.player2Id = player2Id;
        this.gameTypeId = gameTypeId;
    }

    public int GetPlayer1Id() {
        return this.player1Id;
    }

    public int GetPlayer2Id() {
        return this.player2Id;
    }

    public int GetGameTypeId() {
        return this.gameTypeId;
    }
}
