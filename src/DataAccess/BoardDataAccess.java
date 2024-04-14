package DataAccess;

import java.util.ArrayList;
import DataObjects.BoardDataObject;

public class BoardDataAccess {

    private static ArrayList<BoardDataObject> boards = new ArrayList<BoardDataObject>();
    private static int nextId = 0;

    public BoardDataAccess() {
        initialize();
    }

    private void initialize() {
        boards.add(new BoardDataObject(0, 0, "NEED BOARD"));
        nextId = 1;
    }

    private static int getNextId() {
        int thisId = nextId;
        nextId++;
        return thisId;
    }

    public static ArrayList<BoardDataObject> GetAllBoards() {
        ArrayList<BoardDataObject> itemsList = new ArrayList<BoardDataObject>();

        //Create a copy of itemTypes to return
        for (BoardDataObject item : boards) {
            itemsList.add(new BoardDataObject(item));
        }
        return itemsList;
    }

    public static BoardDataObject GetBoardById(int id) {
        for (BoardDataObject item : boards) {
            if (item.id == id) {
                return new BoardDataObject(item);
            }
        }
        return null;
    }

    public static BoardDataObject GetBoardByGameId(int gameId) {
        for (BoardDataObject board : boards) {
            if (board.gameId == gameId) {
                return new BoardDataObject(board);
            }
        }
        return null;
    }

    public static void Save(BoardDataObject boardToSave) {
        for (BoardDataObject board : boards) {
            if (board.id == boardToSave.id) {
                //The gameId cannot be changed
                //board.gameId = boardToSave.gameId;
                board.occupancy = boardToSave.occupancy;
            }
        }
    }

    public static BoardDataObject AddBoard(BoardDataObject newBoard) {
        newBoard.id = getNextId();
        boards.add(newBoard);
        return newBoard;
    }
    
}
