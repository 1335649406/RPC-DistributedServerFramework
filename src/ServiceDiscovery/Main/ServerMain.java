package ServiceDiscovery.Main;

import ServiceDiscovery.center.DefaultNetNode;
import ServiceDiscovery.center.IRegistryCenter;
import com.mec.util.proxy.MethodInvokerNotSetException;
import rmi.core.RMIClient;

public class ServerMain {
    public static void main(String[] args) {
        RMIClient client = new RMIClient("127.0.0.1", 54188);
        try {
            DefaultNetNode defaultNetNode = new DefaultNetNode("127.0.0.1", 54178);
            IRegistryCenter proxy = client.getProxy(IRegistryCenter.class);
            proxy.registryService("����", defaultNetNode);
        } catch (InstantiationException
                | IllegalAccessException | MethodInvokerNotSetException ignored) {
        }


//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Socket socket = null;
//        try {
//            socket = new Socket("127.0.0.1",54178);
//            socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
