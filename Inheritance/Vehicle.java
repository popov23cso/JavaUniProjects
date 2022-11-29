public abstract class Vehicle {

    protected int DoorCount;
    protected int TopSpeed;
    protected String Name;

    Vehicle(int DoorCount, int TopSpeed, String Name) {
        this.DoorCount = DoorCount;
        this.TopSpeed = TopSpeed;
        this.Name = Name;
    }

    public abstract void PrintLicence();

    public abstract void PrintVehicleInfo();
}
