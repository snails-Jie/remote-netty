package zhangjie.remote.common;

import io.netty.channel.Channel;

import java.net.SocketAddress;

/**
 * @Author zhangjie
 * @Date 2020/6/28 17:55
 **/
public class RemotingHelper {

    public static String parseChannelRemoteAddr(final Channel channel) {
        if (null == channel) {
            return "";
        }
        SocketAddress remote = channel.remoteAddress();
        final String addr = remote != null ? remote.toString() : "";

        if (addr.length() > 0) {
            int index = addr.lastIndexOf("/");
            if (index >= 0) {
                return addr.substring(index + 1);
            }

            return addr;
        }

        return "";
    }
}
