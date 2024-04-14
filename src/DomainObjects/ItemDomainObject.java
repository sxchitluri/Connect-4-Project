package DomainObjects;

import java.util.ArrayList;

import DataObjects.ItemDataObject;
import Models.ItemModel;
import Models.ItemTypeModel;
import Models.RackModel;

public class ItemDomainObject {
    
    private int id; 
    private int itemTypeId;
    private int rackId; 
    private String status;

    private ItemTypeDomainObject itemType; 
    private RackDomainObject rack;

    public ItemDomainObject (int id, int itemTypeId, int rackId, String status) {
        this.id = id;
        this.itemTypeId = itemTypeId;
        this.rackId = rackId;
        this.status = status;
    }

    public ItemDomainObject (ItemDataObject item) {
        this.id = item.id;
        this.itemTypeId = item.itemTypeId;
        this.rackId = item.rackId;
        this.status = item.status;
    }

    public static ArrayList<ItemDomainObject> MapList(ArrayList<ItemDataObject> itemdata) {
        ArrayList<ItemDomainObject> itemDomain = new ArrayList<ItemDomainObject>();
        for(ItemDataObject item : itemdata) {
            itemDomain.add(new ItemDomainObject(item));
        }
        return itemDomain;
    }

    public int GetId() {
        return this.id;
    }

    public int GetItemTypeId() {
        return this.itemTypeId;
    }

    public int GetRackId() {
        return this.rackId;
    }

    public String GetStatus() {
        return this.status;
    }

    public RackDomainObject GetRack() {
        //Lazy Load the Rack
        if (this.rack == null) {
            this.rack = RackModel.GetRackById(rackId);
        }
        return this.rack;
    }

    public ItemTypeDomainObject GetItemType() {
        //Lazy Load the ItemType
        if (this.itemType == null) {
            this.itemType = ItemTypeModel.GetItemTypeById(itemTypeId);
        }
        return this.itemType;
    }


    public void SetStatus(String status) {
        this.status = status;
        ItemModel.Save(this);
    }
 
}
