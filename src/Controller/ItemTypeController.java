package Controller;

import java.util.ArrayList;

import DomainObjects.ItemTypeDomainObject;
import Models.ItemTypeModel;
import restService.response.ItemTypeResponse;

public class ItemTypeController {

    public static ArrayList<ItemTypeResponse> getAllItemTypes () {
        //NOTE: This Method has not been explained in class yet.

        ArrayList<ItemTypeDomainObject> domainList = ItemTypeModel.GetAllItemTypes();
        ArrayList<ItemTypeResponse> responseList  = new ArrayList<ItemTypeResponse>();
       
        return responseList;

    }





}