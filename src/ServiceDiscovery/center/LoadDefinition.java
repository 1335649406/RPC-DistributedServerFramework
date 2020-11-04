package ServiceDiscovery.center;

import java.util.List;

public class LoadDefinition {
    private int connectCount;
//    private List<DefaultNetNode> connectList;

    public LoadDefinition(int connectCount) {
        this.connectCount = connectCount;
    }

    public void setConnectCount(int connectCount) {
        this.connectCount = connectCount;
    }

    public int getConnectCount() {
        return connectCount;
    }
}
