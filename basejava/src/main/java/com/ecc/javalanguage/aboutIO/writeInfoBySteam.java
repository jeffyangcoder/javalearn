package com.ecc.javalanguage.aboutIO;

import java.io.*;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/4/30-15:04
 */
public class writeInfoBySteam {
    public void writeInfo(String filePath) {
        File file = new File(filePath);
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            String outInfo = "再次测试.";
            byte[] infos = outInfo.getBytes();
            try {
                out.write(infos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\yangshiwei\\Desktop\\Java\\javalanguage\\javalearn\\basejava\\src\\main\\resources\\test.txt";
        new writeInfoBySteam().writeInfo(filePath);
    }
}
