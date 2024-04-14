package DataObjects;

import DomainObjects.RobotDomainObject;

public class RobotDataObject {
    
    public int id;
    public String name;

    public int rackId = -1; 

    public RobotDataObject (int id, String name) {
        this.id = id;
        this.name = name;
    }

    //Copy Constructor
    public RobotDataObject(RobotDataObject robot) {
        this.id = robot.id;
        this.name = robot.name;
        this.rackId = robot.rackId;
    }    

    public RobotDataObject (RobotDomainObject robot) {
        this.id = robot.GetId();
        this.name = robot.GetName();
        this.rackId = robot.GetRackId();
    }




}
