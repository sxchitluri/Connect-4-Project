import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Controller.GameController;
import restService.request.PlayGameRequest;
import restService.response.GameResponse;

public class PlayGameTest {

    // testing valid inputs
    @Test
    public void GameController_PlayGame_SuccessTest() {
        
        int gameId = 251;
        int playerId = 1;
        int column = 3;

        //create the request to play game
        PlayGameRequest request = new PlayGameRequest(gameId, playerId, column);

        //now call the game controller and pass in the request to the controller. Then it should return back a reponse, the player response
        GameResponse response = GameController.PlayGame(request);

        //now we test the reponse
        assertEquals(true, response.GetIsValid());
        assertEquals(null, response.GetErrorMessage());
        assertEquals(251, response.GetGameId());
        assertEquals(2, response.GetCurrentTurnPlayer()); //current turn player should change to 2 once 1 's play works'
        
        assertEquals(1, response.GetPlayer1Id()); 
        assertEquals(2, response.GetPlayer2Id()); 
        assertEquals("playing", response.GetStatus()); 
        assertEquals(-1, response.GetWinnerId()); 
        assertEquals(???, response.GetBoard()); 
    }

    // testing invalild inputs
    // column tests
    @Test
    public void GameController_PlayGame_ColumnRange() {

    }

    @Test
    public void GameController_PlayGame_ColumnNum() {

    }

    @Test
    public void GameController_PlayGame_ColumnAvail() {

    }

    // game id test
    @Test
    public void GameController_PlayGame_GameIdExist() {

    }

    // player id tests
    @Test
    public void GameController_PlayGame_PlayerIdExist() {

    }

    @Test
    public void GameController_PlayGame_PlayerIdinGame() {

    }

    @Test
    public void GameController_PlayGame_PlayerIdCurrentTurn() {

    }

    // status test
    @Test
    public void GameController_PlayGame_StatusGame() {

    }

}
