package DataObjects;

import DomainObjects.PlayerDomainObject;

public class PlayerDataObject {
    
    public int id;
    public String username;
    public String password;

    public PlayerDataObject(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    //Copy Constructor
    public PlayerDataObject(PlayerDataObject player) {
        this.id = player.id;
        this.username = player.username;
        this.password = player.password;
    }

    public PlayerDataObject(PlayerDomainObject player) {
        this.id = player.GetId();
        this.username = player.GetUsername();
        this.password = player.GetPassword();
    }
}
