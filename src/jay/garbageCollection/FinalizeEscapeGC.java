package jay.garbageCollection;

/**
 * Created by jaywangs on 2019/4/16
 */
public class FinalizeEscapeGC {
    /**
     * 1.对象可以在被GC时自我拯救。
     * 2.这种自救的机会只有一次，因为一个对象的finalize()方法最多只会被系统自动调用一次
     **/
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("已执行finalize方法");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable{
        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        // 因为Finalizer方法优先级很低，暂停0.5秒，以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("dead now");
        }

        // 下面这段代码与上面的完全相同，但是这次自救却失败了
        SAVE_HOOK = null;
        System.gc();
        // 因为Finalizer方法优先级很低，暂停0.5秒，以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("dead now");
        }

    }
}
