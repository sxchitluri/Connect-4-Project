package DataAccess;

import java.util.ArrayList;
import DataObjects.PlayerDataObject;

public class PlayerDataAccess {
    
    private static ArrayList<PlayerDataObject> players = new ArrayList<PlayerDataObject>();
    private static int nextId = 0;

    public PlayerDataAccess() {
        initialize();
    }

    private void initialize() {
        players.add(new PlayerDataObject(0, "rflorin"));
        players.add(new PlayerDataObject(1, "kfindley"));
        nextId = 2;
    }

    private static int getNextId() {
        int thisId = nextId;
        nextId++;
        return thisId;
    }

    public static ArrayList<PlayerDataObject> GetAllPlayers() {
        ArrayList<PlayerDataObject> playersList = new ArrayList<PlayerDataObject>();

        //Create a copy of games to return
        for (PlayerDataObject player : players) {
            playersList.add(new PlayerDataObject(player));
        }
        return playersList;
    }

    public static PlayerDataObject GetPlayerById(int id) {
        for (PlayerDataObject player : players) {
            if (player.id == id) {
                return new PlayerDataObject(player);
            }
        }
        return null;
    }

    public static PlayerDataObject AddPlayer(PlayerDataObject newPlayer) {
        newPlayer.id = getNextId();
        players.add(newPlayer);
        return newPlayer;
    }

}
