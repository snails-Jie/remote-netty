package zhangjie.remote.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import zhangjie.remote.common.RemotingUtil;
import zhangjie.remote.netty.RemotingCommand;

import java.nio.ByteBuffer;

/**
 * @Author zhangjie
 * @Date 2020/6/28 18:07
 **/
public class NettyDecoder extends LengthFieldBasedFrameDecoder {
    private static final int FRAME_MAX_LENGTH =
            Integer.parseInt(System.getProperty("com.rocketmq.remoting.frameMaxLength", "16777216"));

    public NettyDecoder() {
        super(FRAME_MAX_LENGTH, 0, 4, 0, 4);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        System.out.println("开始解码....");
        ByteBuf frame = null;
        try{
            frame = (ByteBuf) super.decode(ctx, in);
            if (null == frame) {
                return null;
            }
            ByteBuffer byteBuffer = frame.nioBuffer();

            return RemotingCommand.decode(byteBuffer);
        }catch (Exception e){
            System.out.println("decode exception");
            RemotingUtil.closeChannel(ctx.channel());
        }finally {
            if (null != frame) {
                frame.release();
            }
        }
        return null;
    }
}
