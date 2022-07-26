package com.elegant.JavaNet.NettyBuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.nio.ByteBuffer;

public class ByteBufTest {


}

class byteBufferCompositeMemory{
    ByteBuffer header = null;
    ByteBuffer body = null;
    ByteBuffer[] message = new ByteBuffer[]{header, body};
    ByteBuffer message2 = ByteBuffer.allocate(header.remaining() + body.remaining());
    message2.put(header);
    message2.put(body);
    message2.filp();
}
