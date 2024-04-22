import Controller.GameController;
import Controller.PlayerController;
import DataAccess.*;
import restService.request.*;
import restService.response.*;

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
        GameTypeDataAccess gameTypeDataAccess = new GameTypeDataAccess();
        BoardDataAccess boardDataAccess = new BoardDataAccess();
        GameDataAccess gameDataAccess = new GameDataAccess();
        PlayerDataAccess itemDataAccess = new PlayerDataAccess();

    }

}
