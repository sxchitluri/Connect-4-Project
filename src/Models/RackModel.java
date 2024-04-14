package Models;

import java.util.ArrayList;

import DataAccess.RackDataAccess;
import DataObjects.RackDataObject;
import DomainObjects.RackDomainObject;

public class RackModel {

    public static RackDomainObject GetRackById(int id) {
        RackDataObject rackData = RackDataAccess.GetRackById(id);
        return new RackDomainObject(rackData);
    }

    public static ArrayList<RackDomainObject> GetAllRacks() {
        ArrayList<RackDataObject> rackDataList = RackDataAccess.GetAllRacks();
        return RackDomainObject.MapList(rackDataList);
    }

    public static RackDomainObject AddRack(RackDomainObject rack){

        validateRack(rack);

        RackDataObject rackData = new RackDataObject(rack);
        RackDataAccess.AddRack(rackData);
        return new RackDomainObject(rackData);
  
    }
    

    private static void validateRack(RackDomainObject rack) {

    }

    public static void Save (RackDomainObject rackToSave) {
        RackDataObject rackDataObject = new RackDataObject(rackToSave);
        RackDataAccess.Save(rackDataObject);
    }
}
