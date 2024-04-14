package DataAccess;

import java.util.ArrayList;
import DataObjects.RackDataObject;

public class RackDataAccess {

    private static ArrayList<RackDataObject> racks = new ArrayList<RackDataObject>();
    private static int nextId = 0;  

    public RackDataAccess() {
        initialize();
    }

    private void initialize() {
        racks.add(new RackDataObject(0, "A"));
        racks.add(new RackDataObject(1, "B"));
        nextId = 2;

    }

    private static int getNextId() {
        int thisId = nextId;
        nextId++;
        return thisId;
    }

    public static ArrayList<RackDataObject> GetAllRacks() {
        ArrayList<RackDataObject> racksList = new ArrayList<RackDataObject>();
        //Create a copy of racks to return.
        for (RackDataObject rack: racks) {
            racksList.add(new RackDataObject(rack));
        }
        return racksList;
    }

    public static RackDataObject GetRackById(int id) {
        for( RackDataObject rack : racks) {
            if (rack.id == id) {
                return new RackDataObject(rack);
            }
        }
        return null;
    }

    public static RackDataObject AddRack(RackDataObject newRack) {
        newRack.id = getNextId(); 
        racks.add(newRack);
        return newRack;
    }

    public static void Save(RackDataObject rackToSave) {
        for( RackDataObject rack : racks) {
            if (rack.id == rackToSave.id) {
                rack.name = rackToSave.name;
                rack.robotId = rackToSave.robotId;
            }
        }
    }

}
