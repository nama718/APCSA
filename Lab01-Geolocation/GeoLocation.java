import java.util.*;
import static java.lang.System.*;
public class GeoLocation extends Tester

{
   private double latitude;
   private double longitude;
    public  GeoLocation(double lati, double longi)
   {
       latitude = lati;
       longitude = longi;
    } 
   public String toString()
   {
       return "latitude " + latitude + "(longitude: " + longitude + ")";
       
    }  
   public double distanceTo(GeoLocation other)
   {
       double lat1 = Math.toRadians(latitude);
       double long1 = Math.toRadians(longitude);
       double lat2 = Math.toRadians(other.latitude);
       double long2 = Math.toRadians(other.longitude);
       double theCos = Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) *
       Math.cos(lat2) * Math.cos(long1 -long2);
       double arcLength = Math.acos(theCos);
       return arcLength * 3963.1676;
    }
}

