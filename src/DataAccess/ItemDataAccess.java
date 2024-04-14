package DataAccess;

import java.util.ArrayList;
import DataObjects.ItemDataObject;

public class ItemDataAccess {

    private static ArrayList<ItemDataObject> items = new ArrayList<ItemDataObject>();
    private static int nextId = 0;  

    public ItemDataAccess() {
        initialize();
    }

    private void initialize() {
        items.add(new ItemDataObject(0, 0, 0, ItemDataObject.STATUS_AVAILABLE));
        items.add(new ItemDataObject(1, 1, 1, ItemDataObject.STATUS_AVAILABLE));
        items.add(new ItemDataObject(2, 1, 0, ItemDataObject.STATUS_AVAILABLE));
        nextId = 3;
    }
    
    private static int getNextId() {
        int thisId = nextId;
        nextId++;
        return thisId;
    }

    public static ArrayList<ItemDataObject> GetAllItems() {
        ArrayList<ItemDataObject> itemsList = new ArrayList<ItemDataObject>();
        //Create a copy of itemTypes to return.
        for (ItemDataObject item: items) {
            itemsList.add(new ItemDataObject(item));
        }
        return itemsList;
    }

    public static ItemDataObject GetItemById(int id) {
        for( ItemDataObject item : items) {
            if (item.id == id) {
                return new ItemDataObject(item);
            }
        }
        return null;
    }

    public static ItemDataObject GetFirstAvailableByItemTypeId(int itemTypeId) {
        for( ItemDataObject item : items) {
            if (item.itemTypeId == itemTypeId && item.status.equals(ItemDataObject.STATUS_AVAILABLE)) {
                return new ItemDataObject(item);
            }
        }
        return null;
    }


    public static ArrayList<ItemDataObject> GetItemsByItemTypeId(int itemTypeId) {
        ArrayList<ItemDataObject> itemsById = new ArrayList<ItemDataObject>();

        for( ItemDataObject item : items) {
            if (item.itemTypeId == itemTypeId) {
                itemsById.add(new ItemDataObject(item));
            }
        }
        return itemsById;
    }

    public static ItemDataObject AddItem(ItemDataObject newItem) {
        newItem.id = getNextId(); 
        items.add(newItem);
        return newItem;
    }


    public static void Save(ItemDataObject itemToSave) {
        for( ItemDataObject item : items) {
            if (item.id == itemToSave.id) {
                item.itemTypeId = itemToSave.itemTypeId;
                item.rackId = itemToSave.rackId;
                item.status = itemToSave.status;
            }
        }
    }

}
