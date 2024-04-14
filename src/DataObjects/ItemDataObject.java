package DataObjects;

import DomainObjects.ItemDomainObject;

public class ItemDataObject {
    public final static String STATUS_AVAILABLE = "Available";
    public final static String STATUS_ORDERED = "Ordered";


    public int id; 
    public int itemTypeId; 
    public int rackId;
    public String status; 


    public ItemDataObject (int id, int itemTypeId, int rackId, String status) {
        this.id = id;
        this.itemTypeId = itemTypeId;
        this.rackId = rackId;
        this.status = status;
    }

    //Copy Constructor
    public ItemDataObject(ItemDataObject item) {
        this.id = item.id;
        this.itemTypeId = item.itemTypeId;
        this.rackId = item.rackId;
        this.status = item.status;
    }  

    public ItemDataObject (ItemDomainObject item) {
        this.id = item.GetId();
        this.itemTypeId = item.GetItemTypeId();
        this.rackId = item.GetRackId();
        this.status = item.GetStatus();
    }
}
