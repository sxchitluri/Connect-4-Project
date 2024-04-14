package restService.response;

public class PlayerResponse {
    
    private final boolean isValid;
    private final String errorMessage;
    private final int playerId;
    private final String username;

    public PlayerResponse(int playerId, String username) {
        this.playerId = playerId;
        this.username = username;
        this.isValid = true;
        this.errorMessage = null;
    }

    public PlayerResponse(String errorMessage) {
        this.playerId = -1;
        this.username = "";
        this.isValid = false;
        this.errorMessage = errorMessage;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getUsername() {
        return username;
    }

     public boolean GetIsValid() {
        return this.isValid;
    }

    public String GetErrorMessage() {
        return this.errorMessage;
    }

}
