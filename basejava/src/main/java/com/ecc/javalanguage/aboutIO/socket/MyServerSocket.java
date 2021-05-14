package com.ecc.javalanguage.aboutIO.socket;

import com.mysql.cj.PingTarget;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yangshiwei
 * @Description 服务端
 *              1:接收客户端请求
 *              2:输出客户端发来的消息
 * @date 2021/5/14-14:41
 */
public class MyServerSocket {
    private int port;
    private ServerSocket serverSocket;

    public MyServerSocket(int port) {
        this.port = port;
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getRequest() {
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {
//            获取输入流，接受客户端传递的消息
            inputStream = serverSocket.accept().getInputStream();
//            提高效率
            inputStreamReader = new InputStreamReader(inputStream);
//            加入缓冲区
            bufferedReader = new BufferedReader(inputStreamReader);

            String clientInfo = null;

            if ((clientInfo = bufferedReader.readLine()) != null) {
                System.out.println("client request info is: " + clientInfo + "Client's ip : " + serverSocket.getInetAddress().getHostAddress());
            }

            serverSocket.accept().shutdownInput();

            try {
                sendResponse(serverSocket);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            服务端的资源必须关闭
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendResponse(ServerSocket serverSocket){
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        try {
            outputStream = serverSocket.accept().getOutputStream();

            outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write("Get your messages successfully");
            outputStreamWriter.flush();
            serverSocket.accept().shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) throws Exception {
        System.out.println("客户端已启动");

        new MyServerSocket(8080).getRequest();

    }
}
