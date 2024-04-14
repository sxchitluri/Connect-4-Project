package DataObjects;

import DomainObjects.RackDomainObject;

public class RackDataObject {
    
    public int id; 
    public String name; 

    public int robotId = -1;

    public RackDataObject (int id, String name) {
        this.id = id;
        this.name = name;
        //this.robotId = -1;  This is being handled in the initializer above.
    }

    //Copy Constructor
    public RackDataObject(RackDataObject rack) {
        this.id = rack.id;
        this.name = rack.name;
        this.robotId = rack.robotId;
    }   

    public RackDataObject (RackDomainObject rack) {
        this.id = rack.GetId();
        this.name = rack.GetName();
        this.robotId = rack.GetRobotId();
    }
 
}
