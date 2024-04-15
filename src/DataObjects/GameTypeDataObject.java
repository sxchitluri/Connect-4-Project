package DataObjects;

import DomainObjects.GameTypeDomainObject;

public class GameTypeDataObject {
    
    public int id;
    public String name;

    public GameTypeDataObject (int id, String name) {
        this.id = id;
        this.name = name;
    }

    //Copy Constructor
    public GameTypeDataObject (GameTypeDataObject gameType) {
        this.id = gameType.id;
        this.name = gameType.name;
    }

    public GameTypeDataObject (GameTypeDomainObject gameType) {
        this.id = gameType.GetId();
        this.name = gameType.GetName();
    }
}
