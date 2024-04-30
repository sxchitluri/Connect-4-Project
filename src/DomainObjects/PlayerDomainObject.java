package DomainObjects;

import java.util.ArrayList;
import DataObjects.PlayerDataObject;
import Models.GameTypeModel;
import restService.request.GetPlayerDetailsRequest;
import restService.request.RegisterPlayerRequest;
import Models.BoardModel;

public class PlayerDomainObject {

    private int id;
    private String username;
    private String password;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesLost;
    private int gameTypeId;
    private GameTypeDomainObject gameType;
    private BoardDomainObject board;

    public PlayerDomainObject(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public PlayerDomainObject(PlayerDataObject player) {
        this.id = player.id;
        this.username = player.username;
        this.password = player.password;
    }

    // made to appease for player controller register player method
    public PlayerDomainObject(RegisterPlayerRequest request) {
        this.username = request.getUsername();
        this.password = request.getPassword();
    }

    // made to appease for player controller get player details method
    public PlayerDomainObject(GetPlayerDetailsRequest request) {
        this.id = request.getPlayerId();
    }

    public static ArrayList<PlayerDomainObject> MapList(ArrayList<PlayerDataObject> playerdata) {
        ArrayList<PlayerDomainObject> playerDomain = new ArrayList<PlayerDomainObject>();
        for (PlayerDataObject player : playerdata) {
            playerDomain.add(new PlayerDomainObject(player));
        }
        return playerDomain;
    }

    public int GetId() {
        return this.id;
    }

    public String GetUsername() {
        return this.username;
    }

    public String GetPassword() {
        return this.password;
    }

    public int GetGamesPlayed() {
        return this.gamesPlayed;
    }

    public int GetGamesWon() {
        return this.gamesWon;
    }

    public int GetGamesLost() {
        return this.gamesLost;
    }

    public BoardDomainObject GetBoard() {
        if (this.board == null) {
            this.board = BoardModel.GetBoardById(board.GetId());
            if (this.board == null) {
                throw new IllegalStateException(
                        "Board data for Board " + this.board + " could not be loaded.");
            }
        }
        return this.board;
    }

    public GameTypeDomainObject GetGameType() {
        // Lazy Load the ItemType
        if (this.gameType == null) {
            this.gameType = GameTypeModel.GetGameTypeById(gameType.GetId());
            if (this.gameType == null) {
                throw new IllegalStateException(
                        "GameType data for gameType ID " + this.gameTypeId + " could not be loaded.");
            }
        }
        return this.gameType;
    }

}
