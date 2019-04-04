import java.util.ArrayList;
import java.util.List;

public class Floor {
    List<ParkingSpot> spots = new ArrayList<ParkingSpot>();

    public Floor(int floorNum, int smallSpots, int largeSpots) {
        int totalSpots = smallSpots + largeSpots;
        for(int i = 0; i < totalSpots; i++) {
            if(i < smallSpots) {
                ParkingSpot ps = new ParkingSpot(floorNum, i, VehicleType.SMALL);
                spots.add(ps);
            }
            else {
                ParkingSpot ps = new ParkingSpot(floorNum, i, VehicleType.LARGE);
                spots.add(ps);
            }
        }
    }

    public ParkingSpot hasSpot(Vehicle v) {
        for(ParkingSpot s : spots) {
            ParkingSpot curSpot = s.canPark(v);
            if(curSpot != null) {
                return curSpot;
            }
        }

        return null;
    }

    public ParkingSpot hasSmallSpot(Vehicle v) {
        for(ParkingSpot ps : spots) {
            if(ps.getSpotType() == VehicleType.SMALL) {
                ParkingSpot curSpot = ps.canPark(v);
                if(curSpot != null) {
                    return curSpot;
                }
            }
        }
        return null;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }
}
