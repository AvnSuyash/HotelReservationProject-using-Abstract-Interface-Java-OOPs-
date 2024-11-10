// Base class Room
abstract class Room {
    private int roomNumber;
    private String roomType;

    public Room(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void bookRoom() {
        System.out.println(roomType + " " + roomNumber + " has been booked.");
    }

    public void checkout() {
        System.out.println(roomType + " " + roomNumber + " has been checked out.");
    }

    public abstract void roomFeatures();
}

// StandardRoom class
class StandardRoom extends Room implements RoomService {
    public StandardRoom(int roomNumber) {
        super(roomNumber, "Standard Room");
    }

    @Override
    public void roomFeatures() {
        System.out.println("Standard amenities included.");
    }

    @Override
    public void orderRoomService() {
        System.out.println("Room service ordered for Standard Room " + getRoomNumber());
    }
}

// DeluxeRoom class
class DeluxeRoom extends Room implements RoomService, LaundryService {
    public DeluxeRoom(int roomNumber) {
        super(roomNumber, "Deluxe Room");
    }

    @Override
    public void roomFeatures() {
        System.out.println("Deluxe amenities included.");
    }

    @Override
    public void orderRoomService() {
        System.out.println("Room service ordered for Deluxe Room " + getRoomNumber());
    }

    @Override
    public void requestLaundryService() {
        System.out.println("Laundry service requested for Deluxe Room " + getRoomNumber());
    }
}

// Suite class
class Suite extends Room implements RoomService, LaundryService {
    public Suite(int roomNumber) {
        super(roomNumber, "Suite");
    }

    @Override
    public void roomFeatures() {
        System.out.println("Suite with complimentary services included.");
    }

    @Override
    public void orderRoomService() {
        System.out.println("Room service ordered for Suite " + getRoomNumber());
    }

    @Override
    public void requestLaundryService() {
        System.out.println("Laundry service requested for Suite " + getRoomNumber());
    }
}

// RoomService interface
interface RoomService {
    void orderRoomService();
}

// LaundryService interface
interface LaundryService {
    void requestLaundryService();
}

// Main class to demonstrate the hotel reservation system
public class HotelReservation {
    public static void main(String[] args) {
        Room standardRoom = new StandardRoom(101);
        Room deluxeRoom = new DeluxeRoom(102);
        Room suite = new Suite(103);

        standardRoom.bookRoom();
        standardRoom.roomFeatures();
        ((RoomService) standardRoom).orderRoomService();
        standardRoom.checkout();

        deluxeRoom.bookRoom();
        deluxeRoom.roomFeatures();
        ((RoomService) deluxeRoom).orderRoomService();
        ((LaundryService) deluxeRoom).requestLaundryService();
        deluxeRoom.checkout();

        suite.bookRoom();
        suite.roomFeatures();
        ((RoomService) suite).orderRoomService();
        ((LaundryService) suite).requestLaundryService();
        suite.checkout();
    }
}
