package DomainObjects;

import java.util.ArrayList;

import DataObjects.ItemTypeDataObject;

public class ItemTypeDomainObject {
    
    private int id; 
    private String name; 


    public ItemTypeDomainObject (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ItemTypeDomainObject (ItemTypeDataObject itemType) {
        this.id = itemType.id;
        this.name = itemType.name;
    }

    public static ArrayList<ItemTypeDomainObject> MapList(ArrayList<ItemTypeDataObject> itemTypedata) {
        ArrayList<ItemTypeDomainObject> itemTypeDomain = new ArrayList<ItemTypeDomainObject>();
        for(ItemTypeDataObject itemType : itemTypedata) {
            itemTypeDomain.add(new ItemTypeDomainObject(itemType));
        }
        return itemTypeDomain;
    }


    public int GetId() {
        return this.id;
    }

    public String GetName() {
        return this.name;
    }


}
