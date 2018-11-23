import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestMain {


        private List<String> locationIdList;
        private List<String> locationNameList;

        @Before
        public void setup() {
            LocationsDataParser locationsDataParser = new LocationsDataParser ();
            locationIdList = locationsDataParser.getAllLocationIds ();
            locationNameList = locationsDataParser.getAllLocationNames ();
        }

        @Test
        public void checkNoNullIds(){
            for (String id: locationIdList) {
                Assert.assertNotNull (id);
            }
        }

        @Test
        public void checkNoNullNames(){
            for (String name: locationNameList){
                Assert.assertNotNull (name);
            }
        }

        @Test
        public void checkSameNumberOfNamesAndIds(){
            Assert.assertEquals (locationIdList.size (),locationNameList.size ());
        }
}


