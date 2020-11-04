package ServiceDiscovery.center;

import PollingSocket.IDealAbnormalDropped;
import PollingSocket.IDealNetMessage;
import balance.INetNodeBalance;
import com.mec.util.PropertiesParser;
import PollingSocket.Server;
import rmi.core.RMIFactory;
import rmi.core.RMIServer;

public class RegistryCenter {
    private IDealAbnormalDropped dealAbnormalDropped;
    private IDealNetMessage dealNetMessage;
    private INetNodeBalance netNodeBalance;

    private Server nioServer;
    private static int nioServerPort;
    private RMIServer rmiServer;
    private static int serverPort;

    static {
        readCfg();
        RMIFactory.scanMapping("/RegistryCenterMapping.xml");
    }

    public RegistryCenter() {
        this.nioServer = new Server();
        this.nioServer.setPort(nioServerPort);
        this.rmiServer = new RMIServer(serverPort);

        this.dealAbnormalDropped = new DefaultAbnormalDropped();
        this.nioServer.setDealAbnormalDropped(dealAbnormalDropped);
        this.dealNetMessage = new DefaultDealNetMessage();
        this.nioServer.setDealNetMessage(dealNetMessage);
        this.netNodeBalance = new MinBalance(nioServer.getCommunicationUnits());
    }

    private static void readCfg() {
        PropertiesParser parser = new PropertiesParser();
        parser.loadProperties("/RegistryCenter.properties");
        nioServerPort = Integer.parseInt(parser.value("nioServerPort"));
        serverPort = Integer.parseInt(parser.value("serverPort"));
    }

    public void startup() {
        nioServer.startup();
        rmiServer.startup();
    }

    public void shutdown() {
        nioServer.close();
        rmiServer.shutdown();
    }

    public static void setNioServerPort(int nioServerPort) {
        RegistryCenter.nioServerPort = nioServerPort;
    }

    public static void setServerPort(int serverPort) {
        RegistryCenter.serverPort = serverPort;
    }

    public void setDealAbnormalDropped(IDealAbnormalDropped dealAbnormalDropped) {
        this.dealAbnormalDropped = dealAbnormalDropped;
    }

    public void setDealNetMessage(IDealNetMessage dealNetMessage) {
        this.dealNetMessage = dealNetMessage;
    }

    public void setNetNodeBalance(INetNodeBalance netNodeBalance) {
        this.netNodeBalance = netNodeBalance;
    }
}
