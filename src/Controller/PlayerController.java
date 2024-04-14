package Controller;

import java.util.ArrayList;

// import DomainObjects.PlayerDomainObject;
// import Models.PlayerModel;
import restService.request.RegisterPlayerRequest;
import restService.response.PlayerResponse;

public class PlayerController {
    
    public static PlayerResponse registerPlayer(RegisterPlayerRequest request) {
        try {
            // PlayerDomainObject domainToCreate = new PlayerDomainObject(request.getUsername(), request.getPassword());
            // PlayerDomainObject domainCreated = PlayerModel.RegisterPlayer(domainToCreate);
            // PlayerResponse response = new PlayerResponse(domainCreated.GetId(), domainCreate.getUserName());

            return new PlayerResponse(1, request.getUsername());


        } catch (Exception ex) {
            PlayerResponse response = new PlayerResponse(ex.getMessage());
            return response;
        }
    }
}
