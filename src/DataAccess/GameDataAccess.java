package DataAccess;

import java.util.ArrayList;
import DataObjects.GameDataObject;

public class GameDataAccess {

    public static ArrayList<GameDataObject> games = new ArrayList<GameDataObject>();
    private static int nextId = 0;

    public GameDataAccess() {
        initialize();
    }

    // default values for game
    private void initialize() {
        games.add(new GameDataObject(0, 0, 1, "Playing", 1, -1));
        games.add(new GameDataObject(251, 1, 2, "Playing", 1, -1));
        nextId = 1; // does this need to be 1?
    }

    public static int getNextId() {
        int thisId = nextId;
        nextId++;
        return thisId;
    }

    public static ArrayList<GameDataObject> GetAllGames() {
        ArrayList<GameDataObject> gamesList = new ArrayList<GameDataObject>();

        // Create a copy of games to return
        for (GameDataObject game : games) {
            gamesList.add(new GameDataObject(game));
        }
        return gamesList;
    }

    public static GameDataObject GetGameById(int id) {
        for (GameDataObject game : games) {
            if (game.id == id) {
                return new GameDataObject(game);
            }
        }
        return null;
    }

    public static GameDataObject AddGame(GameDataObject newGame) {
        // newGame.id = getNextId();
        games.add(newGame);
        return newGame;
    }

    // save the game
    public static void Save(GameDataObject gameToSave) {
        for (GameDataObject game : games) {
            if (game.id == gameToSave.id) {
                game.player1Id = gameToSave.player1Id;
                game.player2Id = gameToSave.player2Id;
                game.currentTurnPlayer = gameToSave.currentTurnPlayer;
                game.winnerId = gameToSave.winnerId;
                game.status = gameToSave.status;
            }
        }
    }
}
