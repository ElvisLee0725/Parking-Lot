public class ParkingSpot {
    private VehicleType spotType;
    private int floorNumber;
    private int spotNumber;
    private boolean isParked;
    private Vehicle vehicleParked;

    public ParkingSpot(int f, int spotNumber, VehicleType vt) {
        this.spotType = vt;
        this.floorNumber = f;
        this.spotNumber = spotNumber;
        this.isParked = false;
    }

    public ParkingSpot canPark(Vehicle v) {
        if(!isParked) {
            if(spotType == v.getCarType() || spotType == VehicleType.LARGE) {
                isParked = true;
                vehicleParked = v;
                return this;
            }
            return null;
        }
        return null;
    }

    public void releaseSpot(Vehicle v) {
        vehicleParked = null;
        isParked = false;
        System.out.println("Car leaves at Spot #" + getSpotNumber() + " on floor " + getFloor());
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public int getFloor() {
        return floorNumber;
    }

    public Vehicle getVehicle() {
        return vehicleParked;
    }

    public VehicleType getSpotType() {
        return spotType;
    }
}
