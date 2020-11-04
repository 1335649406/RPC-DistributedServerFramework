package ServiceDiscovery.center;

import java.util.List;

public interface IRegistryCenter {
    void registryService(String service, DefaultNetNode netNode);

    void registryService(String[] services, DefaultNetNode netNode);

    void logout(DefaultNetNode netNode);

    List<DefaultNetNode> getService(String service);
}
