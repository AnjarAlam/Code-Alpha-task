import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Room {
    int roomNumber;
    String roomType;
    double price;
    boolean isAvailable;

    Room(int roomNumber, String roomType, double price, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public String toString() {
        return "Room " + roomNumber + " (" + roomType + ") - Rs. " + price + (isAvailable ? " [Available]" : " [Booked]");
    }
}

class Booking {
    String customerName;
    int age;
    Room r;
    double paidAmount;

    Booking(String customerName, int age, Room r, double paidAmount) {
        this.customerName = customerName;
        this.age = age;
        this.r = r;
        this.paidAmount = paidAmount;
    }
    public void viewBookingDetails() {
        System.out.println("Name: " + customerName);
        System.out.println("Age: " + age);
        System.out.println("Room Number: " + r.roomNumber);
        System.out.println("Room Type: " + r.roomType);
        System.out.println("Paid Amount: Rs. " + paidAmount);
        System.out.println("Price: Rs. " + r.price);
        System.out.println("Change Returned: Rs. " + (paidAmount - r.price));
    }
}

class Hotel_Management_System {
    List<Room> rooms = new ArrayList<>();
    List<Booking> bookings = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    Hotel_Management_System() {
        // Initialize hotel with some rooms
        rooms.add(new Room(101, "Single", 500, true));
        rooms.add(new Room(102, "Family", 1500, true));
        rooms.add(new Room(103, "Luxury", 5000, true));
        rooms.add(new Room(104, "Single", 500, false));
        rooms.add(new Room(105, "Family", 1500, true));
    }

    public void searchAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room r : rooms) {
            if (r.isAvailable) {
                System.out.println(r);
            }
        }
    }

    public void reserveRoom() {
        searchAvailableRooms();
        System.out.println("Enter the room number you want to book: ");
        int roomNumber = sc.nextInt();
        Room selectedRoom = null;

        for (Room r : rooms) {
            if (r.roomNumber == roomNumber && r.isAvailable) {
                selectedRoom = r;
                break;
            }
        }

        if (selectedRoom != null) {
            System.out.println("Room is available. Proceeding with reservation...");
            System.out.println("Enter Your Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.println("Enter Your Age: ");
            int age = sc.nextInt();

            System.out.println("The price for the room is Rs. " + selectedRoom.price);
            System.out.println("Please deposit the amount: ");
            double paidAmount = sc.nextDouble();

            while (paidAmount < selectedRoom.price) {
                System.out.println("Insufficient amount. Please deposit at least Rs. " + selectedRoom.price);
                paidAmount = sc.nextDouble();
            }

            selectedRoom.isAvailable = false;

            // Create booking
            Booking booking = new Booking(name, age, selectedRoom, paidAmount);
            bookings.add(booking);

            System.out.println("Reservation successful!");
            System.out.println("Your room number is " + selectedRoom.roomNumber);

            System.out.println("Do you want to view your booking details? Enter 1 for YES or 0 for NO:");
            int view = sc.nextInt();
            if (view == 1) {
                booking.viewBookingDetails();
            }

        } else {
            System.out.println("Sorry, the room is not available or invalid room number.");
        }
    }

    public void viewAllBookings() {
        System.out.println("All Bookings:");
        for (Booking booking : bookings) {
            System.out.println("Booking for " + booking.customerName + " in Room " + booking.r.roomNumber);
        }
    }
}


public class Hotal_management_system {
    public static void main(String[] args) {
        Hotel_Management_System h = new Hotel_Management_System();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        
        while (running) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. Search for Available Rooms");
            System.out.println("2. Reserve a Room");
            System.out.println("3. View All Bookings");
            System.out.println("0. Exit");

            System.out.print("Choose an option: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    h.searchAvailableRooms();
                    break;
                case 2:
                    h.reserveRoom();
                    break;
                case 3:
                    h.viewAllBookings();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }   
    }
}