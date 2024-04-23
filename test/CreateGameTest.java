import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Test;

import Controller.GameController;
import restService.request.CreateGameRequest;
import restService.response.GameResponse;

public class CreateGameTest {

    @Test
    public void testCreateGame_InvalidPlayer1Id_Failure() {
        // Test game creation with an invalid player1 ID
        CreateGameRequest request = new CreateGameRequest(9, 2, 1); // Assuming 9 is invalid
        GameResponse response = GameController.CreateGame(request);

        assertEquals("Invalid player1 ID", response.GetErrorMessage());
    }

    @Test
    public void testCreateGame_InvalidPlayer2Id_Failure() {
        // Test game creation with a valid player1 ID and an invalid player2 ID
        CreateGameRequest request = new CreateGameRequest(1, 14, 1); // Assuming 1 is valid and 14 is invalid
        GameResponse response = GameController.CreateGame(request);

        // Check for the expected error message
        assertEquals("Invalid player2 ID", response.GetErrorMessage());
    }

    @Test
    public void testCreateGame_InvalidGameTypeId_Failure() {
        // Assume player IDs 1 and 2 are valid, and game type ID 77 is invalid
        CreateGameRequest request = new CreateGameRequest(1, 2, 77);
        GameResponse response = GameController.CreateGame(request);

        // Check for the expected error message
        assertEquals("Invalid gameTypeId", response.GetErrorMessage());
    }

    @Test
    public void testCreateGame_AllInputsValid_Success() {
        // Test game creation with valid player IDs and game type ID
        CreateGameRequest request = new CreateGameRequest(1, 2, 1);  // Assuming these IDs are valid
        GameResponse response = GameController.CreateGame(request);

        // Check for a successful game creation
        assertTrue(response.GetIsValid());
        assertNull(response.GetErrorMessage());
        assertEquals(145, response.GetGameId());
        assertEquals(1, response.GetGameTypeId());
        assertEquals(1, response.GetPlayer1Id());
        assertEquals(2, response.GetPlayer2Id());
        assertEquals(2, response.GetCurrentTurnPlayer());
        assertEquals("Playing", response.GetStatus());
        assertEquals(0, response.GetWinnerId());
        assertNotNull(response.GetBoard());
        assertEquals("Initial Board State", response.GetBoard());
    }


}
