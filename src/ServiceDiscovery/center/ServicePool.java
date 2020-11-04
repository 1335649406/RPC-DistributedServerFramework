package ServiceDiscovery.center;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServicePool {
    private static Map<String, List<DefaultNetNode>> servicePool = new ConcurrentHashMap<>();
    private static Map<DefaultNetNode, List<String>> netNodePool = new ConcurrentHashMap<>();

    public ServicePool() {
    }

    static void addService(String service, DefaultNetNode netNode) {
        if ("".equals(service) || netNode == null) {
            return;
        }
        List<DefaultNetNode> netNodes = servicePool.computeIfAbsent(service, k -> new ArrayList<>());
        netNodes.add(netNode);

        List<String> strings = netNodePool.computeIfAbsent(netNode, k -> new ArrayList<>());
        strings.add(service);
    }

    static void addServices(DefaultNetNode netNode, String[] services) {
        for (String service : services) {
            addService(service, netNode);
        }
    }

    static List<DefaultNetNode> getService(String service) {
        return servicePool.get(service);
    }

    static void logout(DefaultNetNode netNode) {
        List<String> services = netNodePool.remove(netNode);
        if (services == null) {
            return;
        }
        for (String service : services) {
            List<DefaultNetNode> netNodes = servicePool.get(service);
            if (netNodes == null) {
                continue;
            }
            netNodes.remove(netNode);
        }
    }

}
