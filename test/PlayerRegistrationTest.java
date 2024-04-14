import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Controller.PlayerController;
import restService.request.RegisterPlayerRequest;
import restService.response.PlayerResponse;

public class PlayerRegistrationTest {

    @Test
    public void PlayerController_RegisterPlayer_SuccessTest() {
        
        String username = "username";
        String password = "password";

        //create the request to register player
        RegisterPlayerRequest request = new RegisterPlayerRequest(username, password);

        //now call the register player controller and pass in the request to the controller. Then it should return back a reponse, the player response
        PlayerResponse response = PlayerController.registerPlayer(request);

        //now we test the reponse
        assertEquals(true, response.GetIsValid());
        assertEquals(null, response.GetErrorMessage());
        assertEquals(username, response.getUsername());
        assertEquals(?, response.getPlayerId());
    }

}