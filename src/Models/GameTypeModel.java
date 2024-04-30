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

    public static ArrayList<GameTypeDomainObject> GetAllGameTypes() {
        ArrayList<GameTypeDataObject> gameTypeDataList = GameTypeDataAccess.GetAllGameTypes();
        return GameTypeDomainObject.MapList(gameTypeDataList);
    }

    public static GameTypeDomainObject AddGameType(GameTypeDomainObject gameType) {
        GameTypeDataObject gameTypeData = new GameTypeDataObject(gameType);
        GameTypeDataAccess.AddGameType(gameTypeData);
        return new GameTypeDomainObject(gameTypeData);
    }

}
