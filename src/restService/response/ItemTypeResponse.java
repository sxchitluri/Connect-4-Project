package restService.response;

import DomainObjects.ItemTypeDomainObject;

public class ItemTypeResponse {
    

    private final int id; 
    private final String name; 
    
    
    public ItemTypeResponse (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ItemTypeResponse (ItemTypeDomainObject domain) {
        this.id = domain.GetId();
        this.name = domain.GetName();
    }

    public int GetId() {
        return this.id;
    }

    public String GetName() {
        return this.name;
    }

}





