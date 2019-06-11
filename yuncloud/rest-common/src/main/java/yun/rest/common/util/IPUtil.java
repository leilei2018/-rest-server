package yun.rest.common.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPUtil {

    public static String getInetAddress(){
        String hostAddress = null;
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            hostAddress = "unkown";
        }
        return hostAddress;
    }

}
