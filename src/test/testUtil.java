package test;

import jay.garbageCollection.ReferenceCountingGC;
import jay.rpc.HelloWorldImpl;
import jay.rpc.HelloWorldService;
import jay.rpc.RPCProxyClient;
import org.junit.Test;
import sun.jvm.hotspot.HelloWorld;

/**
 * Created by jaywangs on 2019/4/16
 */
public class testUtil {
    @Test
    public void  testGC() {
        ReferenceCountingGC gc = new ReferenceCountingGC();
        gc.testGC();
    }

    @Test
    public void testRPC(){
        HelloWorldService helloWorld = new HelloWorldImpl();
        helloWorld.sayHelloWorld(" testRPC");
    }

    @Test
    public void testRealRPC(){
        HelloWorldService helloWorld = (HelloWorldService) RPCProxyClient.getProxy(HelloWorldService.class);
        helloWorld.sayHelloWorld("testRealRPC");
    }
}
