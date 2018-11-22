import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.Closeable;
import java.io.IOException;

public class HttpManager {
    private String Data;
    private String APIkey;
    private String baseURL;
    private String resource;
    private String datatype; //allowed types json or xml

    public HttpManager() {
        KeyReader keyReader = new KeyReader ();
        APIkey = "?key=APIkey" + keyReader.getApi_key ();
        datatype = "json";
        baseURL = "http://datapoint.metoffice.gov.uk/public/data/resource?key=APIkey";
        resource = "val/wxobs/all/" + datatype + "/sitelist";
    }

    public void makeARequest(){
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault ();
            HttpGet requestData = new HttpGet (baseURL + resource + APIkey);
            CloseableHttpResponse response = httpClient.execute (requestData);
            Data = EntityUtils.toString (response.getEntity ());

        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
