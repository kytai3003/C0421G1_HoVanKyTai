package resort_management.services;

import resort_management.models.Facility;
import resort_management.models.House;
import resort_management.models.Room;
import resort_management.models.Villa;

import java.util.*;

public class FacilityServiceImpl implements FacilityService{
    static Scanner sc = new Scanner(System.in);
    private static LinkedHashMap<Facility, Integer> facilityMap = new LinkedHashMap<>();

    static {
            Villa palmVilla = new Villa("Palm villa No.01", "400", "30000000", 10, "Weekly pay", "Excellent", "30", 3);
            Villa cocoVilla = new Villa("Coconut villa No.02", "380", "35000000", 10, "Weekly pay", "Excellent", "30", 4);
            House westHouse = new House("West house No.01", "120", "15000000", 4, "Daily pay", "Standard", 2);
            House southHouse = new House("South house No.01", "100", "15000$", 4, "Annually pay", "Well", 1);
            Room room101 = new Room("Room No.101", "50", "7000000", 2, "Daily pay", "Free drinks and breakfast everyday");
            Room room102 = new Room("Room No.102", "50", "9000000", 2, "Daily pay", "Free drinks, breakfast and mudbath services");
            facilityMap.put(palmVilla, 5);
            facilityMap.put(cocoVilla, 1);
            facilityMap.put(westHouse, 5);
            facilityMap.put(southHouse, 3);
            facilityMap.put(room101, 6);
            facilityMap.put(room102, 2);
            }

    @Override
    public void addNew() {
        do {
            System.out.println("You chose Add new facility. Choose the next function: ");
            System.out.println("1) Add new villa");
            System.out.println("2) Add new house");
            System.out.println("3) Add new room");
            System.out.println("4) Back to menu");
            int addNewChoice = sc.nextInt();
            switch (addNewChoice) {
                case 1:
                    System.out.println("You chose Add new villa.");
                    Villa newVilla = new Villa();
                    addRegularProperties(newVilla);
                    System.out.println("Input room standard: ");
                    newVilla.setRoomStandard(sc.nextLine());
                    System.out.println("Input pool area: ");
                    newVilla.setPoolArea(sc.nextLine());
                    System.out.println("Input number of level(s): ");
                    newVilla.setNumberOfLevel(Integer.parseInt(sc.nextLine()));
                    facilityMap.put(newVilla, 0);
                    System.out.println("Success.");
                    break;

                case 2:
                    System.out.println("You chose Add new house.");
                    House newHouse = new House();
                    addRegularProperties(newHouse);
                    System.out.println("Input room standard: ");
                    newHouse.setRoomStandard(sc.nextLine());
                    System.out.println("Input number of level(s): ");
                    newHouse.setNumberOfLevel(Integer.parseInt(sc.nextLine()));
                    facilityMap.put(newHouse, 0);
                    System.out.println("Success.");
                    break;

                case 3:
                    System.out.println("You chose Add new room.");
                    Room newRoom = new Room();
                    addRegularProperties(newRoom);
                    System.out.println("Input free service(s): ");
                    newRoom.setFreeServices(sc.nextLine());
                    facilityMap.put(newRoom, 0);
                    System.out.println("Success.");
                    break;

                case 4:
                    return;

                default:
                    System.err.println("False input. Please retry.");
            }
        } while (true);
    }

    @Override
    public void displayList() {
        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
            System.out.println(entry.getKey() + "\n"  + "Used times: " + entry.getValue());
        }
    }

    @Override
    public void displayListMaintenance() {
        System.err.println("Facilities need to maintain: ");
        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
            if (entry.getValue() >= 5) {
                System.out.println(entry.getKey().getNameOfService() + ", used times: " + entry.getValue());
            }
        }
    }

    public void addRegularProperties(Facility f) {
        System.out.println("Input name of service: ");
        sc.nextLine();
        f.setNameOfService(sc.nextLine());
        System.out.println("Input using area: ");
        f.setUsingArea(sc.nextLine());
        System.out.println("Input price: ");
        f.setPrice(sc.nextLine());
        System.out.println("Input capacity: ");
        f.setCapacity(Integer.parseInt(sc.nextLine()));
        System.out.println("Input type of hiring: ");
        f.setTypeOfHiring(sc.nextLine());
    }

    public LinkedHashMap<Facility, Integer> getList() {
        return facilityMap;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

