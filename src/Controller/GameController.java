package Controller;

import java.util.ArrayList;

import DataObjects.PlayerDataObject;
import DomainObjects.BoardDomainObject;
import DomainObjects.PlayerDomainObject;
import DomainObjects.GameDomainObject;
import Models.BoardModel;
import Models.GameModel;
import restService.request.PlayGameRequest;
import restService.response.GameResponse;

public class GameController {
    
    //GETTING GAME DETAILS - making sure game exists??? [STORY 2]
    public static GameResponse GetGame(int gameId) {
        try {

            GameResponse response = new GameResponse(gameId, 0, 0, 0, "false", 2, -1,
                    "                                          ");
            return response;

        } catch (Exception ex) {
            GameResponse response = new GameResponse(ex.getMessage());
            return response;
        }

    }
    
    //MAKING MOVES
    public static GameResponse PlayGame(PlayGameRequest request) {

        try {
            
        }
    }

    
}
