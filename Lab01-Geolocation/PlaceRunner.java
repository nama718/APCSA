import java.util.*;
import static java.lang.System.*;

public class PlaceRunner 
{
    public static void main(String[] args)
    {
    GeoLocation g1 = new GeoLocation(33.123961,-96.798735);
    System.out.println(g1.toString());
    Place f1 = new Place("Frisco ISD Admin Building: ", "5515 Ohio Dr, Frisco, TX 75035", g1);
    Place f2 = new Place("Heritage High School: ","14040 Eldorado Pkwy, Frisco, TX 75035 ", (33.17613), (-96.75477));
    System.out.println(f1);
    System.out.println(f2);
    out.println("Distance Between: " + f1.distanceTo(f2));
   
}
}