import Controller.OrderController;
import Controller.PlayerController;
import DataAccess.*;
import restService.request.OrderRequest;
import restService.request.RegisterPlayerRequest;
import restService.response.PlayGameResponse;
import restService.response.PlayerResponse;

public class App {
    public static void main(String[] args) throws Exception {

        initialize();

        RegisterPlayerRequest request = new RegisterPlayerRequest("validUserName", "validPassword");
        PlayerResponse response = PlayerController.registerPlayer(request);

        // OrderRequest request = new OrderRequest(1);
        // OrderResponse response = OrderController.OrderItem(request);


        System.out.println("Code is finished");
    }

    public static void initialize() {
        ItemTypeDataAccess itemTypeDataAccess = new ItemTypeDataAccess();
        RackDataAccess rackDataAccess = new RackDataAccess();
        RobotDataAccess robotDataAccess = new RobotDataAccess();
        ItemDataAccess itemDataAccess = new ItemDataAccess();

    }
   
}
