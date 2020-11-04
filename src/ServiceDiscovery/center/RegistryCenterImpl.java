package ServiceDiscovery.center;

import java.util.List;

public class RegistryCenterImpl implements IRegistryCenter {
    public RegistryCenterImpl() {
    }

    @Override
    public void registryService(String service, DefaultNetNode netNode) {
        ServicePool.addService(service, netNode);
    }

    @Override
    public void registryService(String[] services, DefaultNetNode netNode) {
        ServicePool.addServices(netNode, services);
    }

    @Override
    public void logout(DefaultNetNode netNode) {
        ServicePool.logout(netNode);
    }

    @Override
    public List<DefaultNetNode> getService(String service) {
        return ServicePool.getService(service);
    }
}
