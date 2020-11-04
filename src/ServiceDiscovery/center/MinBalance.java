package ServiceDiscovery.center;

import PollingSocket.CommunicationUnit;
import PollingSocket.Server;
import balance.AbstractNetNodeBalance;
import balance.INetNode;

import java.util.List;

public class MinBalance extends AbstractNetNodeBalance {
    private List<CommunicationUnit> list;

    public MinBalance(List<CommunicationUnit> list) {
        this.list = list;
    }

    @Override
    public INetNode balanceGet() {
        int min = 0;
        for (int i = 0; i < list.size(); i++) {
            CommunicationUnit communicationUnit = list.get(i);
            int connect = communicationUnit.getLoadDefinition().getConnectCount();
            if (connect < list.get(min).getLoadDefinition().getConnectCount()) {
                min = i;
            }
        }
        CommunicationUnit un = list.get(min);
        return new DefaultNetNode(un.getIp(), un.getPort());
    }
}
