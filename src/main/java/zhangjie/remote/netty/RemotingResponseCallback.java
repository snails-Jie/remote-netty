package zhangjie.remote.netty;

/**
 * @Author zhangjie
 * @Date 2020/6/29 8:13
 **/
public interface RemotingResponseCallback {
    void callback(RemotingCommand response);
}
