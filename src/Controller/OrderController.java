package Controller;

import java.util.ArrayList;

import DataObjects.ItemDataObject;
import DomainObjects.ItemDomainObject;
import DomainObjects.RackDomainObject;
import DomainObjects.RobotDomainObject;
import Models.ItemModel;
import Models.GameModel;
import restService.request.OrderRequest;
import restService.response.PlayGameResponse;

public class OrderController {
    // Order some item, 
    //    then retreive the list of racks that have the item,
    //    then retreive the list of available robots, 
    //    then assign the robot to the rack, 
    //    then assign the rack to the robot, 
    //    then return the appropriate OrderResponse
    public static PlayGameResponse OrderItem (OrderRequest request) {

        try {

            ItemDomainObject itemToRetreive = ItemModel.GetFirstAvailableByItemTypeId(request.GetItemTypeId());
            if (itemToRetreive == null) {
                throw new Exception ("No items to retreive.");
            }
            
            RobotDomainObject robotToAssign = GameModel.GetAvailableRobot();
            if (robotToAssign == null) {
                throw new Exception ("No robot available.");
            }

            int rackId = itemToRetreive.GetRackId();
            int robotId = robotToAssign.GetId();

            RackDomainObject rackToRetreive = itemToRetreive.GetRack();

            itemToRetreive.SetStatus(ItemDataObject.STATUS_ORDERED);
            robotToAssign.SetRack(rackId);
            rackToRetreive.SetRobot(robotId);


            PlayGameResponse response = new PlayGameResponse(request.GetItemTypeId(), rackId, robotId);
            return response;
        } catch (Exception ex) {
            PlayGameResponse response = new PlayGameResponse(ex.getMessage());
            return response; 
        }
    }
}
