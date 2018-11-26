import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestMain {


        private List<String> locationIdList;
        private List<String> locationNameList;
        private LocationsDataParser locationsDataParser;

        @Before
        public void setup() {
            LocationsDataParser locationsDataParser = new LocationsDataParser ();
            locationIdList = locationsDataParser.getAllLocationIds ();
            locationNameList = locationsDataParser.getAllLocationNames ();
        }

        //JUnit Data Tests
        @Test
        public void checkNoNullIds(){
            for (String id: locationIdList) {
                Assert.assertNotNull(id);
            }
        }
        @Test
        public void checkNoNullNames(){
            for (String name: locationNameList){
                Assert.assertNotNull(name);
            }
        }
        @Test
        public void checkSameNumberOfNamesAndIds(){
            Assert.assertEquals (locationIdList.size(),locationNameList.size());
        }

        @Test
        public void checkInvalidIds(){
            Assert.assertEquals ("invalid id", locationsDataParser.getLocationById("5"));
        }
}


