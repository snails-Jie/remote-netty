package zhangjie.remote.netty;

import io.netty.channel.Channel;

/**
 * @Author zhangjie
 * @Date 2020/6/29 8:01
 **/
public class RequestTask implements Runnable {
    private final Runnable runnable;
    private final Channel channel;
    private final RemotingCommand request;

    public RequestTask(Runnable runnable, Channel channel, RemotingCommand request) {
        this.runnable = runnable;
        this.channel = channel;
        this.request = request;
    }

    @Override
    public void run() {
        this.runnable.run();
    }


}
