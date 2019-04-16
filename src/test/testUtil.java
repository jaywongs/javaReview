package test;

import jay.garbageCollection.ReferenceCountingGC;
import org.junit.Test;

/**
 * Created by jaywangs on 2019/4/16
 */
public class testUtil {
    @Test
    public void  testGC() {
        ReferenceCountingGC gc = new ReferenceCountingGC();
        gc.testGC();
    }
}
