package restService.request;

public class PlayGameRequest {
    
    private final int itemTypeId;

    public PlayGameRequest(int itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public int GetItemTypeId() {
        return this.itemTypeId;
    }
}
