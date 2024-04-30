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

        if (gameData == null) {
            return null;
        }
        return new GameDomainObject(gameData);
    }

    // Story 4
    public static GameDomainObject playGame(int gameId, int playerId, int column) {
        try {
            // Validate inputs and retrieve game data
            validatePlayGame(gameId, playerId, column);
            GameDataObject gameData = GameDataAccess.GetGameById(gameId);
            if (gameData == null) {
                throw new IllegalArgumentException("Game not found with ID: " + gameId);
            }

            // Retrieve and update board
            BoardDomainObject board = BoardModel.GetBoardByGameId(gameData.id);
            if (board == null) {
                throw new IllegalStateException("Board is null for Game ID: " + gameData.id);
            }
            // update board and save
            board.updateBoard(column, playerId);
            BoardDataAccess.Save(new BoardDataObject(board));

            // Check for a winner
            if (checkForWinnerGame(gameId)) {
                gameData.status = "Completed";
                gameData.winnerId = playerId;
            } else {
                gameData.currentTurnPlayer = (gameData.currentTurnPlayer == gameData.player1Id) ? gameData.player2Id
                        : gameData.player1Id;
            }

            // Save game state
            GameDataAccess.Save(new GameDataObject(gameData));

            // Return game domain object with updated board
            return new GameDomainObject(gameData, board);
        } catch (Exception ex) {
            System.out.println("Error during playGame: " + ex.getMessage());
            throw ex; // Re-throw to ensure visibility of failure
        }
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
            throw new IllegalArgumentException("Column is filled. Please choose another column.");
        }
    }

    public static GameDomainObject createGame(int player1Id, int player2Id, int gameTypeId) {
        // Preliminary validation
        if (PlayerDataAccess.GetPlayerById(player1Id) == null) {
            throw new IllegalArgumentException("Invalid player1 ID");
        }
        if (PlayerDataAccess.GetPlayerById(player2Id) == null) {
            throw new IllegalArgumentException("Invalid player2 ID");
        }
        if (GameTypeDataAccess.GetGameTypeById(gameTypeId) == null) {
            throw new IllegalArgumentException("Invalid gameTypeId");
        }
    
        // Initially, create a new game object with minimal data to get a valid gameId
        int gameId = GameDataAccess.getNextId();
        GameDataObject initialGame = new GameDataObject(gameId, player1Id, player2Id, "Initial", player2Id, 0, null);
        GameDataAccess.AddGame(initialGame);  // Store initial game object
    
        // Create board with the obtained gameId
        BoardDataObject newBoard = new BoardDataObject(BoardDataAccess.getNextId(), gameId, BoardDataObject.DEFAULT_GAMEBOARD);
        BoardDataAccess.AddBoard(newBoard);
    
        // Now finalize the game creation with full details and the board linked
        GameDataObject finalGame = new GameDataObject(gameId, player1Id, player2Id, "Playing", player2Id, gameTypeId, new BoardDomainObject(newBoard));
        GameDataAccess.UpdateGame(finalGame);  // Update stored game data with full details
    
        return new GameDomainObject(finalGame);
    }

}
