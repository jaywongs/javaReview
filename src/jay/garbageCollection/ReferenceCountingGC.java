package jay.garbageCollection;

/**
 * Created by jaywangs on 2019/4/16
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    /**
     * 占用内存以查看GC日志确认是否回收
     **/
    private byte[] bigSize = new byte[2 * _1MB];

    public void testGC() {

        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        // 回收
        System.gc();
    }
}
