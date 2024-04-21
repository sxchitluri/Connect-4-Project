import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Controller.GameController;
import restService.request.PlayGameRequest;
import restService.response.GameResponse;

public class PlayGameTest {

    @Test
    public void GameController_PlayGame_SuccessTest() {
        
        int gameId = 1;
        int playerId = 1;
        int column = 3;

        //create the request to play game
        PlayGameRequest request = new PlayGameRequest(gameId, playerId, column);

        //now call the game controller and pass in the request to the controller. Then it should return back a reponse, the player response
        GameResponse response = GameController.PlayGame(request);

        //now we test the reponse
        assertEquals(true, response.GetIsValid());
        assertEquals(null, response.GetErrorMessage());
        // how to test playerId and Column?????
        assertEquals(username, response.getUsername());
        assertEquals(?, response.getPlayerId());
    }

}
