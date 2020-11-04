package ServiceDiscovery.center;

import balance.INetNode;

import java.util.Objects;

public class DefaultNetNode implements INetNode {
    private String ip;
    private int port;

    public DefaultNetNode(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return this.ip;
    }

    public int getPort() {
        return this.port;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("调用equals方法");
        if (this == o) return true;
        if (!(o instanceof DefaultNetNode)) return false;
        DefaultNetNode that = (DefaultNetNode) o;
        return getPort() == that.getPort() &&
                Objects.equals(getIp(), that.getIp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIp(), getPort());
    }
}
