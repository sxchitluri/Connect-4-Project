package Models;

import java.util.ArrayList;

import DataAccess.ItemDataAccess;
import DataObjects.ItemDataObject;
import DomainObjects.ItemDomainObject;

public class ItemModel {

    public static ItemDomainObject GetItemById(int id) {
        ItemDataObject itemData = ItemDataAccess.GetItemById(id);
        return new ItemDomainObject(itemData);
    }

    public static ItemDomainObject GetFirstAvailableByItemTypeId(int itemTypeId) {
        ItemDataObject itemData = ItemDataAccess.GetFirstAvailableByItemTypeId(itemTypeId);
        
        if (itemData == null) {
            return null;
        }

        return new ItemDomainObject(itemData);
    }

    public static ArrayList<ItemDomainObject> GetAllItems() {
        ArrayList<ItemDataObject> itemDataList = ItemDataAccess.GetAllItems();
        return ItemDomainObject.MapList(itemDataList);
    }

    public static ArrayList<ItemDomainObject> GetItemsByItemTypeId(int id) {
        ArrayList<ItemDataObject> itemDataList = ItemDataAccess.GetItemsByItemTypeId(id );
        return ItemDomainObject.MapList(itemDataList);
    }

    public static ItemDomainObject AddItem(ItemDomainObject item){

        validateItem(item);

        ItemDataObject itemData = new ItemDataObject(item);
        ItemDataAccess.AddItem(itemData);
        return new ItemDomainObject(itemData);
  
    }
    

    private static void validateItem(ItemDomainObject item) {

    }


    public static void Save (ItemDomainObject itemToSave) {
        ItemDataObject itemDataObject = new ItemDataObject(itemToSave);
        ItemDataAccess.Save(itemDataObject);
    }
  


}
