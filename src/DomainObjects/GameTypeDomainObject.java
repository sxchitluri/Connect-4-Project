package DomainObjects;

import java.util.ArrayList;

import DataObjects.GameTypeDataObject;
import restService.request.GameTypeRequest;

public class GameTypeDomainObject {

    private int id;
    private String name;

    public GameTypeDomainObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public GameTypeDomainObject(GameTypeDataObject gameType) {
        this.id = gameType.id;
        this.name = gameType.name;
    }

    public GameTypeDomainObject(GameTypeRequest request) {
        this.id = request.getId();
        this.name = request.getName();
    }

    public static ArrayList<GameTypeDomainObject> MapList(ArrayList<GameTypeDataObject> gameTypedata) {
        ArrayList<GameTypeDomainObject> gameTypeDomain = new ArrayList<GameTypeDomainObject>();
        for (GameTypeDataObject gameType : gameTypedata) {
            gameTypeDomain.add(new GameTypeDomainObject(gameType));
        }
        return gameTypeDomain;
    }

    public int GetId() {
        return this.id;
    }

    public String GetName() {
        return this.name;
    }

}
