public class Airbus extends Vehicle {

    Airbus(int DoorCount, int TopSpeed, String Name) {
        super(DoorCount, TopSpeed, Name);
    }

    public void PrintVehicleInfo() {
        System.out.println("This airbus is model " + this.Name + ". It has " + this.DoorCount + 
        " doors and its top speed is " + this.TopSpeed + " KM/h.");
    }

    public void PrintLicence() {
        System.out.println("You need to be a certified pilot in order to operate this vehicle!");
    }
}
