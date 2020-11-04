package ServiceDiscovery.center;

import PollingSocket.IDealNetMessage;
import com.mec.util.ArgumentMaker;

public class DefaultDealNetMessage implements IDealNetMessage {
    public DefaultDealNetMessage() {
    }

    /**
     * �����ɸ�����
     *
     * @param message ���ص�gson���ַ���
     * @return
     */
    @Override
    public LoadDefinition dealNetMessage(String message) {
        return ArgumentMaker.gson.fromJson(message, LoadDefinition.class);
    }
}
