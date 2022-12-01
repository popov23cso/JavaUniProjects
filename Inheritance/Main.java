import java.util.*;



public class Main {
    

    public static void main(String[] args) {
        Vehicle volvo = new Volvo(4, 180, "E60");
        Vehicle airbus = new Airbus(8, 871, "A320");
        List<Vehicle> l = new ArrayList<Vehicle>();
        l.add(airbus);
        l.add(volvo);

        for(int i = 0; i < l.size(); i++) {
            PrintVehicle(l.get(i));
            System.out.println("");
        }

    }


    public static void PrintVehicle(Vehicle v) {
        v.PrintVehicleInfo();
        v.PrintLicence();
    }




}
