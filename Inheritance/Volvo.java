public class Volvo extends Vehicle {

    Volvo(int DoorCount, int TopSpeed, String Name) {
        super(DoorCount, TopSpeed, Name);
    }

    public void PrintVehicleInfo() {
        System.out.println("This volvo is model " + this.Name + ". It has " + this.DoorCount + 
        " doors and its top speed is " + this.TopSpeed + " KM/h.");
    }

    public void PrintLicence() {
        System.out.println("You need category B in order to drive volvo`s sedan!");
    }
}
