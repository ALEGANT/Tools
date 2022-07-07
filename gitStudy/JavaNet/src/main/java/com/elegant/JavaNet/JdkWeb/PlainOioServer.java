package com.elegant.JavaNet.JdkWeb;

import io.netty.util.CharsetUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

// 阻塞版本!
public class PlainOioServer {
    public void serve(int port) throws IOException{
        final ServerSocket socket = new ServerSocket(port);
        try{
            while(true){
                final Socket clientSocket = socket.accept();
                System.out.println("accept connect from " + clientSocket);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OutputStream out;
                        try{
                            out = clientSocket.getOutputStream();
                            out.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));
                            out.flush();
                            clientSocket.close();
                        }catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try{
                                clientSocket.close();
                            }catch (IOException ex){

                            }
                        }
                    }
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
