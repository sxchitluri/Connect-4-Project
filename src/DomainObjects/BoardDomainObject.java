package DomainObjects;

import java.util.ArrayList;

import DataObjects.BoardDataObject;
import Models.PlayerModel;
import Models.BoardModel;
import Models.GameModel;

public class BoardDomainObject {

    private int id;
    private int gameId;
    private String occupancy;

    private GameDomainObject game;

    public BoardDomainObject (int id, int gameId, String occupancy) {
        this.id = id;
        this.gameId = gameId;
        this.occupancy = occupancy;
    }

    public BoardDomainObject(BoardDataObject board) {
        this.id = board.id;
        this.gameId = board.gameId;
        this.occupancy = board.occupancy;
    }
    
    public static ArrayList<BoardDomainObject> MapList(ArrayList<BoardDataObject> boarddata) {
        ArrayList<BoardDomainObject> boardDomain = new ArrayList<BoardDomainObject>();
        for (BoardDataObject board : boarddata) {
            boardDomain.add(new BoardDomainObject(board));
        }
        return boardDomain;
    }
    
    public int GetId() {
        return this.id;
    }

    public int GetGameId() {
        return this.gameId;
    }

    public String GetOccupancy() {
        return this.occupancy;
    }

    public GameDomainObject GetGame() {
        //Lazy Load the Robot
        if (this.game == null) {
            this.game = GameModel.GetGameById(gameId);
        }
        return this.game;
    }

    public void SetGame(int gameId) {
        this.gameId = gameId;
        BoardModel.Save(this);
    }
    
}
