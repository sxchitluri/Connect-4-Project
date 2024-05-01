import static org.junit.Assert.*;
import org.junit.Test;

import Controller.GameController;
import Controller.GameTypeController;
import Controller.PlayerController;
import DomainObjects.GameDomainObject;
import Models.GameModel;
import restService.request.CreateGameRequest;
import restService.request.GameTypeRequest;
import restService.request.PlayGameRequest;
import restService.request.RegisterPlayerRequest;
import restService.response.GameResponse;
import restService.response.GameTypeResponse;
import restService.response.PlayerResponse;

// Story 5 test
public class PlayGameWinnerTest {

    GameTypeRequest req = new GameTypeRequest(0, "Classic");
    GameTypeResponse resp = GameTypeController.setGT2(req);

    RegisterPlayerRequest requestP1 = new RegisterPlayerRequest("doomsmith", "smashriptear");
    PlayerResponse responseP1 = PlayerController.registerPlayer(requestP1);
    // register player 2 (playerid = 1)
    RegisterPlayerRequest requestP2 = new RegisterPlayerRequest("tswizzle", "smashriptear");
    PlayerResponse responseP2 = PlayerController.registerPlayer(requestP2);
    // register player 3 (playerid = 2)
    RegisterPlayerRequest requestP3 = new RegisterPlayerRequest("ttpoetsdept", "smashriptear");
    PlayerResponse responseP3 = PlayerController.registerPlayer(requestP3);

    // Scenario 5.1: gameid does not exist - input not found
    @Test
    public void testGameWithInvalidId() {
        GameResponse response = GameController.GetGame(943); // Non-existing ID
        assertEquals(false, response.GetIsValid());
        assertEquals("Invalid GameId.", response.GetErrorMessage());
    }

    // Scenario 5.2.1: gameid does exist - input found but no winner yet
    @Test
    public void testGamePlayNoWin() {
        // Create a game request (gameid = 0)
        CreateGameRequest createRequest = new CreateGameRequest(1, 2, 0);
        // Create the game
        GameResponse createGameResponse = GameController.CreateGame(createRequest);

        // Print details about the created game
        System.out.println("Created Game ID: " + createGameResponse.GetGameId());
        System.out.println("Game Creation IsValid: " + createGameResponse.GetIsValid());
        System.out.println("Game Creation Error Message: " + createGameResponse.GetErrorMessage());

        // Retrieve the game ID from the created game response
        int gameId = createGameResponse.GetGameId();

        // Play the game with the retrieved game ID
        GameResponse response = GameController.PlayGame(new PlayGameRequest(gameId, 2, 3));

        // Debugging output to check the response of playing the game
        System.out.println("Game ID used for PlayGame: " + gameId);
        System.out.println("IsValid: " + response.GetIsValid());
        System.out.println("Error Message: " + response.GetErrorMessage());

        // Assertions to verify the game play results
        assertEquals(true, response.GetIsValid());
        assertNull(response.GetErrorMessage());
        assertEquals("Playing", response.GetStatus());
        assertEquals(0, response.GetWinnerId());
    }

    // Scenario 5.2.2.1: gameid does exist - input found and there is a winner (all
    // in vertical column)
    @Test
    public void testGamePlayWin() {
        // (gameid = 1)
        CreateGameRequest requestCG4 = new CreateGameRequest(2, 1, 0);
        GameResponse responseCG4 = GameController.CreateGame(requestCG4);

        // Retrieve the game ID from the created game response
        int gameId = responseCG4.GetGameId();

        // row 1
        PlayGameRequest requestPG7 = new PlayGameRequest(gameId, 1, 6);
        GameResponse responsePG7 = GameController.PlayGame(requestPG7);
        // row 2
        PlayGameRequest requestPG8 = new PlayGameRequest(gameId, 2, 5);
        GameResponse responsePG8 = GameController.PlayGame(requestPG8);
        // row 3
        PlayGameRequest requestPG9 = new PlayGameRequest(gameId, 1, 6);
        GameResponse responsePG9 = GameController.PlayGame(requestPG9);
        // row 4
        PlayGameRequest requestPG10 = new PlayGameRequest(gameId, 2, 5);
        GameResponse responsePG10 = GameController.PlayGame(requestPG10);
        // row 5
        PlayGameRequest requestPG11 = new PlayGameRequest(gameId, 1, 6);
        GameResponse responsePG11 = GameController.PlayGame(requestPG11);
        // row 6
        PlayGameRequest requestPG12 = new PlayGameRequest(gameId, 2, 5);
        GameResponse responsePG12 = GameController.PlayGame(requestPG12);
        // row 5
        // PlayGameRequest requestPG13 = new PlayGameRequest(gameId, 1, 6);
        // GameResponse responsePG13 = GameController.PlayGame(requestPG13);

        // Play the game with the retrieved game ID
        GameResponse response = GameController.PlayGame(new PlayGameRequest(gameId, 1, 6));

        // Assertions to verify the game play results
        assertEquals(true, response.GetIsValid());
        assertNull(response.GetErrorMessage());
        assertEquals("Completed", response.GetStatus());
        assertEquals(1, response.GetWinnerId());

    }

    // Scenario 5.2.2: gameid does exist - input found and there is a winner (all in
    // horizontal column)
    // an additional test we thought of apart from sprint plan - horiizaontal win
    // works
    @Test
    public void testGamePlayWin2() {
        // (gameid = 2)
        CreateGameRequest requestCG4 = new CreateGameRequest(2, 1, 0);
        GameResponse responseCG4 = GameController.CreateGame(requestCG4);

        // Retrieve the game ID from the created game response
        int gameId = responseCG4.GetGameId();

        // row 0
        PlayGameRequest requestPG7 = new PlayGameRequest(gameId, 1, 0);
        GameResponse responsePG7 = GameController.PlayGame(requestPG7);
        // row 0
        PlayGameRequest requestPG8 = new PlayGameRequest(gameId, 2, 6);
        GameResponse responsePG8 = GameController.PlayGame(requestPG8);
        // row 0
        PlayGameRequest requestPG9 = new PlayGameRequest(gameId, 1, 1);
        GameResponse responsePG9 = GameController.PlayGame(requestPG9);
        // row 0
        PlayGameRequest requestPG10 = new PlayGameRequest(gameId, 2, 5);
        GameResponse responsePG10 = GameController.PlayGame(requestPG10);
        // row 0
        PlayGameRequest requestPG11 = new PlayGameRequest(gameId, 1, 2);
        GameResponse responsePG11 = GameController.PlayGame(requestPG11);
        // row 0
        PlayGameRequest requestPG12 = new PlayGameRequest(gameId, 2, 5);
        GameResponse responsePG12 = GameController.PlayGame(requestPG12);

        // Play the game with the retrieved game ID
        GameResponse response = GameController.PlayGame(new PlayGameRequest(gameId, 1, 3));

        // Assertions to verify the game play results
        assertEquals(true, response.GetIsValid());
        assertNull(response.GetErrorMessage());
        assertEquals("Completed", response.GetStatus());
        assertEquals(1, response.GetWinnerId());

    }

    // Scenario 5.2.3: gameid does exist - input found and there is a winner (all in
    // diagonal column)
    // an additional test we thought of apart from sprint plan - could not get the
    // diagonal column win to work
    @Test
    public void testGamePlayWin3() {
        // (gameid = 3)
        CreateGameRequest requestCG4 = new CreateGameRequest(2, 1, 0);
        GameResponse responseCG4 = GameController.CreateGame(requestCG4);

        // Retrieve the game ID from the created game response
        int gameId = responseCG4.GetGameId();

        // row 0
        PlayGameRequest requestPG7 = new PlayGameRequest(gameId, 1, 0);
        GameResponse responsePG7 = GameController.PlayGame(requestPG7);
        // row 0
        PlayGameRequest requestPG8 = new PlayGameRequest(gameId, 2, 1);
        GameResponse responsePG8 = GameController.PlayGame(requestPG8);
        // row 1
        PlayGameRequest requestPG9 = new PlayGameRequest(gameId, 1, 1);
        GameResponse responsePG9 = GameController.PlayGame(requestPG9);
        // row 0
        PlayGameRequest requestPG10 = new PlayGameRequest(gameId, 2, 2);
        GameResponse responsePG10 = GameController.PlayGame(requestPG10);
        // row 0
        PlayGameRequest requestPG11 = new PlayGameRequest(gameId, 1, 3);
        GameResponse responsePG11 = GameController.PlayGame(requestPG11);
        // row 1
        PlayGameRequest requestPG12 = new PlayGameRequest(gameId, 2, 3);
        GameResponse responsePG12 = GameController.PlayGame(requestPG12);
        // row 1
        PlayGameRequest requestPG13 = new PlayGameRequest(gameId, 1, 2);
        GameResponse responsePG13 = GameController.PlayGame(requestPG13);
        // row 2
        PlayGameRequest requestPG14 = new PlayGameRequest(gameId, 2, 3);
        GameResponse responsePG14 = GameController.PlayGame(requestPG13);
        // row 3
        PlayGameRequest requestPG15 = new PlayGameRequest(gameId, 1, 3);
        GameResponse responsePG15 = GameController.PlayGame(requestPG13);
        // row 0
        PlayGameRequest requestPG16 = new PlayGameRequest(gameId, 2, 4);
        GameResponse responsePG16 = GameController.PlayGame(requestPG13);

        // Play the game with the retrieved game ID
        GameResponse response = GameController.PlayGame(new PlayGameRequest(gameId, 1, 2));

        // Assertions to verify the game play results
        assertEquals(true, response.GetIsValid());
        assertNull(response.GetErrorMessage());
        assertEquals("Completed", response.GetStatus());
        assertEquals(1, response.GetWinnerId());

    }

}
