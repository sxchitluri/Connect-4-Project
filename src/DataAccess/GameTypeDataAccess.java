package DataAccess;

import java.util.ArrayList;
import DataObjects.GameTypeDataObject;


public class GameTypeDataAccess {

    private static ArrayList<GameTypeDataObject> gameTypes = new ArrayList<GameTypeDataObject>();


    public GameTypeDataAccess() {
        initialize();
    }

    private void initialize() {
        gameTypes.add(new GameTypeDataObject(0, "Classic"));
    }


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

    public static void AddGameType(GameTypeDataObject gameType) {
        gameType.id = gameTypes.size();
        gameTypes.add(gameType);
    }

}
