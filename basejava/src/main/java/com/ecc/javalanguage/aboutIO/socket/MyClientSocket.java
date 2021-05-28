package com.ecc.javalanguage.aboutIO.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yangshiwei
 * @Description 客户端：
 *              1：访问服务器端
 *              2:发送一句话
 * @date 2021/5/14-15:01
 */
public class MyClientSocket implements Serializable{
    public void sendMsg(String address, int port) throws IOException {
        Socket socket = null;
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter =null;
        try {
//            1.绑定服务端端口
            socket = new Socket(address, port);

//            2.向端口发送信息
            outputStream = socket.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);

//            3.将请求信息写入输出流
            outputStreamWriter.write("this is client' request");

//            4.刷新缓存
            outputStream.flush();

            getMsg(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            if (outputStream != null) {
                outputStream.close();

            }
            if (socket != null) {
                socket.close();
            }
        }
    }

    public void getMsg(Socket socket){
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

            String serverInfo = null;

            if ((serverInfo = bufferedReader.readLine()) != null) {
                System.out.println("server request info is: " + serverInfo);
            }
            socket.shutdownInput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        try {
            new MyClientSocket().sendMsg("127.0.0.1", 8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
