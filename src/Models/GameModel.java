package Models;

import DataAccess.PlayerDataAccess;
import DataAccess.GameDataAccess;
import DataAccess.GameTypeDataAccess;
import DataAccess.BoardDataAccess;
import DataObjects.PlayerDataObject;
import DataObjects.BoardDataObject;
import DataObjects.GameDataObject;

import DomainObjects.BoardDomainObject;
import DomainObjects.GameDomainObject;

public class GameModel {

    public static GameDomainObject GetGameById(int id) {
        GameDataObject gameData = GameDataAccess.GetGameById(id);
        return new GameDomainObject(gameData);
    }

    /*
     * public static GameDomainObject GetAvailableGame() {
     * GameDataObject gameData = GameDataAccess.GetAvailableGame(); //commented out
     * in other code; idk what we are doing with it
     * 
     * if (gameData == null) {
     * return null;
     * }
     * 
     * return new GameDomainObject(gameData);
     * }
     */

    // STORY 4

    public static GameDomainObject playGame(int gameId, int playerId, int column) {
        // validate inputs
        validatePlayGame(gameId, playerId, column);

        GameDataObject gameData = GameDataAccess.GetGameById(gameId);
        BoardDomainObject board = BoardModel.GetBoardByGameId(gameData.id);

        // update board
        board.updateBoard(column, playerId);

        // Step 3: Check for winner

        if (checkForWinnerGame(gameId)) {
            gameData.status = "Completed";
            gameData.winnerId = playerId;
        } else {
            // Update turn to the next player
            gameData.currentTurnPlayer = gameData.currentTurnPlayer == gameData.player1Id ? gameData.player2Id
                    : gameData.player1Id;
        }

        // Step 4: Save updates
        GameDataAccess.Save(new GameDataObject(gameData));
        BoardDataAccess.Save(new BoardDataObject(board));

        return new GameDomainObject(gameData);
    }

    // STORY 5 - GETTING WINNER DETAILS FOR A GAME??- tied to GameResponse
    // PlayGame???
    private static boolean checkForWinnerGame(int gameId) {
        BoardDomainObject board = BoardModel.GetBoardByGameId(gameId);
        if (board == null) {
            throw new IllegalStateException("Board not found when checking for winner");
        }
        return board.checkForWinner();
    }

    public static void Save(GameDomainObject gameToSave) {
        GameDataObject gameDataObject = new GameDataObject(gameToSave);
        GameDataAccess.Save(gameDataObject);
    }

    // validation for play game inputs/request
    private static void validatePlayGame(int gameId, int playerId, int column) {
        // Step 1: Validate inputs and state
        GameDataObject gameData = GameDataAccess.GetGameById(gameId);
        if (gameData == null) {
            throw new IllegalArgumentException("Game ID not found");
        }

        PlayerDataObject playerData = PlayerDataAccess.getPlayerById(playerId);
        if (playerData == null) {
            throw new IllegalArgumentException("Player ID not found");
        }

        if (!(playerId == gameData.player1Id || playerId == gameData.player2Id)) {
            throw new IllegalArgumentException("Player ID " + playerId + " is not part of this game.");
        }

        if (gameData.currentTurnPlayer != playerId) {
            throw new IllegalArgumentException("It is not player " + playerId + "'s turn.");
        }

        if (gameData.status.equals("Completed")) {
            throw new IllegalArgumentException("Game is already completed.");
        }

        // Step 2: Get and update board
        BoardDomainObject board = BoardModel.GetBoardByGameId(gameData.id);
        if (board == null) {
            throw new IllegalStateException("Board not found for the game");
        }

        if (!board.isValidColumn(column)) {
            throw new IllegalArgumentException("Invalid Column Number");
        }

        if (!board.hasSpaceAvailable(column)) {
            throw new IllegalArgumentException("Column is Full");
        }
    }

    public static GameDomainObject createGame(int player1Id, int player2Id, int gameTypeId) {
        // Validate player IDs
        if (PlayerDataAccess.GetPlayerById(player1Id) == null) {
            throw new IllegalArgumentException("Invalid player1 ID");
        }
        if (PlayerDataAccess.GetPlayerById(player2Id) == null) {
            throw new IllegalArgumentException("Invalid player2 ID");
        }

        // Validate game type ID
        if (GameTypeDataAccess.GetGameTypeById(gameTypeId) == null) {
            throw new IllegalArgumentException("Invalid gameTypeId");
        }

        // Create a new game with the validated game type
        GameDataObject newGame = new GameDataObject(-1, player1Id, player2Id, "Playing", player1Id, gameTypeId);
        newGame = GameDataAccess.AddGame(newGame);

        // Create a new board and link it to the newly created game
        BoardDataObject newBoard = new BoardDataObject(-1, newGame.id, BoardDataObject.DEFAULT_GAMEBOARD);
        newBoard = BoardDataAccess.AddBoard(newBoard);

        // Return a domain object representing the new game
        return new GameDomainObject(newGame.id, newGame.player1Id, newGame.player2Id, newGame.currentTurnPlayer,
                newGame.status, newGame.winnerId, new BoardDomainObject(newBoard));
    }

}
