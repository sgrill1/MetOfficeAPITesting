import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class KeyReader {
    private String api_key;

    public KeyReader(){
        Properties properties = new Properties ();
        try {
            properties.load (new FileReader ("resources/api_key.properties"));
            api_key = properties.getProperty ("api_key");
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    //Getters
    public String getApi_key(){return api_key;}
}
