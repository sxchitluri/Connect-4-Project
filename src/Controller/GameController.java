package Controller;

import DomainObjects.GameDomainObject;
import Models.GameModel;
import restService.request.CreateGameRequest;
import restService.request.GetGameDetailsRequest;
import restService.request.PlayGameRequest;
import restService.response.GameResponse;

public class GameController {

    // GETTING GAME DETAILS - STORY 2
    // request is getgamedetailsrequest.java
    // reponse is gameresponse.java

    public static GameResponse getGameDetails(GetGameDetailsRequest gameId) {
        System.out.println("GameController: Fetching details for game ID " + gameId.GetGameId());
        try {
            GameDomainObject game = GameModel.GetGameById(gameId.GetGameId());
            if (game == null) {
                System.out.println("GameController: No game found with ID " + gameId.GetGameId());
                return new GameResponse("Invalid GameId.");
            }
            System.out.println("GameController: Game details retrieved successfully for ID " + gameId.GetGameId());
            return new GameResponse(game.GetGameId(), game.GetGameTypeId(), game.GetPlayer1Id(), game.GetPlayer2Id(),
                    game.GetStatus(), game.GetCurrentTurnPlayer(), game.GetWinnerId(), game.GetBoard().GetOccupancy());
        } catch (Exception ex) {
            System.out.println("GameController: Exception in getGameDetails - " + ex.getMessage());
            return new GameResponse(ex.getMessage());
        }
    }

    public static GameResponse GetGame(int gameId) {
        try {
            GameDomainObject game = GameModel.GetGameById(gameId);
            if (game == null) {
                return new GameResponse("Invalid GameId.");
            }
            return new GameResponse(game.GetGameId(), game.GetGameTypeId(), game.GetPlayer1Id(), game.GetPlayer2Id(),
                    game.GetStatus(), game.GetCurrentTurnPlayer(), game.GetWinnerId(), game.GetBoard().GetOccupancy());
        } catch (Exception ex) {
            return new GameResponse(ex.getMessage());
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
    public static GameResponse CreateGame(CreateGameRequest request) {

        try {

            GameDomainObject domainCreated = GameModel.createGame(request.GetPlayer1Id(), request.GetPlayer2Id(),
                    request.GetGameTypeId());

            GameResponse response = new GameResponse(domainCreated.GetGameId(), domainCreated.GetGameTypeId(),
                    domainCreated.GetPlayer1Id(),
                    domainCreated.GetPlayer2Id(), domainCreated.GetStatus(), domainCreated.GetCurrentTurnPlayer(),
                    domainCreated.GetWinnerId(), domainCreated.GetBoard().GetOccupancy());
            return response;

        } catch (Exception ex) {
            GameResponse response = new GameResponse(ex.getMessage());
            return response;
        }
    }

}
