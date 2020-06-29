package zhangjie.remote.netty;

import io.netty.channel.ChannelHandlerContext;

/**
 * @Author zhangjie
 * @Date 2020/6/28 19:11
 **/
public abstract class AsyncNettyRequestProcessor implements NettyRequestProcessor {
    public void asyncProcessRequest(ChannelHandlerContext ctx, RemotingCommand request,RemotingResponseCallback responseCallback) throws Exception {
        RemotingCommand response = processRequest(ctx, request);
        responseCallback.callback(response);
    }
}
