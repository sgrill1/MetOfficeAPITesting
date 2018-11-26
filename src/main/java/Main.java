public class Main {

    public static void main(String[] args) {
    LocationsDataParser locationsDataParser = new LocationsDataParser ();
        System.out.println (locationsDataParser.getAllLocationIds ());
        System.out.println (locationsDataParser.getAllLocationNames ());
        System.out.println (locationsDataParser.getLocationById ("3808"));
        System.out.println (locationsDataParser.getIdByLocation ("iuhjjoi"));
    }
}
