package restService.request;

// story 6's request definition
public class GetPlayerDetailsRequest {

    private final int playerId;

    public GetPlayerDetailsRequest(int playerId) {
        this.playerId = playerId;
    }

    public int getPlayerId() {
        return this.playerId;
    }

}
