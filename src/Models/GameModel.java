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

    //STORY 4
    public static GameDomainObject PlayGame(int gameId, int playerId, int column) {
        //Finish this in Sprint

        //Validate the inputs

        //check if gameId exists
        GameDataObject game = GameDataAccess.GetGameById(gameId);
        if (game == null) {
            //throw an error message
        }

        //validate the playerId exists at all
        PlayerDataObject player = PlayerDataAccess.GetPlayerById(playerId);
        if (player == null) {
            //throw an error message
        }

        //validate the playerid to be one of the game's players

        //validate the playerid to be the current turn player id

        //Validate the column
        //Make sure not passing a negative column, return errorMessage if column is filled, 

        //check status, return errorMessage if game is done

        //if everything is valid, Update the Board with move


        // check method for Winner, winner method

        //check the status of the board again, if complete = exit Play game and not update currentturn player

        //update current turn player id to the other player's id

        return null;
    }
    
    //STORY 5 - GETTING WINNER DETAILS FOR A GAME??- tied to GameResponse PlayGame???
    public static GameDomainObject CheckWinner(int gameId) {
        //Validate gameId exists, if not return error message

        //Validate the board string for Connect 4, if not return error message; if winner - update game status to complete and update winnerId
    }

    public static void Save (GameDomainObject gameToSave) {
        GameDataObject gameDataObject = new GameDataObject(gameToSave);
        GameDataAccess.Save(gameDataObject);
    }

}
