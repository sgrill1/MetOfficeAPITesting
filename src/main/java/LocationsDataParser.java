import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class LocationsDataParser {

    private String locationId;
    private JSONObject locationsJSON;
    private List<String> locationIdList;
    private List<String> locationNameList;

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
    public int getLocationIdListSize(){
        return locationIdList.size ();
    }
    public int getLocationNameListSize(){
        return locationNameList.size ();
    }
}

