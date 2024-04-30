package DataAccess;

import java.util.ArrayList;
import DataObjects.GameDataObject;

public class GameDataAccess {

    public static ArrayList<GameDataObject> games = new ArrayList<GameDataObject>();
    private static int nextId = 0;


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
                System.out.println("GameDataAccess: Game found with ID: " + id);
                System.out.println(game.board);
                return new GameDataObject(game);
            }
        }
        System.out.println("GameDataAccess: No game found with ID: " + id);
        return null;
    }



    public static GameDataObject AddGame(GameDataObject newGame) {
        games.add(newGame);
        System.out.println("GameDataAccess: Added new game with ID: " + newGame.id);
        return newGame;
    }

 
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

    public static void UpdateGame(GameDataObject updatedGame) {
        for (int i = 0; i < games.size(); i++) {
            GameDataObject existingGame = games.get(i);
            if (existingGame.id == updatedGame.id) {
                existingGame.player1Id = updatedGame.player1Id;
                existingGame.player2Id = updatedGame.player2Id;
                existingGame.status = updatedGame.status;
                existingGame.currentTurnPlayer = updatedGame.currentTurnPlayer;
                existingGame.winnerId = updatedGame.winnerId;
                existingGame.board = updatedGame.board;
                break;
            }
        }
    }
}
