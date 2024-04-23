package DataAccess;

import java.util.ArrayList;
import java.util.List;
import DataObjects.PlayerDataObject;
import DataObjects.GameDataObject;
import DomainObjects.GameDomainObject;

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

        // Create a copy of games to return
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

    public static PlayerDataObject GetPlayerByGameId(int gameId) {
        PlayerDataObject playersByGame;

        // Retrieve the game as a domain object
        GameDataObject gameData = GameDataAccess.GetGameById(gameId);

        if (gameData != null) {
            GameDomainObject gameDomain = new GameDomainObject(gameData);

            // Use domain object getters
            int player1Id = gameDomain.GetPlayer1Id();
            int player2Id = gameDomain.GetPlayer2Id();

            PlayerDataObject player1 = getPlayerById(player1Id);
            PlayerDataObject player2 = getPlayerById(player2Id);

            if (player1 != null) {
                return playersByGame = player1;
            }
            if (player2 != null) {
                return playersByGame = player2;
            }
        }
        return playersByGame = null;
    }

    // trying to match the player id to the a game's player1Id or player2Id
    // that helps the PlayerModel.java
    // this is from the itemDataAccess.java file

    public static List<PlayerDataObject> getPlayersByGameId(int gameId) {
        List<PlayerDataObject> playersByGame = new ArrayList<>();

        // Retrieve the game as a domain object
        GameDataObject gameData = GameDataAccess.GetGameById(gameId);
        if (gameData != null) {
            GameDomainObject gameDomain = new GameDomainObject(gameData);

            // Use domain object getters
            int player1Id = gameDomain.GetPlayer1Id();
            int player2Id = gameDomain.GetPlayer2Id();

            PlayerDataObject player1 = getPlayerById(player1Id);
            PlayerDataObject player2 = getPlayerById(player2Id);

            if (player1 != null) {
                playersByGame.add(player1);
            }
            if (player2 != null) {
                playersByGame.add(player2);
            }
        }

        return playersByGame;
    }

    public static ArrayList<PlayerDataObject> GetPlayersByGameId(int gameId) {
        ArrayList<PlayerDataObject> playersByGame = new ArrayList<>();

        // Retrieve the game as a domain object
        GameDataObject gameData = GameDataAccess.GetGameById(gameId);
        if (gameData != null) {
            GameDomainObject gameDomain = new GameDomainObject(gameData);

            // Use domain object getters
            int player1Id = gameDomain.GetPlayer1Id();
            int player2Id = gameDomain.GetPlayer2Id();

            PlayerDataObject player1 = getPlayerById(player1Id);
            PlayerDataObject player2 = getPlayerById(player2Id);

            if (player1 != null) {
                playersByGame.add(player1);
            }
            if (player2 != null) {
                playersByGame.add(player2);
            }
        }

        return playersByGame;
    }

    public static PlayerDataObject getPlayerById(int id) {
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

    // save players, Need it ??????
    public static void Save(PlayerDataObject playerToSave) {
        for (PlayerDataObject player : players) {
            if (player.id == playerToSave.id) {
                player.username = playerToSave.username;
                player.password = playerToSave.password;
            }
        }
    }

}

