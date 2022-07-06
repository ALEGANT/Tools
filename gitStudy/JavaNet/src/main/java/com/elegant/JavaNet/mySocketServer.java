package com.elegant.JavaNet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class mySocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket clientSocket = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        String request,response;
        while((request = in.readLine()) != null){
            if("Done".equals(request)){
                break;
            }
            response = processRequest(request);
            out.println(response);
        }
    }

    private static String processRequest(String request) {
        return "";

    }

}