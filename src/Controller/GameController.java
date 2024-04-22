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

    // GETTING GAME DETAILS - making sure game exists??? [STORY 2]
    // request is getgamedetailsrequest.java
    // reponse is gameresponse.java
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

    // MAKING MOVES - STORY 4,
    // request is playgamerequest.java
    // reponse is gameresponse.java
    // test is playgametest.java
    public static GameResponse PlayGame(PlayGameRequest request) {

        try {

            GameDomainObject domainCreated = GameModel.playGame(request.GetGameId(), request.GetPlayerId(),
                    request.GetColumn());

            GameResponse response = new GameResponse(domainCreated.GetGameId(), domainCreated.GetPlayer1Id(),
                    domainCreated.GetPlayer2Id(), domainCreated.GetStatus(), domainCreated.GetCurrentTurnPlayer(),
                    domainCreated.GetWinnerId(), domainCreated.GetBoard());

            return response;
        } catch (Exception ex) {
            GameResponse response = new GameResponse(ex.getMessage());
            return response;
        }
    }

    // MAKING MOVES - STORY 3,
    // request is request.java
    // reponse is gameresponse.java
    public static GameResponse CreateGame(PlayGameRequest request) {

        try {
            
        }
    }

}
