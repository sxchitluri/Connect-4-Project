import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Controller.GameController;
import Controller.PlayerController;
import DataAccess.GameTypeDataAccess;
import restService.request.CreateGameRequest;
import restService.request.PlayGameRequest;
import restService.request.RegisterPlayerRequest;
import restService.response.GameResponse;
import restService.response.PlayerResponse;

// Story 4 test
public class PlayGameTest {

    //gametype initialized
    GameTypeDataAccess.GameTypeDataAccess();

    // register player 1 (playerid = 0)
    RegisterPlayerRequest requestP1 = new RegisterPlayerRequest("doomsmith", "smashriptear");
    PlayerResponse responseP1 = PlayerController.registerPlayer(requestP1);
    // register player 2 (playerid = 1)
    RegisterPlayerRequest requestP2 = new RegisterPlayerRequest("tswizzle", "smashriptear");
    PlayerResponse responseP2 = PlayerController.registerPlayer(requestP2);
    // register player 3 (playerid = 2)
    RegisterPlayerRequest requestP3 = new RegisterPlayerRequest("ttpoetsdept", "smashriptear");
    PlayerResponse responseP3 = PlayerController.registerPlayer(requestP3);

    // write the initial default game values from game data access here

    // Create a game 1 that has player1Id and player2Id (gameid = 0)
    CreateGameRequest requestCG1 = new CreateGameRequest(0, 1, 0);
    GameResponse responseCG1 = GameController.CreateGame(requestCG1);
    // Create a game 2 that has player1Id and player2Id (gameid = 1)
    CreateGameRequest requestCG2 = new CreateGameRequest(1, 2, 0);
    GameResponse responseCG2 = GameController.CreateGame(requestCG2);

    // play game to fill up column 7 for game 1
    // row 1
    PlayGameRequest requestPG1 = new PlayGameRequest(0, 1, 7);
    GameResponse responsePG1 = GameController.PlayGame(requestPG1);
    //row 2
    PlayGameRequest requestPG2 = new PlayGameRequest(0, 0, 7);
    GameResponse responsePG2 = GameController.PlayGame(requestPG2);
    //row 3
    PlayGameRequest requestPG3 = new PlayGameRequest(0, 1, 7);
    GameResponse responsePG3 = GameController.PlayGame(requestPG3);
    //row 4
    PlayGameRequest requestPG4 = new PlayGameRequest(0, 0, 7);
    GameResponse responsePG4 = GameController.PlayGame(requestPG4);
    //row 5
    PlayGameRequest requestPG5 = new PlayGameRequest(0, 1, 7);
    GameResponse responsePG5 = GameController.PlayGame(requestPG5);
    //row 6
    PlayGameRequest requestPG6 = new PlayGameRequest(0, 0, 7);
    GameResponse responsePG6 = GameController.PlayGame(requestPG6);
    

    // testing valid inputs
    // Scenario 4.9: Column input, gameid input, playerid input - all valid and follow the above parameters
    @Test
    public void GameController_PlayGame_SuccessTest() {

        int gameId = 1;
        int playerId = 2;
        int column = 3;

        // create the request to play game
        PlayGameRequest request = new PlayGameRequest(gameId, playerId, column);

        // now call the game controller and pass in the request to the controller. Then
        // it should return back a reponse, the player response
        GameResponse response = GameController.PlayGame(request);

        // now we test the reponse
        assertEquals(true, response.GetIsValid());
        assertEquals(null, response.GetErrorMessage());
        assertEquals(1, response.GetGameId());
        assertEquals(1, response.GetCurrentTurnPlayer()); // current turn player should change to 1 once 2 's play
                                                          // works'

        assertEquals(1, response.GetPlayer1Id());
        assertEquals(2, response.GetPlayer2Id());
        assertEquals("Playing", response.GetStatus());
        assertEquals(-1, response.GetWinnerId());
        // assertEquals(???, response.GetBoard());
    }

    // testing invalild inputs
    // column tests
    // scenario 4.1: Column Input Test - out of range
    @Test
    public void GameController_PlayGame_ColumnRange() {
        int gameId = 1;
        int playerId = 1;
        int column = 8;

        // create the request to play game
        PlayGameRequest request = new PlayGameRequest(gameId, playerId, column);

        // now call the game controller and pass in the request to the controller. Then
        // it should return back a reponse, the player response
        GameResponse response = GameController.PlayGame(request);

        // now we test the reponse
        assertEquals(false, response.GetIsValid());
        assertEquals("Invalid Column Number", response.GetErrorMessage());
        assertEquals(-1, response.GetGameId());
        assertEquals(-1, response.GetCurrentTurnPlayer()); // current turn player should change to 1 once 2 's play
                                                          // works'

        assertEquals(-1, response.GetPlayer1Id());
        assertEquals(-1, response.GetPlayer2Id());
        assertEquals("", response.GetStatus());
        assertEquals(-1, response.GetWinnerId());
    }

    // scenario 4.2: Column Input Test - not a number 
    // NOTES: the variable Column cannot take any other input here than a number, cannot be tested
    @Test
    public void GameController_PlayGame_ColumnNum() {
        int gameId = 1;
        int playerId = 1;
        int column = left3;

        PlayGameRequest request = new PlayGameRequest(gameId, playerId,column);
        GameResponse response = GameController.PlayGame(request);

        assertEquals(false, response.GetIsValid());
        assertEquals("Invalid Column Number", response.GetErrorMessage());
        assertEquals(-1, response.GetGameId());
        assertEquals(-1, response.GetCurrentTurnPlayer()); 
        assertEquals(-1, response.GetPlayer1Id());
        assertEquals(-1, response.GetPlayer2Id());
        assertEquals("", response.GetStatus());
        assertEquals(-1, response.GetWinnerId());
    }

    // scenario 4.3: Column Input Test - availability 
    @Test
    public void GameController_PlayGame_ColumnAvail() {
        int gameId = 0;
        int playerId = 1;
        int column = 7; // this column has been filled above

        PlayGameRequest request = new PlayGameRequest(gameId, playerId,column);
        GameResponse response = GameController.PlayGame(request);

        assertEquals(false, response.GetIsValid());
        assertEquals("Column is filled. Please choose another column.", response.GetErrorMessage());
        assertEquals(-1, response.GetGameId());
        assertEquals(-1, response.GetCurrentTurnPlayer()); 
        assertEquals(-1, response.GetPlayer1Id());
        assertEquals(-1, response.GetPlayer2Id());
        assertEquals("", response.GetStatus());
        assertEquals(-1, response.GetWinnerId());
    }

    // game id test
    // scenario 4.4: gameid does not exist - input not found
    @Test
    public void GameController_PlayGame_GameIdExist() {

    }

    // player id tests
    // Scenario 4.5: playerid does not exist - input not found
    @Test
    public void GameController_PlayGame_PlayerIdExist() {

    }

    // Scenario 4.6: playerid does exist - but not a playerid in the game
    @Test
    public void GameController_PlayGame_PlayerIdinGame() {

    }

    // Scenario 4.7: playerid does exist and in the game- but is not the current turn player
    @Test
    public void GameController_PlayGame_PlayerIdCurrentTurn() {

    }

    // status test
    // Scenario 4.8: Status of the game - Completed
    @Test
    public void GameController_PlayGame_StatusGame() {

    }

}
