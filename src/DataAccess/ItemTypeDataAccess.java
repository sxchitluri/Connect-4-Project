package DataAccess;

import java.util.ArrayList;
import DataObjects.ItemTypeDataObject;

public class ItemTypeDataAccess {

    private static ArrayList<ItemTypeDataObject> itemTypes = new ArrayList<ItemTypeDataObject>();
    private static int nextId = 0;  

    public ItemTypeDataAccess() {
        initialize();
    }

    private void initialize() {
        itemTypes.add(new ItemTypeDataObject(0, "Thumb Drive"));
        itemTypes.add(new ItemTypeDataObject(1, "Mouse"));
        nextId = 2;

    }

    private static int getNextId() {
        int thisId = nextId;
        nextId++;
        return thisId;
    }

    public static ArrayList<ItemTypeDataObject> GetAllItemTypes() {
        ArrayList<ItemTypeDataObject> itemTypesList = new ArrayList<ItemTypeDataObject>();
        //Create a copy of itemTypes to return.
        for (ItemTypeDataObject itemType: itemTypes) {
            itemTypesList.add(new ItemTypeDataObject(itemType));
        }
        return itemTypesList;
    }

    public static ItemTypeDataObject GetItemTypeById(int id) {
        for( ItemTypeDataObject itemType : itemTypes) {
            if (itemType.id == id) {
                return new ItemTypeDataObject(itemType);
            }
        }
        return null;
    }

    public static ItemTypeDataObject AddItemType(ItemTypeDataObject newItemType) {
        newItemType.id = getNextId(); 
        itemTypes.add(newItemType);
        return newItemType;
    }

}
