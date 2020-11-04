package ServiceDiscovery.center;

import com.mec.util.proxy.MethodInvokerNotSetException;
import rmi.core.RMIClient;

public class Service {
    protected RMIClient client;
    private String ip;
    private int port;

    public Service() {
    }

    public Service(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public <T> T getProxy(Class<?> target) {
        try {
            this.client = new RMIClient(ip, port);
            return client.getProxy(target);
        } catch (InstantiationException | IllegalAccessException | MethodInvokerNotSetException e) {
        }
        return null;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }
}
