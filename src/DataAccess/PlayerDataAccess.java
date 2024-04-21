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
        players.add(new PlayerDataObject(0, "doomsmith", "smashriptear"));
        nextId = 1;
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

    // trying to match the player id to the a game's player1Id or player2Id
    // that helps the PlayerModel.java
    // this is from the itemDataAccess.java file
    public static ArrayList<PlayerDataObject> GetPlayersByGameId(int gameId) {
        ArrayList<GameDataObject> playersById = new ArrayList<PlayerDataObject>();

        for (PlayerDataObject player : players) {
            if (player.id == gameId.player1Id) {
                playersById.add(new PlayerDataObject(player));
            }
        }
        return playersById;
    }
    
    // for playermode.java's PlayerDomainObject GetFirstAvailableByGameId(int gameId) method
    public static PlayerDataObject GetFirstAvailableByGameId(int gameId) {
        ArrayList<GameDataObject> playersById = new ArrayList<PlayerDataObject>();

        for (PlayerDataObject player : players) {
            if (player.id == gameId.player1Id) {
                playersById.add(new PlayerDataObject(player));
            }
        }
        return playersById;
    }

    public static PlayerDataObject AddPlayer(PlayerDataObject newPlayer) {
        newPlayer.id = getNextId();
        players.add(newPlayer);
        return newPlayer;
    }

    //save players, Need it ??????
    public static void Save(PlayerDataObject playerToSave) {
        for( PlayersDataObject player : players) {
            if (player.id == playerToSave.id) {
                player.username = playerToSave.username;
                player.password = playerToSave.password;
            }
        }
    }

    

}
