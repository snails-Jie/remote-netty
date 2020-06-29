package zhangjie.remote.conf;

/**
 * @Author zhangjie
 * @Date 2020/6/28 17:11
 **/
public class NettySystemConfig {
    public static final String COM_ROCKETMQ_REMOTING_SOCKET_SNDBUF_SIZE =
            "com.rocketmq.remoting.socket.sndbuf.size";
    public static final String COM_ROCKETMQ_REMOTING_SOCKET_RCVBUF_SIZE =
            "com.rocketmq.remoting.socket.rcvbuf.size";

    public static int socketSndbufSize =
            Integer.parseInt(System.getProperty(COM_ROCKETMQ_REMOTING_SOCKET_SNDBUF_SIZE, "65535"));
    public static int socketRcvbufSize =
            Integer.parseInt(System.getProperty(COM_ROCKETMQ_REMOTING_SOCKET_RCVBUF_SIZE, "65535"));
}
