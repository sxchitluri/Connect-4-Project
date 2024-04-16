package Controller;

import java.util.ArrayList;

import restService.request.GetPlayerDetailsRequest;
// import DomainObjects.PlayerDomainObject;
// import Models.PlayerModel;
import restService.request.RegisterPlayerRequest;
import restService.response.PlayerResponse;

public class PlayerController {
    
    //CREATING NEW PLAYER
    public static PlayerResponse registerPlayer(RegisterPlayerRequest request) {
        try {
            // PlayerDomainObject domainToCreate = new PlayerDomainObject(request.getUsername(), request.getPassword());
            // PlayerDomainObject domainCreated = PlayerModel.RegisterPlayer(domainToCreate);
            // PlayerResponse response = new PlayerResponse(domainCreated.GetId(), domainCreate.getUserName());

            return new PlayerResponse(1, request.getUsername());
            //then save the player to the player array list

        } catch (Exception ex) {
            PlayerResponse response = new PlayerResponse(ex.getMessage());
            return response;
        }
    }

    //GETTING PLAYER DETAILS - STORY 6 - also edit PlayerResponse.java
    public static PlayerResponse GetPlayerDetails(GetPlayerDetailsRequest request) {

        try {
            if (id = playerid) {
             return new PlayerResponse(1, request.getUsername(), request.getGamesPlayed(), request.getGamesWon(), request.getGamesLost() );   
            }
            
            return null;
        } catch (Exception ex) {
            PlayerResponse response = new PlayerResponse(ex.getMessage()); //cannot find x player id details
            return response;
        }
    }
}
