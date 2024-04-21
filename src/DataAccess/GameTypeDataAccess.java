package DataAccess;

import java.util.ArrayList;
import DataObjects.GameTypeDataObject;
import DomainObjects.GameTypeDomainObject;

public class GameTypeDataAccess {

    private static ArrayList<GameTypeDataObject> gameTypes = new ArrayList<GameTypeDataObject>();
    // private static int nextId = 0;

    public GameTypeDataAccess() {
        initialize();
    }

    private void initialize() {
        gameTypes.add(new GameTypeDataObject(0, "Classic"));
        // gameTypes.add(new GameTypeDataObject(1, "Connect-3");
        // nextId = 1;
    }

    /*
     * private static int getNextId(){
     * int thisId = nextId;
     * nextId++;
     * return thisId;
     * }
     */

    public static ArrayList<GameTypeDataObject> GetAllGameTypes() {
        ArrayList<GameTypeDataObject> itemTypesList = new ArrayList<GameTypeDataObject>();
        // Create a copy of itemTypes to return
        for (GameTypeDataObject itemType : gameTypes) {
            itemTypesList.add(new GameTypeDataObject(itemType));
        }
        return itemTypesList;
    }

    public static GameTypeDataObject GetGameTypeById(int id) {
        for (GameTypeDataObject itemType : gameTypes) {
            if (itemType.id == id) {
                return new GameTypeDataObject(itemType);
            }
        }
        return null;
    }

    /*
    // idk, for playerdomainobject.java
    public static GameTypeDataObject GetGameTypeById(GameTypeDomainObject gameType) {
        for (GameTypeDataObject itemType : gameTypes) {
            if (itemType.id == gameType) {
                return new GameTypeDataObject(itemType);
            }
        }
        return null;
    }
    */

}
