import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class LocationsDataParser {

    private String location;
    private JSONArray locationsJSONRArray;
    private JSONObject locationsJSON;

    LocationsDataParser(){
        HttpManager httpManager = new HttpManager();
        httpManager.makeARequest();
        JSONFactory jsonFactory = new JSONFactory();
        jsonFactory.setDataToJSON(httpManager.getData());

        locationsJSON = jsonFactory.getDataAsJSON ();
        location = JsonPath.read(locationsJSON, "$.Locations.Location[0].id");
    }

    public String getLocation() {
        return location;
    }
}

