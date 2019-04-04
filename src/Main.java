public class Main {

    public static void main(String[] args) {
        // Parking Lot principle:
        // If small car coming, park at small spot first. Unless there is no small spot then park at large spot
        // If large car coming, park at large spot.

        ParkingLot p = new ParkingLot(2, 1, 1);
        Compact car1 = new Compact();
        Truck car2 = new Truck();
        Compact car3 = new Compact();
        Sedan car4 = new Sedan();
        Compact car5 = new Compact();
        Compact car6 = new Compact();
        p.park(car1);
        p.park(car5);
        p.park(car2);
        p.park(car6);
        p.park(car4);

        p.carLeaves(car1);
        p.park(car4);
        p.park(car3);
    }
}
