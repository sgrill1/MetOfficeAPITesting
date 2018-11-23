import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFactory {

    private JSONObject JSONData;

    public JSONObject getDataAsJSON() {
        return JSONData;
    }

    public void setDataToJSON(String data) {
        JSONParser jsonParser = new JSONParser ();
        try {
            JSONData = (JSONObject) jsonParser.parse(data);
        } catch (ParseException e) {
            e.printStackTrace ();
        }
    }

}
