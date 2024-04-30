package DataObjects;

import DomainObjects.BoardDomainObject;

public class BoardDataObject {
    
    public final static String DEFAULT_GAMEBOARD = "                                          "; //42 spaces

    public int id;
    public int gameId;
    public String occupancy;

    public BoardDataObject(int id, int gameId, String occupancy) {
        this.id = id;
        this.gameId = gameId;
        this.occupancy = occupancy;
    }

    //Copy Constructor
    public BoardDataObject(BoardDataObject board) {
        this.id = board.id;
        this.gameId = board.gameId;
        this.occupancy = board.occupancy;
    }

    public BoardDataObject(BoardDomainObject board) {
        this.id = board.GetId();
        this.gameId = board.GetGameId();
        this.occupancy = board.GetOccupancy();
    }
}
