package Models;

import java.util.ArrayList;

import DataAccess.PlayerDataAccess;
import DataObjects.PlayerDataObject;
import DomainObjects.PlayerDomainObject;

public class PlayerModel {

    public static PlayerDomainObject GetPlayerById(int id) {
        PlayerDataObject playerData = PlayerDataAccess.GetPlayerById(id);
        return new PlayerDomainObject(playerData);
    }

    // Need fixing, getting player details on 1 player object using gameId
    public static PlayerDomainObject GetFirstAvailableByGameId(int gameId) {
        PlayerDataObject playerData = PlayerDataAccess.GetFirstAvailableByGameId(gameId); // added new method in
                                                                                          // playerdataaccess, or should
                                                                                          // it be the getplayerbygameid
                                                                                          // method???

        if (playerData == null) {
            return null;
        }

        return new PlayerDomainObject(playerData);
    }

    public static ArrayList<PlayerDomainObject> GetAllPlayers() {
        ArrayList<PlayerDataObject> playerDataList = PlayerDataAccess.GetAllPlayers();
        return PlayerDomainObject.MapList(playerDataList);
    }

    // check with PlayerDataAccess.java for method
    public static ArrayList<PlayerDomainObject> GetPlayersByGameId(int id) {
        ArrayList<PlayerDataObject> playerDataList = PlayerDataAccess.GetPlayersByGameId(id);
        return PlayerDomainObject.MapList(playerDataList);
    }

    public static PlayerDomainObject AddPlayer(PlayerDomainObject player) {

        validatePlayer(player);

        PlayerDataObject playerData = new PlayerDataObject(player);
        PlayerDataAccess.AddPlayer(playerData); // give id for player after validation of username/password
        return new PlayerDomainObject(playerData);

    }

    // this is the return the player domain object that was created once input validated
    public static PlayerDomainObject RegisterPlayer(PlayerDomainObject player) {
        validatePlayer(player);

        PlayerDataObject playerData = new PlayerDataObject(player);
        //pass new player data object to data access to crate a new player, then pass to domain object
        PlayerDataAccess.AddPlayer(playerData); // give id for player after validation of username/password
        return new PlayerDomainObject(playerData);
    }

    // this is to return the player domain object, once validated input, exists in player data access list
    public static PlayerDomainObject ExistingPlayer(PlayerDomainObject player) {
        
        validatePlayer(player);

        PlayerDataObject playerData = PlayerDataAccess.GetPlayerById(player.GetId()); // give id for player after validation of username/password
        return new PlayerDomainObject(playerData);
    }

    // STORY 1 - validation methods also go here for playerModel?????
    private static void validatePlayer(PlayerDomainObject player) {
        // Sprint 1 - Story 1: validate player registation

        // Validate Username
        // validate 6-20 characters

        // validate only letters and numbers

        // validate username is unique

        // Validate Password
        // validate 6-20 characters

    }

    // STORY 3 - validate the players 1 and 2 exist for creating a game

    public static void Save(PlayerDomainObject playerToSave) {
        PlayerDataObject playerDataObject = new PlayerDataObject(playerToSave);
        PlayerDataAccess.Save(playerDataObject);
    }

}
