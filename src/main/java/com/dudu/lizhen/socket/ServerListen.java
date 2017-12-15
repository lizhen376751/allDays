package com.dudu.lizhen.socket;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/11/24.
 */
public class ServerListen extends Thread {
    @Override
    public void run(){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(12345);
            System.out.println("11111111111111");
            while(true){
                Socket socket = serverSocket.accept();
                JOptionPane.showMessageDialog(null,"有客户端连接上了12345端口");
                //将socket传递给新的线程
                new ChatSocket(socket).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
