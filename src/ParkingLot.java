public class ParkingLot {
    private Floor [] floors;
    private ParkingSpot suggestedSpot;

    public ParkingLot(int NUM_OF_FLOORS, int SMALL_SPOTS_PER_FLOOR, int LARGE_SPOTS_PER_FLOOR) {
        this.floors = new Floor[NUM_OF_FLOORS];

        // Initialize each floor and parking spots in each floor
        for(int i = 0; i < NUM_OF_FLOORS; i++) {
            floors[i] = new Floor(i, SMALL_SPOTS_PER_FLOOR, LARGE_SPOTS_PER_FLOOR);
        }

    }

    public boolean findSpot(Vehicle v) {
        for(Floor f : floors) {
            suggestedSpot = f.hasSpot(v);
            if(suggestedSpot != null) {
                return true;
            }
        }
        return false;
    }

    public boolean findSmallFirst(Vehicle v) {
        for(Floor f : floors) {
            suggestedSpot = f.hasSmallSpot(v);
            if(suggestedSpot != null) {
                return true;
            }
        }
        return false;
    }

    // If the coming car is small, check small spot on each floor first.
    // If there is no small spot available, take the normal way to find an available spot.
    public void park(Vehicle v) {
        System.out.println("Car comes in: " + v.getCarType());
        if(v.getCarType() == VehicleType.SMALL) {
            if(findSmallFirst(v)) {
                System.out.println("Please park at spot #" + suggestedSpot.getSpotNumber() + " on floor " + suggestedSpot.getFloor());
                System.out.println();
                return ;
            }
        }

        if(findSpot(v)) {
            System.out.println("Please park at spot #" + suggestedSpot.getSpotNumber() + " on floor " + suggestedSpot.getFloor());
        }
        else {
            System.out.println("Sorry, the lot is full");
        }
        System.out.println();
    }

    public void carLeaves(Vehicle v) {
        for(Floor f : floors) {
            for(ParkingSpot ps : f.getSpots()) {
                if(ps.getVehicle().equals(v)) {
                    ps.releaseSpot(v);
                    break;
                }
            }
        }
        System.out.println();
    }
}
