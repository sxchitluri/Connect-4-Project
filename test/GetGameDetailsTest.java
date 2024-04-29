import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import Controller.GameController;
import Controller.GameTypeController;
import Controller.PlayerController;
import restService.request.CreateGameRequest;
import restService.request.GameTypeRequest;
import restService.request.GetGameDetailsRequest;
import restService.request.GetPlayerDetailsRequest;
import restService.request.RegisterPlayerRequest;
import restService.response.GameResponse;
import restService.response.GameTypeResponse;
import restService.response.PlayerResponse;

// Story 2
public class GetGameDetailsTest {

    // default game values
    // create 2 players for gameid=0
    // create a game here with gameid=0
    GameTypeRequest reqGT = new GameTypeRequest(0, "Classic");
    GameTypeResponse resGT = GameTypeController.setGT2(reqGT);

    // register player 1 (playerid = 0)
    RegisterPlayerRequest requestP1 = new RegisterPlayerRequest("doomsmith", "smashriptear");
    PlayerResponse responseP1 = PlayerController.registerPlayer(requestP1);
    // register player 2 (playerid = 1)
    RegisterPlayerRequest requestP2 = new RegisterPlayerRequest("tswizzle", "smashriptear");
    PlayerResponse responseP2 = PlayerController.registerPlayer(requestP2);
    // Create a game 1 that has player1Id and player2Id (gameid = 0)
    CreateGameRequest requestCG1 = new CreateGameRequest(0, 1, 0);
    GameResponse responseCG1 = GameController.CreateGame(requestCG1);

    // tests for valid inputs
    // Scenario 2.2: gameid does exist - input found
    @Test
    public void GameController_GetGameDetails_SuccessTest() {

        int gameid = 0;

        // create the request to get game details
        GetGameDetailsRequest request = new GetGameDetailsRequest(gameid);

        // now call the game controller's getgamedetails method and pass in the
        // request to the
        // controller. Then it should return back a reponse, the game response
        GameResponse response = GameController.getGameDetails(request);

        // now we test the reponse
        assertEquals(true, response.GetIsValid());
        assertNull(response.GetErrorMessage());
        assertEquals(0, response.GetGameId());
        assertEquals(0, response.GetGameTypeId());
        assertEquals(0, response.GetPlayer1Id());
        assertEquals(1, response.GetPlayer2Id());
        assertEquals(1, response.GetCurrentTurnPlayer());
        assertEquals("Playing", response.GetStatus());
        assertEquals(0, response.GetWinnerId());
        assertNotNull(response.GetBoard());
        assertEquals("                                          ", response.GetBoard());
    }

    // tests for invalid inputs
    // Scenario 2.1: gameid does not exist - input not found
    @Test
    public void GameController_GetGameDetails_NotExistTest() {

        int gameid = 1;

        // create the request to get game details
        GetGameDetailsRequest request = new GetGameDetailsRequest(gameid);

        // now call the game controller's getgamedetails method and pass in the
        // request to the
        // controller. Then it should return back a reponse, the game response
        GameResponse response = GameController.getGameDetails(request);

        // now we test the reponse
        assertEquals(false, response.GetIsValid());
        assertEquals("Invalid GameId.", response.GetErrorMessage());
        assertEquals(-1, response.GetGameId());
        assertEquals(-1, response.GetGameTypeId());
        assertEquals(-1, response.GetPlayer1Id());
        assertEquals(-1, response.GetPlayer2Id());
        assertEquals(-1, response.GetCurrentTurnPlayer());
        assertEquals("", response.GetStatus());
        assertEquals(-1, response.GetWinnerId());
        assertEquals("", response.GetBoard());
    }

}
