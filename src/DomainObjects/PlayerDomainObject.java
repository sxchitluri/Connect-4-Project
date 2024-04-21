package DomainObjects;

import java.util.ArrayList;

import DataObjects.PlayerDataObject;
import Models.PlayerModel;
import restService.request.RegisterPlayerRequest;
import Models.GameTypeModel;
import Models.BoardModel;

public class PlayerDomainObject {

    private int id;
    private String username;
    private String password;

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

    // made to appease for player controller
    public PlayerDomainObject(RegisterPlayerRequest request) {
        // this.id = request.id;
        this.username = request.getUsername();
        this.password = request.getPassword();
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

    public BoardDomainObject GetBoard() {
        // Lazy Load the Rack
        if (this.board == null) {
            this.board = BoardModel.GetBoardById(id);
        }
        return this.board;
    }

    public GameTypeDomainObject GetGameType() {
        // Lazy Load the ItemType
        if (this.gameType == null) {
            this.gameType = GameTypeModel.GetGameTypeById(gameType); // idk tried to fix this, made change to gametypemodel and gametypedataaccess
        }
        return this.gameType;
    }

    // public void SetStatus(String status) {
    // this.status = status;
    // PlayerModel.Save(this);
    // }

}
