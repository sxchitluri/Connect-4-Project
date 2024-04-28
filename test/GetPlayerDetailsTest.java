import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Controller.PlayerController;
import restService.request.GetPlayerDetailsRequest;
import restService.request.RegisterPlayerRequest;
import restService.response.PlayerResponse;

// story 6 test
public class GetPlayerDetailsTest {

    // default values for players that exist with either games played or not
    // Default values
    String username = "doomsmith";
    String password = "smashriptear";
    RegisterPlayerRequest request = new RegisterPlayerRequest(username, password);
    PlayerResponse response = PlayerController.registerPlayer(request);

    // tests for valid inputs
    // Scenario 6.2: playerid does exist - input found
    @Test
    public void PlayerController_GetPlayerDetails_SuccessTest() {

        int playerid = 0;

        // create the request to get player details
        GetPlayerDetailsRequest request = new GetPlayerDetailsRequest(playerid);

        // now call the player controller's getplayerdetails method and pass in the
        // request to the
        // controller. Then it should return back a reponse, the player response
        PlayerResponse response = PlayerController.getPlayerDetails(request);

        // now we test the reponse
        assertEquals(true, response.GetIsValid()); // getting false here
        assertEquals(null, response.GetErrorMessage());
        assertEquals("doomsmith", response.getUsername());
        assertEquals(0, response.getPlayerId());
        assertEquals(0, response.getGamesPlayed());
        assertEquals(0, response.getGamesWon());
        assertEquals(0, response.getGamesLost());
    }

    // tests for invalid inputs
    // Scenario 6.1: playerid does not exist - input not found
    @Test
    public void PlayerController_GetPlayerDetails_NotExistTest() {

        int playerid = 10;

        // create the request to get player details
        GetPlayerDetailsRequest request = new GetPlayerDetailsRequest(playerid);

        // now call the player controller's getplayerdetails method and pass in the
        // request to the
        // controller. Then it should return back a reponse, the player response
        PlayerResponse response = PlayerController.getPlayerDetails(request);

        // now we test the reponse
        assertEquals(false, response.GetIsValid());
        assertEquals("Player ID not found", response.GetErrorMessage());
        assertEquals("", response.getUsername());
        assertEquals(-1, response.getPlayerId());
        assertEquals(-1, response.getGamesPlayed());
        assertEquals(-1, response.getGamesWon());
        assertEquals(-1, response.getGamesLost());

        // test is getting the wrong error message -> it is getting the error message
        // for playerUser being null and not that the player id does not exist
    }

}
