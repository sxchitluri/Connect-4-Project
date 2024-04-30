import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Controller.PlayerController;
import restService.request.RegisterPlayerRequest;
import restService.response.PlayerResponse;

// Story 1 test
public class PlayerRegistrationTest {

    // Default values
    String username = "doomsmith";
    String password = "smashriptear";
    RegisterPlayerRequest request = new RegisterPlayerRequest(username, password);
    PlayerResponse response = PlayerController.registerPlayer(request);

    // tests for valid inputs
    // Scenario 1.8: Username and Password Input Test – Correct inputs
    @Test
    public void PlayerController_RegisterPlayer_SuccessTest() {

        String username = "username3";
        String password = "password1";

        // create the request to register player
        RegisterPlayerRequest request = new RegisterPlayerRequest(username, password);

        // now call the register player controller and pass in the request to the
        // controller. Then it should return back a reponse, the player response
        PlayerResponse response = PlayerController.registerPlayer(request);

        // now we test the reponse
        assertEquals(true, response.GetIsValid());
        assertEquals(null, response.GetErrorMessage());
        assertEquals("username3", response.getUsername());
        assertEquals(1, response.getPlayerId()); // not making next playerid to return
        // do we need an assertEquals for password?, if we are not storing them here?
    }

    // Scenario 1.9: Username and Password Input Test – Correct inputs and test
    // sequential playerid
    @Test
    public void PlayerController_RegisterPlayer_SuccessTest_SeqPlayerId() {

        String username = "username4";
        String password = "password2";

        RegisterPlayerRequest request = new RegisterPlayerRequest(username, password);
        PlayerResponse response = PlayerController.registerPlayer(request);

        // now we test the reponse
        assertEquals(true, response.GetIsValid());
        assertEquals(null, response.GetErrorMessage());
        assertEquals("username4", response.getUsername());
        assertEquals(2, response.getPlayerId()); // not making next playerid to return

    }

    // tests for invalid inputs
    // Scenario 1.1: Username Input Test – Too Short
    @Test
    public void PlayerController_RegisterPlayer_UsernameShort() {
        String username = "short";
        String password = "tenchars00";

        RegisterPlayerRequest request = new RegisterPlayerRequest(username, password);
        PlayerResponse response = PlayerController.registerPlayer(request);

        // now we test the reponse
        assertEquals(false, response.GetIsValid());
        assertEquals("Invalid Username", response.GetErrorMessage());
        assertEquals("", response.getUsername());
        assertEquals(-1, response.getPlayerId());
    }

    // Scenario 1.2: Username Input Test – Too Long
    @Test
    public void PlayerController_RegisterPlayer_UsernameLong() {
        String username = "Immunotherapeutically";
        String password = "tenchars00";

        RegisterPlayerRequest request = new RegisterPlayerRequest(username, password);
        PlayerResponse response = PlayerController.registerPlayer(request);

        // now we test the reponse
        assertEquals(false, response.GetIsValid());
        assertEquals("Invalid Username", response.GetErrorMessage());
        assertEquals("", response.getUsername());
        assertEquals(-1, response.getPlayerId());
    }

    // Scenario 1.3: Username Input Test – Invalid characters
    @Test
    public void PlayerController_RegisterPlayer_UsernameInvalidChar() {
        String username = "Rainbow!!!!!";
        String password = "tenchars00";

        RegisterPlayerRequest request = new RegisterPlayerRequest(username, password);
        PlayerResponse response = PlayerController.registerPlayer(request);

        // now we test the reponse
        assertEquals(false, response.GetIsValid());
        assertEquals("Invalid Username", response.GetErrorMessage());
        assertEquals("", response.getUsername());
        assertEquals(-1, response.getPlayerId());
    }

    // Scenario 1.4: Username Input Test – Not Unique
    @Test
    public void PlayerController_RegisterPlayer_UsernameUnique() {
        String username = "doomsmith"; // already made in playerdataaccess
        String password = "tenchars00";

        RegisterPlayerRequest request = new RegisterPlayerRequest(username, password);
        PlayerResponse response = PlayerController.registerPlayer(request);

        // now we test the reponse
        assertEquals(false, response.GetIsValid());
        assertEquals("Username is not unique", response.GetErrorMessage());
        assertEquals("", response.getUsername());
        assertEquals(-1, response.getPlayerId());
    }

    // Scenario 1.5: Password Input Test – Too Short
    @Test
    public void PlayerController_RegisterPlayer_PasswordShort() {
        String username = "username1";
        String password = "tent";

        RegisterPlayerRequest request = new RegisterPlayerRequest(username, password);
        PlayerResponse response = PlayerController.registerPlayer(request);

        // now we test the reponse
        assertEquals(false, response.GetIsValid());
        assertEquals("Invalid Password", response.GetErrorMessage());
        assertEquals("", response.getUsername());
        assertEquals(-1, response.getPlayerId());
    }

    // Scenario 1.6: Password Input Test – Too Long
    @Test
    public void PlayerController_RegisterPlayer_PasswordLong() {
        String username = "username2";
        String password = "passwordistoolong1234";

        RegisterPlayerRequest request = new RegisterPlayerRequest(username, password);
        PlayerResponse response = PlayerController.registerPlayer(request);

        // now we test the reponse
        assertEquals(false, response.GetIsValid());
        assertEquals("Invalid Password", response.GetErrorMessage());
        assertEquals("", response.getUsername());
        assertEquals(-1, response.getPlayerId());
    }

}