package restService.response;

// story 1's reponse definiton 
public class PlayerResponse {
    
    private final boolean isValid;
    private final String errorMessage;
    private final int playerId;
    private final String username;
    private final int gamesPlayed;
    private final int gamesWon;
    private final int gamesLost;

    public PlayerResponse(boolean isValid, String errorMessage, int playerId, String username, int gamesPlayed, int gamesWon, int gamesLost) {
        this.isValid = true;
        this.errorMessage = null;
        this.playerId = playerId;
        this.username = username;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
    }

    public PlayerResponse(String errorMessage) {
        this.isValid = false;
        this.errorMessage = errorMessage;
        this.playerId = -1;
        this.username = "";
        this.gamesPlayed = -1;
        this.gamesWon = -1;
        this.gamesLost = -1;
    }

    //GET methods

    public boolean GetIsValid() {
        return this.isValid;
    }

    public String GetErrorMessage() {
        return this.errorMessage;
    }

    public int getPlayerId() {
        return this.playerId;
    }

    public String getUsername() {
        return this.username;
    }

    public int getGamesPlayed() {
        return this.gamesPlayed;
    }

    public int getGamesWon() {
        return this.gamesWon;
    }

    public int getGamesLost() {
        return this.gamesLost;
    }
     

}
