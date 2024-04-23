package restService.response;

public class GameTypeResponse {

    private final boolean isValid;
    private final String errorMessage;
    private final int id;
    private final String name;

    public GameTypeResponse(int id, String name) {
        this.isValid = true;
        this.errorMessage = null;
        this.id = id;
        this.name = name;
    }

    // this method is if request inputs are not valid (which the game model tests)
    public GameTypeResponse(String errorMessage) {
        this.isValid = false;
        this.errorMessage = errorMessage;
        this.id = -1;
        this.name = "";
    }

    // GET methods

    public int GetId() {
        return this.id;
    }

    public String GetName() {
        return this.name;
    }
}
