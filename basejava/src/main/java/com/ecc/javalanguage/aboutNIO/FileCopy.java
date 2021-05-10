package com.ecc.javalanguage.aboutNIO;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author yangshiwei
 * @Description 将项目下面resource文件夹重的test1.txt内容copy到test2.txt中
 * @date 2021/5/10-9:03
 */
public class FileCopy {
    public void copyFile(String sourceFile, String destFile) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(sourceFile);
        FileOutputStream fileOutputStream = new FileOutputStream(destFile);

        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true) {
//            重设发缓冲区
            byteBuffer.clear();

            int bufferFlag = inChannel.read(byteBuffer);

            if (bufferFlag == -1)
                break;
            byteBuffer.flip();

            outChannel.write(byteBuffer);
        }
        outChannel.close();
        inChannel.close();
    }

    public static void main(String[] args) {
        String test1 = "test1.txt";
        String test2 = "test2.txt";
        String sourceFile = FileCopy.class.getClassLoader().getResource(test1).getPath();
        System.out.println(sourceFile);
        String destFile = FileCopy.class.getClassLoader().getResource(test2).getPath();
        try {
            new FileCopy().copyFile(sourceFile, destFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
