package Models;

import java.util.ArrayList;

import DataAccess.ItemTypeDataAccess;
import DataObjects.ItemTypeDataObject;
import DomainObjects.ItemTypeDomainObject;


public class ItemTypeModel {
    public static ItemTypeDomainObject GetItemTypeById(int id) {
        ItemTypeDataObject itemTypeData = ItemTypeDataAccess.GetItemTypeById(id);
        return new ItemTypeDomainObject(itemTypeData);
    }

    public static ArrayList<ItemTypeDomainObject> GetAllItemTypes() {
        ArrayList<ItemTypeDataObject> itemTypeDataList = ItemTypeDataAccess.GetAllItemTypes();
        return ItemTypeDomainObject.MapList(itemTypeDataList);
    }

    public static ItemTypeDomainObject AddItemType(ItemTypeDomainObject itemType){

        validateItemType(itemType);

        ItemTypeDataObject itemTypeData = new ItemTypeDataObject(itemType);
        ItemTypeDataAccess.AddItemType(itemTypeData);
        return new ItemTypeDomainObject(itemTypeData);
  
    }
    

    private static void validateItemType(ItemTypeDomainObject itemType) {

    }



}
