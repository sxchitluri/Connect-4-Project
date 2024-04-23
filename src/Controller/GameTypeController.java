package Controller;

//import java.util.ArrayList;

import DomainObjects.GameTypeDomainObject;
import Models.GameTypeModel;
import restService.request.GameTypeRequest;
import restService.response.GameTypeResponse;

public class GameTypeController {

    public static GameTypeResponse setGT(int id, String name) {
        try {

            GameTypeDomainObject domainToCreate = new GameTypeDomainObject(id, name);
            GameTypeDomainObject domainCreated = GameTypeModel.AddGameType(domainToCreate);

            GameTypeResponse response = new GameTypeResponse(domainCreated.GetId(), domainCreated.GetName());
            return response;

        } catch (Exception ex) {
            GameTypeResponse response = new GameTypeResponse(ex.getMessage());
            return response;
        }

    }

    public static GameTypeResponse setGT2(GameTypeRequest request) {
        try {

            GameTypeDomainObject domainToCreate = new GameTypeDomainObject(request);
            GameTypeDomainObject domainCreated = GameTypeModel.AddGameType(domainToCreate);

            GameTypeResponse response = new GameTypeResponse(domainCreated.GetId(), domainCreated.GetName());
            return response;

        } catch (Exception ex) {
            GameTypeResponse response = new GameTypeResponse(ex.getMessage());
            return response;
        }

    }

}
