package ServiceDiscovery.center;

import PollingSocket.CommunicationUnit;
import PollingSocket.IDealAbnormalDropped;

public class DefaultAbnormalDropped implements IDealAbnormalDropped {
    public DefaultAbnormalDropped() {
    }

    @Override
    public void dealAbnormalDropped(CommunicationUnit unit) {
        String ip = unit.getIp();
        int port = unit.getPort();
        DefaultNetNode defaultNetNode = new DefaultNetNode(ip, port);
        System.out.println(ip + ":" + port + "�������쳣���ߣ�");
        ServicePool.logout(defaultNetNode);

        unit.close();
    }
}
