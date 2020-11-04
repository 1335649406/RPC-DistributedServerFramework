package ServiceDiscovery.Main;

import ServiceDiscovery.center.RegistryCenter;

public class Test {
    public static void main(String[] args) throws NoSuchMethodException {
        RegistryCenter center = new RegistryCenter();
        center.startup();
//        center.shutdown();
    }
}
