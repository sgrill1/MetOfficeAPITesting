import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class KeyReader {
    private String Api_key;

    public void readApiKey(){
        Properties properties = new Properties ();
        try {
            properties.load (new FileReader ("resources/api_key.properties"));
            Api_key = properties.getProperty ("api_key");
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    //Getters
    public String getApi_key(){return Api_key;}
}
