package DomainObjects;

import java.util.ArrayList;

import DataObjects.RackDataObject;
import Models.ItemModel;
import Models.RackModel;
import Models.GameModel;

public class RackDomainObject {
    
    private int id; 
    private String name; 
    private int robotId;             // <---- How is this being set?

    private RobotDomainObject robot;

    public RackDomainObject (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public RackDomainObject (RackDataObject rack) {
        this.id = rack.id;
        this.name = rack.name;
    }

    public static ArrayList<RackDomainObject> MapList(ArrayList<RackDataObject> rackdata) {
        ArrayList<RackDomainObject> rackDomain = new ArrayList<RackDomainObject>();
        for(RackDataObject rack : rackdata) {
            rackDomain.add(new RackDomainObject(rack));
        }
        return rackDomain;
    }

    public int GetId() {
        return this.id;
    }

    public String GetName() {
        return this.name;
    }

    public int GetRobotId() {
        return this.robotId;
    }


    public RobotDomainObject GetRobot() {
        //Lazy Load the Robot
        if (this.robot == null) {
            this.robot = GameModel.GetRobotById(robotId);
        }
        return this.robot;
    }

    public void SetRobot(int robotId) {
        this.robotId = robotId;
        RackModel.Save(this);
    }

}
