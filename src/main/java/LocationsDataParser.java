public class dataParser {

    dataParser(){
        HttpManager httpManager = new HttpManager ();
        httpManager.makeARequest ();
        JSONFactory jsonFactory = new JSONFactory ();
        jsonFactory.setDataToJSON (httpManager.getData ());

    }
}
