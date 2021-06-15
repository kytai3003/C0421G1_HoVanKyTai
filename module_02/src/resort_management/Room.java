package resort_management;

public class Room extends House{

    //Riêng Phòng sẽ có thêm thông tin: Dịch vụ miễn phí đi kèm.

    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String serviceName, double usingArea, double hireCharge, double maxOfPeople, String typeOfHiring, String standardOfRoom, double poolArea, int numberOfLevel, String otherConvenience, String freeService) {
        super(serviceName, usingArea, hireCharge, maxOfPeople, typeOfHiring, standardOfRoom, poolArea, numberOfLevel, otherConvenience);
        this.freeService = freeService;
    }

    public Room(String standardOfRoom, double poolArea, int numberOfLevel, String otherConvenience, String freeService) {
        super(standardOfRoom, poolArea, numberOfLevel, otherConvenience);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeService='" + freeService + '\'' +
                '}';
    }
}
