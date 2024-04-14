package Models;

import java.util.ArrayList;

import DataAccess.PlayerDataAccess;
import DataAccess.GameDataAccess;
import DataObjects.PlayerDataObject;
import DataObjects.GameDataObject;
import DomainObjects.PlayerDomainObject;
import DomainObjects.GameDomainObject;

public class GameModel {

    public static GameDomainObject GetGameById(int id) {
        GameDataObject gameData = GameDataAccess.GetGameById(id);
        return new GameDomainObject(gameData);
    }

    public static GameDomainObject GetAvailableGame() {
        GameDataObject gameData = GameDataAccess.GetAvailableGame();
        
        if (gameData == null) {
            return null;
        }

        return new GameDomainObject(gameData);
    }

    public static GameDomainObject PlayGame(int gameId, int playerId, int column) {
        //Finish this in Sprint

        //Validate the inputs

        //check if gameId exists
        GameDataObject game = GameDataAccess.GetGameById(gameId);
        if (game == null) {
            //throw an error message
        }

        //validate the playerId
        PlayerDataObject player = PlayerDataAccess.GetPlayerById(playerId);
        if (player == null) {
            //throw an error message
        }

        //Validate the column
        //Make sure not passing a negative column, return errorMessage if column is filled, 

        //return errorMessage if game is done

        //if everything is valid, Update the Board with move

        return null;
    }
    


    public static void Save (GameDomainObject gameToSave) {
        GameDataObject gameDataObject = new GameDataObject(gameToSave);
        GameDataAccess.Save(gameDataObject);
    }

}
