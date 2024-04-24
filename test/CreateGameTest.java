import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Test;

import Controller.GameController;
import Controller.GameTypeController;
import Controller.PlayerController;
import restService.request.CreateGameRequest;
import restService.request.GameTypeRequest;
import restService.request.RegisterPlayerRequest;
import restService.response.GameResponse;
import restService.response.GameTypeResponse;
import restService.response.PlayerResponse;

public class CreateGameTest {

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

    // Scenario 3.1: player1id does not exist - input not found
    @Test
    public void testCreateGame_InvalidPlayer1Id_Failure() {
        // Test game creation with an invalid player1 ID
        CreateGameRequest request = new CreateGameRequest(9, 2, 1); // Assuming 9 is invalid
        GameResponse response = GameController.CreateGame(request);

        assertEquals("Invalid player1 ID", response.GetErrorMessage());
    }

    // Scenario 3.2: player2id does not exist - input not found
    @Test
    public void testCreateGame_InvalidPlayer2Id_Failure() {
        // Test game creation with a valid player1 ID and an invalid player2 ID
        CreateGameRequest request = new CreateGameRequest(1, 14, 1); // Assuming 1 is valid and 14 is invalid
        GameResponse response = GameController.CreateGame(request);

        // Check for the expected error message
        assertEquals("Invalid player2 ID", response.GetErrorMessage());
    }

    // Scenario 3.3: gametypeid does not exist - input not found
    @Test
    public void testCreateGame_InvalidGameTypeId_Failure() {
        // Assume player IDs 1 and 2 are valid, and game type ID 77 is invalid
        CreateGameRequest request = new CreateGameRequest(1, 2, 77);
        GameResponse response = GameController.CreateGame(request);

        // Check for the expected error message
        assertEquals("Invalid gameTypeId", response.GetErrorMessage());
    }

    // Scenario 3.4: player1id, player2id, gametypeid all exist - input founds
    @Test
    public void testCreateGame_AllInputsValid_Success() {
        // Test game creation with valid player IDs and game type ID
        CreateGameRequest request = new CreateGameRequest(1, 2, 0); // Assuming these IDs are valid
        GameResponse response = GameController.CreateGame(request);

        // Check for a successful game creation
        assertEquals(true, response.GetIsValid());
        assertNull(response.GetErrorMessage());
        assertEquals(1, response.GetGameId());
        assertEquals(0, response.GetGameTypeId());
        assertEquals(1, response.GetPlayer1Id());
        assertEquals(2, response.GetPlayer2Id());
        assertEquals(2, response.GetCurrentTurnPlayer());
        assertEquals("Playing", response.GetStatus());
        assertEquals(0, response.GetWinnerId());
        assertNotNull(response.GetBoard());
        assertEquals("Initial Board State", response.GetBoard());
    }

}
