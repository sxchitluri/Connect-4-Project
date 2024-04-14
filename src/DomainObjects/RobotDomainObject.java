package DomainObjects;

import java.util.ArrayList;

import DataObjects.RobotDataObject;
import Models.RackModel;
import Models.GameModel;

public class RobotDomainObject {
    
    private int id;
    private String name;
    private int rackId;

    private RackDomainObject rack; 

    public RobotDomainObject (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public RobotDomainObject (RobotDataObject robot) {
        this.id = robot.id;
        this.name = robot.name;
    }

    public static ArrayList<RobotDomainObject> MapList(ArrayList<RobotDataObject> robotdata) {
        ArrayList<RobotDomainObject> robotDomain = new ArrayList<RobotDomainObject>();
        for(RobotDataObject robot : robotdata) {
            robotDomain.add(new RobotDomainObject(robot));
        }
        return robotDomain;
    }

    public int GetId() {
        return this.id;
    }

    public String GetName() {
        return this.name;
    }

    public int GetRackId() {
        return this.rackId;
    }


    public RackDomainObject GetRack() {
        //Lazy Load the Rack
        if (this.rack == null) {
            this.rack = RackModel.GetRackById(rackId);
        }
        return this.rack;
    }

    public void SetRack(int rackId) {
        this.rackId = rackId;
        GameModel.Save(this);
    }


}