import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class LocationsDataParser {

    private String locationId;
    private JSONObject locationsJSON;
    private List<String> locationIdList;
    private List<String> locationNameList;
    private HashMap<Integer,String> idNameHashMap;

    public LocationsDataParser(){
        HttpManager httpManager = new HttpManager();
        httpManager.makeARequest();
        JSONFactory jsonFactory = new JSONFactory();
        jsonFactory.setDataToJSON(httpManager.getData());

        locationsJSON = jsonFactory.getDataAsJSON ();
    }

    //Data Accessors
    public String getLocationId() {
        locationId = JsonPath.read(locationsJSON, "$.Locations.Location[0].id");
        return locationId;
    }
    public List<String> getAllLocationIds(){
        locationIdList = JsonPath.read(locationsJSON,"$.Locations.Location[*].id");
        return locationIdList;
    }
    public List<String> getAllLocationNames(){
        locationNameList = JsonPath.read (locationsJSON, "$.Locations.Location[*].name");
        return locationNameList;
    }
    public int getLocationIdListSize(){return locationIdList.size ();}

    public int getLocationNameListSize(){return locationNameList.size ();}

    public String getLocationById(String id){
        if (locationIdList.contains(id))
            return locationNameList.get(Integer.parseInt(findIdInList(id)));
        else
            return "invalid id";
    }

    public String getIdByLocation(String name){
        if(locationNameList.contains(name))
            return locationIdList.get(Integer.parseInt(findNameInList(name)));
        else
            return "invalid name";
    }

    //Helpers
    private String findIdInList(String id){
        return Integer.toString (locationIdList.indexOf(id));
    }

    private String findNameInList(String name){
        return Integer.toString (locationNameList.indexOf(name));
    }

    public void populateHashMap(){
        for (String id: locationIdList){
            for (String name: locationNameList){
                idNameHashMap.put(Integer.parseInt(id), name);
            }
        }
    }

    public HashMap<Integer, String> getIdNameHashMap(){
        return idNameHashMap;
    }
}

