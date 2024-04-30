package restService.request;


//story 2 request definition
public class GetGameDetailsRequest {

    private final int gameId;

    // getgamedetails request that takes in only the gameId
    public GetGameDetailsRequest (int gameId) {
        this.gameId = gameId;
    }

    public int GetGameId() {
        return this.gameId;
    }

}
