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

    @Test
    public void testGameWithInvalidId() {
        GameResponse response = GameController.GetGame(943);  // Non-existing ID
        assertEquals(false, response.GetIsValid());
        assertEquals("Invalid GameId.", response.GetErrorMessage());
    }

    @Test
    /*public void testGamePlayNoWin() {
        CreateGameRequest createRequest = new CreateGameRequest(1, 2, 0);
        GameResponse response = GameController.CreateGame(createRequest);
    
        // Now reuse the same 'response' variable for the next call
        response = GameController.PlayGame(new PlayGameRequest(251, 1, 3));  // Valid move
    
        assertEquals(true, response.GetIsValid());
        assertNull(response.GetErrorMessage());
        assertEquals("Playing", response.GetStatus());
        assertEquals(0, response.GetWinnerId());
    }*/

    public void testGamePlayNoWin() {
        // Create a game request
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

}
