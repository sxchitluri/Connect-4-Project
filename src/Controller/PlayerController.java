package Controller;

import java.util.ArrayList;

import DomainObjects.PlayerDomainObject;
import Models.PlayerModel;
import restService.request.RegisterPlayerRequest;
import restService.request.GetPlayerDetailsRequest;
import restService.response.PlayerResponse;

public class PlayerController {

    // CREATING NEW PLAYER - Story 1
    // request is registerplayerrequest.java
    // reponse is playerreponse.java
    // test is playerregistrationtest.java
    public static PlayerResponse registerPlayer(RegisterPlayerRequest request) {
        try {
            /*
            PlayerDomainObject domainToCreate = new
            PlayerDomainObject(request.getUsername(), request.getPassword());
            PlayerDomainObject domainCreated = PlayerModel.RegisterPlayer(domainToCreate);
            PlayerResponse response = new PlayerResponse(domainCreated.GetId(), domainCreate.getUserName());
            */

            PlayerDomainObject domainToCreate = new PlayerDomainObject(request);
            PlayerDomainObject domainCreated = PlayerModel.RegisterPlayer(domainToCreate); // is this supposed to be add player method????

            PlayerResponse response = new PlayerResponse(domainCreated.GetId(), domainCreated.GetUsername());
            return response;
            // then save the player to the player array list

        } catch (Exception ex) {
            PlayerResponse response = new PlayerResponse(ex.getMessage());
            return response;
        }
    }

    // GETTING PLAYER DETAILS - STORY 6 - also edit PlayerResponse.java
    // request is getplayerdetailsrequest.java
    // reponse is playerreponse.java
    // test is ___.java
    public static PlayerResponse GetPlayerDetails(GetPlayerDetailsRequest request) {

        try {

            // validate request details in playermodel.validateplayer method, only getting
            // the playerId for the request, so only validating the playerId

            if (id = playerid) {
                return new PlayerResponse(1, request.getUsername(), request.getGamesPlayed(), request.getGamesWon(),
                        request.getGamesLost());
            }

            return null;
        } catch (Exception ex) {
            PlayerResponse response = new PlayerResponse(ex.getMessage()); // cannot find x player id details
            return response;
        }
    }
}
