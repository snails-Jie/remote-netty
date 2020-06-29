package zhangjie.remote.netty;

import io.netty.channel.ChannelHandlerContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import zhangjie.remote.conf.NettyServerConfig;

import java.util.concurrent.Executors;

/**
 * @Author zhangjie
 * @Date 2020/6/29 8:25
 **/
public class RemotingServerTest {

    private static NettyRemotingServer remotingServer;

    public static NettyRemotingServer createRemotingServer(){
        NettyServerConfig config = new NettyServerConfig();
        NettyRemotingServer remotingServer = new NettyRemotingServer(config);
        remotingServer.registerProcessor(0,new AsyncNettyRequestProcessor(){
            @Override
            public RemotingCommand processRequest(ChannelHandlerContext ctx, RemotingCommand request) throws Exception {
                System.out.println("处理请求.....");
                return request;
            }
        },Executors.newCachedThreadPool());
        remotingServer.start();
        return remotingServer;
    }

    @BeforeClass
    public static void setup() {
        remotingServer = createRemotingServer();
    }

    @AfterClass
    public static void destroy() {
        remotingServer.shutdown();
    }


    @Test
    public void testInvokeSync() throws InterruptedException {
        System.out.println("启动成功");
        Thread.sleep(1000*60*60);
    }



}
