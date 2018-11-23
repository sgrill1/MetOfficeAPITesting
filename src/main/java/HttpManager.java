import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

public class HttpManager {
    private String data;
    private String APIkey;
    private String baseURL;


    public HttpManager() {
        KeyReader keyReader = new KeyReader ();
        APIkey = "?key=" + keyReader.getApi_key();
        baseURL = "http://datapoint.metoffice.gov.uk/public/data/val/wxobs/all/json/sitelist";
    }

    public void makeARequest(){
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault ();
            HttpGet requestData = new HttpGet (baseURL + APIkey);
            CloseableHttpResponse response = httpClient.execute(requestData);
            data = EntityUtils.toString(response.getEntity ());

        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public String getData() {return data;}
    public String getAPIkey(){return APIkey;}
    public String getBaseURL() {return baseURL;}
}
