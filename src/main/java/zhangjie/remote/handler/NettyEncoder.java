package zhangjie.remote.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import zhangjie.remote.common.RemotingUtil;
import zhangjie.remote.netty.RemotingCommand;

import java.nio.ByteBuffer;

/**
 * @Author zhangjie
 * @Date 2020/6/28 17:22
 **/
@ChannelHandler.Sharable
public class NettyEncoder extends MessageToByteEncoder<RemotingCommand> {
    @Override
    protected void encode(ChannelHandlerContext ctx, RemotingCommand remotingCommand, ByteBuf out) throws Exception {
        System.out.println("开始编码....");
        try{
            ByteBuffer header = remotingCommand.encodeHeader();
            out.writeBytes(header);
            byte[] body = remotingCommand.getBody();
            if (body != null) {
                out.writeBytes(body);
            }
        }catch (Exception e){
            RemotingUtil.closeChannel(ctx.channel());
        }

    }




}
