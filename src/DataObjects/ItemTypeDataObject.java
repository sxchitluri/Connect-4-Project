package DataObjects;

import DomainObjects.ItemTypeDomainObject;

public class ItemTypeDataObject {
    
    public int id; 
    public String name; 


    public ItemTypeDataObject (int id, String name) {
        this.id = id;
        this.name = name;
    }

    //Copy Constructor
    public ItemTypeDataObject(ItemTypeDataObject itemType) {
        this.id = itemType.id;
        this.name = itemType.name;
    }   
    

    public ItemTypeDataObject (ItemTypeDomainObject itemType) {
        this.id = itemType.GetId();
        this.name = itemType.GetName();
    }
}
