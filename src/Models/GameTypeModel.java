package Models;

import java.util.ArrayList;

import DataAccess.GameTypeDataAccess;
import DataObjects.GameTypeDataObject;
import DomainObjects.GameTypeDomainObject;

public class GameTypeModel {

    // used in the playerdomainobject.java
    public static GameTypeDomainObject GetGameTypeById(int id) {
        GameTypeDataObject gameTypeData = GameTypeDataAccess.GetGameTypeById(id);
        return new GameTypeDomainObject(gameTypeData);
    }

    /*
     * // idk, for playerdomainobject.java
     * public static GameTypeDomainObject GetGameTypeById(GameTypeDomainObject
     * gameType) {
     * GameTypeDataObject gameTypeData =
     * GameTypeDataAccess.GetGameTypeById(gameType);
     * return new GameTypeDomainObject(gameTypeData);
     * }
     */

    public static ArrayList<GameTypeDomainObject> GetAllGameTypes() {
        ArrayList<GameTypeDataObject> gameTypeDataList = GameTypeDataAccess.GetAllGameTypes();
        return GameTypeDomainObject.MapList(gameTypeDataList);
    }

    public static GameTypeDomainObject AddGameType(GameTypeDomainObject gameType) {
        GameTypeDataObject gameTypeData = new GameTypeDataObject(gameType);
        GameTypeDataAccess.AddGameType(gameTypeData);  // This line should now be active
        return new GameTypeDomainObject(gameTypeData);
    }

    // Sprint/Story 3
    private static void validateGameType(GameTypeDomainObject gameType) {

    }

}
